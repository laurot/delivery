package com.solvd;

import com.solvd.bin.stores.Inventory;
import com.solvd.bin.user.User;
import com.solvd.dao.IInventoryDAO;
import com.solvd.dao.IUserDAO;
import com.solvd.dao.jdbcMySQL.InventoryDAO;
import com.solvd.dao.jdbcMySQL.UserDAO;
import com.solvd.service.JacksonStuff;
import com.solvd.service.UserMenu;

import org.apache.logging.log4j.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App 
{
    private static final Logger Log = LogManager.getLogger();
    private static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
        //Implementation of jackson
        jacksonMethod();
        //Actual implementation
        Log.info("Menu:");
        Log.info("1.User login");
        Log.info("2.Driver Login");
        Log.info("3.Store Login");
        Log.info("4.Register");
        Log.info("0.Exit");
        Log.info("----------------------------------------------");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                Log.info("Login:");
                Log.info("insert username:");
                sc.nextLine();
                String username = sc.nextLine();
                Log.info("----------------------------------------------");
                IUserDAO userDAO = new UserDAO();
                User user = userDAO.getUserByUsername(username);            //If empty, later use will cause NullPointerException
                if(user != null){
                    Log.info("insert password:");
                    if(userDAO.authenticate(user, sc.nextLine())){   
                        UserMenu uMenu = new UserMenu();
                        uMenu.uMenu(user);
                        Log.info("Session closed successfully");
                    }else Log.info("invalid password");
                    Log.info("----------------------------------------------");
                }else Log.warn("User doesn't exist");
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
        main(args);
    }

    private static void jacksonMethod(){
        JacksonStuff jacksonStuff = new JacksonStuff();
        IInventoryDAO inventoryDAO = new InventoryDAO();
        List<Inventory> inventory = new ArrayList<Inventory>();
        inventory = inventoryDAO.getInventoryByStoreId(1L);
        jacksonStuff.marshall(inventory);
        inventory = jacksonStuff.unmarshall();
        Log.info(inventory.get(0).getProduct().getName() + inventory.get(0).getAmount());
    }
}
