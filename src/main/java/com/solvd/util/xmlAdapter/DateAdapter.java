package com.solvd.util.xmlAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class DateAdapter extends XmlAdapter<String, Date>{

    @Override
    public Date unmarshal(String v) throws Exception {
        return new SimpleDateFormat("dd/mm/yyyy").parse(v);
    }

    @Override
    public String marshal(Date v) throws Exception {
        return new SimpleDateFormat("dd/mm/yyyy").format(v);
    }
    
}
