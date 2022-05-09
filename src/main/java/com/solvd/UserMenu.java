package com.solvd;

import java.util.Scanner;
import com.solvd.dao.jdbcMySQL.DeliveryDAO;
import com.solvd.orders.Delivery;
import com.solvd.orders.OrderMaker;
import com.solvd.user.User;
import org.apache.logging.log4j.*;

public class UserMenu {
    
    
    private static Scanner sc = new Scanner(System.in);
    private static final Logger Log = LogManager.getLogger();
    private OrderMaker orderMaker = new OrderMaker();
    private DeliveryDAO deliveryDAO = new DeliveryDAO();

    public void uMenu(User user){

        Log.info("Menu:");
        Log.info("1.Make order");
        Log.info("2.Change Address");
        Log.info("3.Add Pay method");
        Log.info("4.Change Language");
        Log.info("0.Exit");
        Log.info("----------------------------------------------");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Delivery order = orderMaker.makeOrder(user);
                if (order.getCart().isEmpty()) {
                    Log.info("Your cart is empty, operation cancelled");
                    uMenu(user);
                }
                deliveryDAO.saveEntity(order);
                Log.info("The order has been made");
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            default:
                break;
        }
        if(choice != 0) uMenu(user);
    }
}
