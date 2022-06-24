package com.solvd.service.myBatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.*;
import com.solvd.bin.orders.DeliveryProducts;
import com.solvd.bin.stores.Inventory;
import com.solvd.bin.stores.Store;
import com.solvd.dao.IInventoryDAO;
import com.solvd.service.IInventoryServices;
import com.solvd.util.Input;

public class InventoryServices extends Services implements IInventoryServices{

    private static final Logger Log = LogManager.getLogger();
    
    @Override
    public List<DeliveryProducts> getCart(Store store) {
        try (SqlSession session = getSession()) {
            IInventoryDAO inventoryDAO = session.getMapper(IInventoryDAO.class);
            List<Inventory> stock = inventoryDAO.getInventoryByStoreId(store.getId());
            List<DeliveryProducts> cart = new ArrayList<DeliveryProducts>();
            do{
                Log.info("What do you want to buy?");
                Log.info("0. Checkout");
                int i = 1;
                for (Inventory product : stock) {
                    Log.info(i+". " + product.getProduct().getName() + " ----- $" + 
                        product.getProduct().getPrice() * store.getAddress().getCity().getCountry().getPriceMult());
                    i++;
                }
                int choice = Input.getInput().sc.nextInt();
        
                if (choice == 0){
                    if(cart.isEmpty()) return null;
                    else return cart;
                }
        
                Log.info("How many?");
                int amount = Input.getInput().sc.nextInt();
                DeliveryProducts item = new DeliveryProducts(stock.get(choice-1).getProduct(), amount);
                cart.add(item);
            }while(true);
        }
    }
    
}
