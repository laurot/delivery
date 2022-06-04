package com.solvd.service;

import java.util.List;
import com.solvd.bin.orders.*;
import com.solvd.bin.stores.Store;
import com.solvd.bin.user.User;
import com.solvd.service.daoServices.DeliveryServices;
import com.solvd.service.daoServices.DriverServices;
import com.solvd.service.daoServices.InventoryServices;
import com.solvd.service.daoServices.StoreServices;
import com.solvd.service.interfaces.IDeliveryServices;
import com.solvd.service.interfaces.IDriverServices;
import com.solvd.service.interfaces.IInventoryServices;
import com.solvd.service.interfaces.IStoreServices;
import com.solvd.util.Input;
import org.apache.logging.log4j.*;

public class OrderMaker {
    
    private static final Logger Log = LogManager.getLogger();
    
    public void makeOrder(User user){
        IStoreServices storeServices = new StoreServices();
        IDriverServices driverServices = new DriverServices();
        IInventoryServices inventoryServices = new InventoryServices();
        IDeliveryServices deliveryServices = new DeliveryServices();
        Delivery order = new Delivery();
        
        Store store = storeServices.selectStore(user.getAddress().getCity().getId());
        List<DeliveryProducts> cart = inventoryServices.getCart(store);
        order.setUser(user);
        order.setDriver(driverServices.getFreeDriver());
        order.setStore(store);
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
        
        int choice = Input.getInput().sc.nextInt();
        Input.getInput().sc.nextLine();
        if (choice == 1) deliveryServices.saveOrder(order);
        else{
            Log.info("Your cart is empty, operation cancelled");
        }
    }


}
