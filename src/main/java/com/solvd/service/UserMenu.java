package com.solvd.service;

import com.solvd.bin.location.Address;
import com.solvd.bin.orders.Delivery;
import com.solvd.bin.user.User;
import com.solvd.dao.IUserDAO;
import com.solvd.util.Input;
import org.apache.logging.log4j.*;
//import com.solvd.dao.jdbcMySQL.DeliveryDAO;

public class UserMenu {
    
    private static final Logger Log = LogManager.getLogger();
    //private DeliveryDAO deliveryDAO = new DeliveryDAO();
    private IUserDAO userDAO = new com.solvd.dao.mybatisDAO.UserDAO();
    private OrderMaker orderMaker = new OrderMaker();
    
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
                orderMaker.makeOrder(user);
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
                userDAO.updateEntity(user);
                break;
            default:
                break;
        }
        if(choice != 0) uMenu(user);
    }
}
