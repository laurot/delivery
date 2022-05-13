package com.solvd.service;

import org.apache.logging.log4j.*;
import java.util.Scanner;

public class Resgister {
    
    private static final Logger Log = LogManager.getLogger();
    private static Scanner sc = new Scanner(System.in);

    public void createUser(){

        Log.info("username:");
        String username = sc.nextLine();
        Log.info("password:");
        String pass = sc.nextLine();
        Log.info("email:");
        String email = sc.nextLine();
            
    }
}
