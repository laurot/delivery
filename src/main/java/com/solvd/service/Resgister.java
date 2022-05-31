package com.solvd.service;

import org.apache.logging.log4j.*;
import java.util.Scanner;

import com.solvd.dao.IUserDAO;
import com.solvd.dao.jdbcMySQL.UserDAO;

public class Resgister {
    
    private static final Logger Log = LogManager.getLogger();
    private static Scanner sc = new Scanner(System.in);
    private IUserDAO userDAO = new UserDAO();

    public void createUser(){

        Log.info("username:");
        String username = sc.nextLine();
        if (userDAO.getUserByUsername(username).exists()) {
            
        };
        Log.info("password:");
        String pass = sc.nextLine();
        Log.info("email:");
        String email = sc.nextLine();
        
    }
}
