package com.solvd;

import com.solvd.bin.stores.Inventory;
import com.solvd.bin.user.User;
import com.solvd.dao.IInventoryDAO;
import com.solvd.dao.IUserDAO;
import com.solvd.dao.jdbcMySQL.InventoryDAO;
import com.solvd.dao.mybatisDAO.UserDAO;
import com.solvd.service.JacksonStuff;
import com.solvd.service.Resgister;
import com.solvd.service.UserMenu;
import com.solvd.util.Input;
import org.apache.logging.log4j.*;
import java.util.ArrayList;
import java.util.List;

public class App 
{
    private static final Logger Log = LogManager.getLogger();
    public static void main( String[] args )
    {

        jacksonMethod();

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
                Log.info("Login:");
                Log.info("insert username:");
                String username = Input.getInput().sc.nextLine();
                Log.info("----------------------------------------------");
                IUserDAO userDAO = new UserDAO();
                Log.info("insert password:");
                User user = userDAO.getUserByUsername(username);
                if(user.getPass().equals(Input.getInput().sc.nextLine())){   
                    UserMenu uMenu = new UserMenu();
                    uMenu.uMenu(user);
                    Log.info("Session closed successfully");
                }else Log.info("Account doesn't exist");
                Log.info("----------------------------------------------");

                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                Resgister re = new Resgister();
                re.createUser();
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
