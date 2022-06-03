package com.solvd.dao;

import java.util.List;
import com.solvd.bin.Languages;

public interface ILanguageDAO  extends IBaseDAO<Languages>{
    
    public List<Languages> getLanguages();
}
