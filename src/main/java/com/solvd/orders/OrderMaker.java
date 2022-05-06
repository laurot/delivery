package com.solvd.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.solvd.dao.IDriverDAO;
import com.solvd.dao.IInventoryDAO;
import com.solvd.dao.IStoreDAO;
import com.solvd.dao.jdbcMySQL.DriverDAO;
import com.solvd.dao.jdbcMySQL.InventoryDAO;
import com.solvd.dao.jdbcMySQL.StoreDAO;
import com.solvd.stores.Inventory;
import com.solvd.stores.Store;
import com.solvd.user.User;
import org.apache.logging.log4j.*;

public class OrderMaker {
    
    private static Scanner sc = new Scanner(System.in);
    private static final Logger Log = LogManager.getLogger();
    private IDriverDAO driverDAO = new DriverDAO();
    private IStoreDAO storeDAO = new StoreDAO();

    public Delivery makeOrder(User user){

        Delivery order = new Delivery();
        order.setUser(user);
        order.setDestination(user.getAddress());
        order.setDriver(driverDAO.getFreeDriver());
        Log.info("----------------------------------------------");
        Log.info("What store do you want to buy from?");
        List<Store> stores = storeDAO.getStoresByCity(user.getAddress().getCity());
        int i = 0;
        for (Store store : stores) {
            Log.info(i+". " + store.getName() + " Address: " + store.getAddress().getAddress());
            i++;
        }
        int choice = sc.nextInt();
        Store store = stores.get(choice - 1);
        order.setStore(store);
        List<DeliveryProducts> cart = makeCart(store);
        if(cart.isEmpty()){
            Log.info("Your cart is empty, operation cancelled");
            return null;
        }
        order.setCart(cart);
        return order;
    }

    private List<DeliveryProducts> makeCart(Store store){
        IInventoryDAO inventoryDAO = new InventoryDAO();
        List<Inventory> stock = inventoryDAO.getInventoryByStore(store);
        List<DeliveryProducts> cart = new ArrayList<DeliveryProducts>();
        do{
        Log.info("What do you want to buy?");
        Log.info("0. Checkout");
        int i = 1;
        for (Inventory product : stock) {
            Log.info(i+". " + product.getProduct().getName() + " ----- $" +product.getProduct().getPrice());
            i++;
        }
        int choice = sc.nextInt();
        if (choice == 0){
            if(cart.isEmpty()) return null;
            else return cart;
        }
        Log.info("How many?");
        int amount = sc.nextInt();
        DeliveryProducts item = new DeliveryProducts(stock.get(choice-1).getProduct(), amount);
        cart.add(item);
        }while(true);
    }
}
