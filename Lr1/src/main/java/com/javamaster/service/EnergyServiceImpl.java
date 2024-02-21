package com.javamaster.service;

import com.javamaster.dao.EnergyDAO;
import com.javamaster.model.EnergyModel;
import java.util.List;

public class EnergyServiceImpl implements EnergyService {
    
    private static EnergyServiceImpl instance;
    
    private EnergyServiceImpl() {
        
    }

    public static synchronized EnergyServiceImpl getInstance() {
        if(instance == null) {
            instance = new EnergyServiceImpl();
        }
        return instance;
    }

    @Override
    public void addEnergy(String title, float cost, float rate) {
        EnergyModel energy = new EnergyModel();
        energy.setTitle(title);
        energy.setCost(cost);
        energy.setRate(rate);
        EnergyDAO.getInstance().save2(energy);
    }

    @Override
    public void deleteEnergyById(int id) {
        EnergyDAO.getInstance().deleteById2(id);
    }

    public List<EnergyModel> getAllEnergys() {
        return EnergyDAO.getInstance().getAllEnergys();
    }
    
    public EnergyModel getEnergyById(int id) {
    return EnergyDAO.getInstance().getEnergyById(id);
}
    
 public void editEnergy(int id, String title, float cost, float rate) {
    EnergyModel energy = new EnergyModel();
    energy.setId(id);
    energy.setTitle(title);
    energy.setCost(cost);
    energy.setRate(rate);
    EnergyDAO.getInstance().edit2(energy);
}   
    
}