package com.solvd.dao.mybatisDAO;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.solvd.bin.stores.Inventory;
import com.solvd.dao.IInventoryDAO;
import com.solvd.util.SessionGetter;

public class InventoryDAO implements IInventoryDAO{

    @Override
    public Inventory getEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
    }

    @Override
    public void saveEntity(Inventory entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public void updateEntity(Inventory entity) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public void deleteEntityById(long id) {
        throw new UnsupportedOperationException("This method shoould be implemented");
        
    }

    @Override
    public List<Inventory> getInventoryByStoreId(Long id) {
        try (SqlSession session = SessionGetter.getInstance().getSession()) {
            IInventoryDAO inventoryDAO = session.getMapper(IInventoryDAO.class);
            return inventoryDAO.getInventoryByStoreId(id);
        }
    }
    
}
