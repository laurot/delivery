package com.solvd.service.daoServices;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.*;
import com.solvd.bin.user.User;
import com.solvd.dao.IUserDAO;
import com.solvd.service.UserMenu;
import com.solvd.service.interfaces.ILanguageServices;
import com.solvd.service.interfaces.IUserServices;
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
                UserMenu uMenu = new UserMenu();
                uMenu.uMenu(user);
                Log.info("Session closed successfully");
            }else Log.info("Account doesn't exist");
            Log.info("----------------------------------------------");
        }
    }
    
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

    public void updateUser(User user){
        try (SqlSession session = getSession()) {
            IUserDAO userDAO = session.getMapper(IUserDAO.class);
            userDAO.updateEntity(user);
        }
    }
}
