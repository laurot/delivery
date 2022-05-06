package com.solvd;

import java.util.Scanner;
import com.solvd.dao.IUserDAO;
import com.solvd.dao.jdbcMySQL.BrandDAO;
import com.solvd.dao.jdbcMySQL.UserDAO;
import com.solvd.user.User;
import org.apache.logging.log4j.*;

public class App 
{
    private static final Logger Log = LogManager.getLogger();
    private static Scanner sc = new Scanner(System.in);
    public static void main( String[] args )
    {
        BrandDAO a = new BrandDAO();
        Log.info(a.getEntityById(1).getName());
        Log.info("Login:");
        Log.info("insert username:");
        Log.info("----------------------------------------------");
        String username = sc.nextLine();
        IUserDAO userDAO = new UserDAO();
        User user = userDAO.getUserByUsername(username);
        try{
            Log.info("insert password:");
            Log.info("----------------------------------------------");
            if(user.authenticate(sc.nextLine())){
                UserMenu uMenu = new UserMenu();
                uMenu.uMenu(user);
            }else Log.info("invalid password");
        }catch(NullPointerException npe){
            Log.info("user doesn't exist");
        }

    }
}
