/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.dao;

import com.javamaster.config.DBConnectionConfig;
import com.javamaster.model.EnergyModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yepp
 */
public class EnergyDAO {
    
    public static EnergyDAO instance;
    
    private EnergyDAO() {
        
    }
    
    public static synchronized EnergyDAO getInstance() {
        if(instance == null) {
            instance = new EnergyDAO();
        }
        return instance;
    }
    
    public void save2(EnergyModel energy) {
        Connection connection = DBConnectionConfig.getConnection();
        try {
        PreparedStatement pr = connection.prepareStatement("insert into energy_drinks"
        + " (title, cost, rate) values (?, ?, ?)");
        pr.setString(1, energy.getTitle());
        pr.setFloat(2, energy.getCost());
        pr.setFloat(3, energy.getRate());
        pr.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger (EnergyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<EnergyModel> getAllEnergys() {
    List<EnergyModel> energys = new ArrayList<>();
    Connection connection = DBConnectionConfig.getConnection();
    
    try (PreparedStatement pr = connection.prepareStatement("SELECT * FROM energy_d"
            + "rinks");
         ResultSet rs = pr.executeQuery()) {
        
        while (rs.next()) {
            EnergyModel energy = new EnergyModel();
            energy.setId(rs.getInt("id"));
            energy.setTitle(rs.getString("title"));
            energy.setCost(rs.getFloat("cost"));
            energy.setRate(rs.getFloat("rate"));
            energys.add(energy);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(EnergyDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return energys;
}
     public void deleteById2(int id) {
        Connection connection = DBConnectionConfig.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement("DELETE FROM energy_drinks WHERE id = ?");
            pr.setInt(1, id);
            pr.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(EnergyDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public EnergyModel getEnergyById(int id) {
    Connection connection = DBConnectionConfig.getConnection();
    EnergyModel energy = null;
    try (PreparedStatement pr = connection.prepareStatement("SELECT * FROM energy_drinks WHERE id = ?")) {
        pr.setInt(1, id);
        ResultSet rs = pr.executeQuery();
        
        if (rs.next()) {
            energy = new EnergyModel();
            energy.setId(rs.getInt("id"));
            energy.setTitle(rs.getString("title"));
            energy.setCost(rs.getFloat("cost"));
            energy.setRate(rs.getFloat("rate"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(EnergyDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return energy;
}
    
public void edit2(EnergyModel energy) {
    Connection connection = DBConnectionConfig.getConnection();
    try {
        PreparedStatement pr = connection.prepareStatement("UPDATE energy_drinks SET title=?, cost=?, rate=? WHERE id=?");
        pr.setString(1, energy.getTitle());
        pr.setFloat(2, energy.getCost());
        pr.setFloat(3, energy.getRate());
        pr.setInt(4, energy.getId());
        pr.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(EnergyDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}    
    
   
}
