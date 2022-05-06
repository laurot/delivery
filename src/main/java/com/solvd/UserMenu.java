package com.solvd;

import java.util.Scanner;
import com.solvd.user.User;

import org.apache.logging.log4j.*;

public class UserMenu {
    
    
    private static Scanner sc = new Scanner(System.in);
    private static final Logger Log = LogManager.getLogger();
    
    public void uMenu(User user){

        Log.info("Menu:");
        Log.info("1.Make order");
        Log.info("2.Add Address");
        Log.info("3.Add Pay method");
        Log.info("4.Change Language");
        Log.info("0.Exit");
        Log.info("----------------------------------------------");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                
                break;
            case 2:
                
                break;
            case 3:
                
                break;
            case 4:
                
                break;
            case 0:

                break;
            default:
                break;
        }

    }
}
