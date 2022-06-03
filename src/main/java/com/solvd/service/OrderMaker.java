package com.solvd.service;

import java.util.ArrayList;
import java.util.List;
import com.solvd.bin.orders.*;
import com.solvd.bin.stores.Inventory;
import com.solvd.bin.stores.Store;
import com.solvd.bin.user.User;
import com.solvd.dao.IDriverDAO;
import com.solvd.dao.IInventoryDAO;
import com.solvd.dao.IStoreDAO;
import com.solvd.dao.jdbcMySQL.DriverDAO;
import com.solvd.dao.jdbcMySQL.InventoryDAO;
import com.solvd.dao.jdbcMySQL.StoreDAO;
import com.solvd.util.Input;
import org.apache.logging.log4j.*;

public class OrderMaker {
    
    private static final Logger Log = LogManager.getLogger();
    private IDriverDAO driverDAO = new DriverDAO();
    private IStoreDAO storeDAO = new StoreDAO();

    public Delivery makeOrder(User user){

        Delivery order = new Delivery();
        order.setUser(user);
        order.setDriver(driverDAO.getFreeDriver());
        Log.info("----------------------------------------------");
        Log.info("What store do you want to buy from?");
        List<Store> stores = storeDAO.getStoresByCity(user.getAddress().getCity());
        int i = 1;
        for (Store store : stores) {
            Log.info(i+". " + store.getName() + " Address: " + store.getAddress().getAddress());
            i++;
        }
        int choice = Input.getInput().sc.nextInt();
        Store store = stores.get(choice - 1);
        order.setStore(store);
        List<DeliveryProducts> cart = makeCart(store);
        order.setCart(cart);
        Double total = 0.0;
        Log.info("User: " + order.getUser().getName());
        Log.info("Store: " + order.getStore().getName());
        Log.info("Order: ");
        for (DeliveryProducts item : cart) {
            Log.info(item.getProduct().getName() + " | " + item.getAmount() + " | $" + item.getProduct().getPrice());
            total = total + item.getProduct().getPrice() * item.getAmount();
        }
        total = total * user.getAddress().getCity().getCountry().getPriceMult();
        Log.info("Total price: $" + total);
        Log.info("Insert 1 to accept");
        choice = Input.getInput().sc.nextInt();
        if (choice == 1) return order;
        return null;
    }

    private List<DeliveryProducts> makeCart(Store store){
        IInventoryDAO inventoryDAO = new InventoryDAO();
        List<Inventory> stock = inventoryDAO.getInventoryByStoreId(store.getId());
        List<DeliveryProducts> cart = new ArrayList<DeliveryProducts>();
        do{
        Log.info("What do you want to buy?");
        Log.info("0. Checkout");
        int i = 1;
        for (Inventory product : stock) {
            Log.info(i+". " + product.getProduct().getName() + " ----- $" + 
                product.getProduct().getPrice() * store.getAddress().getCity().getCountry().getPriceMult());
            i++;
        }
        int choice = Input.getInput().sc.nextInt();

        if (choice == 0){
            if(cart.isEmpty()) return null;
            else return cart;
        }

        Log.info("How many?");
        int amount = Input.getInput().sc.nextInt();
        DeliveryProducts item = new DeliveryProducts(stock.get(choice-1).getProduct(), amount);
        cart.add(item);
        }while(true);
    }
}
