package com.solvd;

import com.solvd.bin.stores.Inventory;
import com.solvd.dao.IInventoryDAO;
import com.solvd.dao.jdbcMySQL.InventoryDAO;
import com.solvd.service.JacksonStuff;
import com.solvd.service.daoServices.UserServices;
import com.solvd.service.interfaces.IUserServices;
import com.solvd.util.Input;
import org.apache.logging.log4j.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class App 
{
    private static final Logger Log = LogManager.getLogger();
    public static void main( String[] args )
    {

        try {
            IUserServices userServices = new UserServices();
            Log.info("Menu:");
            Log.info("1.User login");
            Log.info("2.Driver Login");
            Log.info("3.Store Login");
            Log.info("4.Register");
            Log.info("0.Exit");
            Log.info("----------------------------------------------");
            int choice = Input.getInput().sc.nextInt();
            Input.getInput().sc.nextLine();
            switch (choice) {
                case 1:
                    userServices.userLogin();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    userServices.createUser();
                    break;
                default:
                    break;
        }
        } catch (InputMismatchException e) {
            Log.info("input type is incorrect");
            Input.getInput().sc.nextLine();
        }
        main(args);
        //You have to move this up so it can work
        jacksonMethod();
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
