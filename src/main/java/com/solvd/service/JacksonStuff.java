package com.solvd.service;

import java.util.List;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.io.IOException;
import com.solvd.bin.stores.Inventory;

public class JacksonStuff {
    ObjectMapper om = new ObjectMapper();

    public List<Inventory> unmarshall(){

        try {
            JavaType type = om.getTypeFactory().constructCollectionType(List.class, Inventory.class);
            List<Inventory> inventory = om.readValue(new File("src/main/resources/Inventory.json"), type);
            return inventory;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public void marshall(List<Inventory> inventory){
        File file = new File("src/main/resources/Inventory.json");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            om.writeValue(file, inventory);
        }
        catch (IOException e) {e.printStackTrace();}
        }
    }
