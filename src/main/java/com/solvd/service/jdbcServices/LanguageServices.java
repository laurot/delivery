package com.solvd.service.jdbcServices;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.bin.Languages;
import com.solvd.dao.ILanguageDAO;
import com.solvd.dao.jdbcMySQL.LanguageDAO;
import com.solvd.service.ILanguageServices;
import com.solvd.util.Input;

public class LanguageServices implements ILanguageServices{

    private static final Logger Log = LogManager.getLogger();
    private ILanguageDAO languageDAO = new LanguageDAO();
    
    @Override
    public Languages selectLanguage() {
        Log.info("Select a language:");
        List<Languages> languages = languageDAO.getLanguages();
        int i = 0;
        for (Languages language : languages) {
            i++;
            Log.info(i + ". " + language.getName());
        }
        return languages.get(Input.getInput().sc.nextInt()-1);
    }
    
}
