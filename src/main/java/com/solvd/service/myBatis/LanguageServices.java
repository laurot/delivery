package com.solvd.service.myBatis;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.*;
import com.solvd.bin.Languages;
import com.solvd.dao.ILanguageDAO;
import com.solvd.service.ILanguageServices;
import com.solvd.util.Input;

public class LanguageServices extends Services implements ILanguageServices{

    private static final Logger Log = LogManager.getLogger();
    
    @Override
    public Languages selectLanguage() {
        try (SqlSession session = getSession()) {
            ILanguageDAO languageDAO = session.getMapper(ILanguageDAO.class);
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
    
}
