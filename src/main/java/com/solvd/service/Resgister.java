package com.solvd.service;

import org.apache.logging.log4j.*;

import java.util.List;

import com.solvd.bin.Languages;
import com.solvd.bin.user.User;
import com.solvd.dao.ILanguageDAO;
import com.solvd.dao.IUserDAO;
import com.solvd.dao.mybatisDAO.LanguageDAO;
import com.solvd.dao.mybatisDAO.UserDAO;
import com.solvd.util.Input;

public class Resgister {
    
    private static final Logger Log = LogManager.getLogger();
    ILanguageDAO languageDAO = new LanguageDAO();
    IUserDAO userDAO = new UserDAO();

    public void createUser(){
        User user = new User();
        Log.info("username:");
        user.setName(Input.getInput().sc.nextLine());
        Log.info("password:");
        user.setPass(Input.getInput().sc.nextLine());
        Log.info("email:");
        user.setEmail(Input.getInput().sc.nextLine());
        Log.info("Select a language:");
        List<Languages> languages = languageDAO.getLanguages();
        for (Languages language : languages) {
            Log.info(language.getId() + ". " + language.getName());
        }
        user.setLanguage(languageDAO.getEntityById(Input.getInput().sc.nextInt()));;
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
