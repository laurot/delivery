package com.solvd.service.myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.*;
import com.solvd.bin.location.Address;
import com.solvd.bin.orders.Delivery;
import com.solvd.bin.orders.DeliveryProducts;
import com.solvd.bin.stores.Store;
import com.solvd.bin.user.User;
import com.solvd.dao.IUserDAO;
import com.solvd.service.ILanguageServices;
import com.solvd.service.IUserServices;
import com.solvd.service.parsers.JaxBStuff;
import com.solvd.util.Input;

public class UserServices extends Services implements IUserServices{

    private static final Logger Log = LogManager.getLogger();

    @Override
    public void userLogin() {
        try (SqlSession session = getSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            Log.info("Login:");
            Log.info("insert username:");
            String username = Input.getInput().sc.nextLine();
            Log.info("----------------------------------------------");
            Log.info("insert password:");
            User user = userDAO.getUserByUsername(username);
            if(user.getPass().equals(Input.getInput().sc.nextLine())){   
                uMenu(user);
                Log.info("Session closed successfully");
            }else Log.info("Account doesn't exist");
            Log.info("----------------------------------------------");
        }
    }
    
    @Override
    public void createUser(){
        try (SqlSession session = getSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            ILanguageServices languageService = new LanguageServices();
            User user = new User();
            Log.info("username:");
            user.setName(Input.getInput().sc.nextLine());
            Log.info("password:");
            user.setPass(Input.getInput().sc.nextLine());
            Log.info("email:");
            user.setEmail(Input.getInput().sc.nextLine());
            user.setLanguage(languageService.selectLanguage());
            Input.getInput().sc.nextLine();
            userDAO.saveEntity(user);

            Log.info("Is this a Driver or Employee?");
            Log.info("1.No, just consumer");
            Log.info("2.Driver");
            Log.info("3.Employee");
            int option = Input.getInput().sc.nextInt();
            Input.getInput().sc.nextLine();
            switch (option) {
                case 2:

                    break;
                case 3:

                    break;
            }
        }
    }
    @Override
    public void updateUser(User user){
        try (SqlSession session = getSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.updateEntity(user);
        }
    }

    @Override
    public void uMenu(User user){
        Log.info("Menu:");
        Log.info("1.Make order");
        Log.info("2.Check Orders");
        Log.info("3.Change Address");
        Log.info("4.Add Pay method");
        Log.info("5.Change email");
        Log.info("0.Exit");
        Log.info("----------------------------------------------");
        int choice = Input.getInput().sc.nextInt();
        Input.getInput().sc.nextLine();
        
        switch (choice) {
            case 1:
                makeOrder(user);
                break;
            case 2:
                Delivery delivery = JaxBStuff.getDelivery();
                Log.info(delivery.getDateTime().toString());
                //JaxBStuff.setDelivery(deliveryDAO.getEntityById(1));;
                break;
            case 3:
                Log.info("New address:");
                user.setAddress(new Address(Input.getInput().sc.nextLine()));
                break;
            case 4:
                
                break;
            case 5:
                Log.info("New email:");
                user.setEmail(Input.getInput().sc.nextLine());
                updateUser(user);
                break;
            default:
                break;
        }
        if(choice != 0) uMenu(user);
    }
    
    @Override
    public void makeOrder(User user){
        StoreServices storeServices = new StoreServices();
        DriverServices driverServices = new DriverServices();
        InventoryServices inventoryServices = new InventoryServices();
        DeliveryServices deliveryServices = new DeliveryServices();
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
