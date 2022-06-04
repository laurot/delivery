package com.solvd.service.jdbcServices;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.solvd.bin.stores.Store;
import com.solvd.dao.IStoreDAO;
import com.solvd.dao.jdbcMySQL.StoreDAO;
import com.solvd.service.interfaces.IStoreServices;
import com.solvd.util.Input;

public class StoreServices implements IStoreServices{

    private static final Logger Log = LogManager.getLogger();
    private IStoreDAO storeDAO = new StoreDAO();
    
    @Override
    public Store selectStore(long id) {
        Log.info("----------------------------------------------");
        Log.info("What store do you want to buy from?");
        List<Store> stores = storeDAO.getStoresByCityId(id);
        int i = 1;
        for (Store store : stores) {
            Log.info(i+". " + store.getName() + " Address: " + store.getAddress().getAddress());
            i++;
        }
        int choice = Input.getInput().sc.nextInt();
        Store store = stores.get(choice - 1);
        return store;
    }
    
}
