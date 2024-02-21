package com.service;

import com.dao.EnergyDAO;
import com.dao.EnergyDAOImpl;
import com.model.Energy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EnergyServiceImpl implements EnergyService {
    private EnergyDAO energyDAO;

    @Autowired
    public void setEnergyDAO(EnergyDAO energyDAO) {
        this.energyDAO = energyDAO;
    }
    @Override
    @Transactional
    public List<Energy> allEnergys() {
        return energyDAO.allEnergys();
    }
    @Transactional
    @Override
    public void add(Energy energy) {
        energyDAO.add(energy);
    }
    @Transactional
    @Override
    public void delete(Energy energy) {
        energyDAO.delete(energy);
    }
    @Transactional
    @Override
    public void edit(Energy energy) {
        energyDAO.edit(energy);
    }
    @Transactional
    @Override
    public Energy getById(int id) {
        return energyDAO.getById(id);
    }
}