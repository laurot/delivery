package com.solvd.service;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.solvd.bin.orders.Delivery;


public class JaxBStuff {
    
    public static Delivery getDelivery(){
        
        try {
            File file = new File("src/main/resources/Delivery.xml");
            JAXBContext jaxbContext =JAXBContext.newInstance(Delivery.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

            Delivery delivery = (Delivery) unmarshaller.unmarshal(file);
            return delivery;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void setDelivery(Delivery delivery){
        
        try {
            File file = new File("src/main/resources/Delivery.xml");
            JAXBContext jaxbContext =JAXBContext.newInstance(Delivery.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.marshal(delivery, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
