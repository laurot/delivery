package com.solvd.service.daoServices;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.*;
import com.solvd.bin.stores.Store;
import com.solvd.dao.IStoreDAO;
import com.solvd.service.interfaces.IStoreServices;
import com.solvd.util.Input;

public class StoreServices extends Services implements IStoreServices {

    private static final Logger Log = LogManager.getLogger();
    @Override
    public Store selectStore(long id) {
        try (SqlSession session = getSession()) {
            IStoreDAO storeDAO = session.getMapper(IStoreDAO.class);
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
}
