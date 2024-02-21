/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.dao;

import com.javamaster.config.DBConnectionConfig;
import com.javamaster.model.GameModel;
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
public class GameDAO {
    
    public static GameDAO instance;
    
    private GameDAO() {
        
    }
    
    public static synchronized GameDAO getInstance() {
        if(instance == null) {
            instance = new GameDAO();
        }
        return instance;
    }
    
    public void save(GameModel game) {
        Connection connection = DBConnectionConfig.getConnection();
        try {
        PreparedStatement pr = connection.prepareStatement("insert into games"
        + " (title, year, cost, rate) values (?, ?, ?, ?)");
        pr.setString(1, game.getTitle());
        pr.setInt(2, game.getYear());
        pr.setFloat(3, game.getCost());
        pr.setFloat(4, game.getRate());
        pr.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger (GameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public List<GameModel> getAllGames() {
    List<GameModel> games = new ArrayList<>();
    Connection connection = DBConnectionConfig.getConnection();
    
    try (PreparedStatement pr = connection.prepareStatement("SELECT * FROM games");
         ResultSet rs = pr.executeQuery()) {
        
        while (rs.next()) {
            GameModel game = new GameModel();
            game.setId(rs.getInt("id"));
            game.setTitle(rs.getString("title"));
            game.setYear(rs.getInt("year"));
            game.setCost(rs.getFloat("cost"));
            game.setRate(rs.getFloat("rate"));
            games.add(game);
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return games;
}
     public void deleteById(int id) {
        Connection connection = DBConnectionConfig.getConnection();
        try {
            PreparedStatement pr = connection.prepareStatement("DELETE FROM games WHERE id = ?");
            pr.setInt(1, id);
            pr.executeUpdate(); 
        } catch (SQLException ex) {
            Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
    public GameModel getGameById(int id) {
    Connection connection = DBConnectionConfig.getConnection();
    GameModel game = null;
    try (PreparedStatement pr = connection.prepareStatement("SELECT * FROM games WHERE id = ?")) {
        pr.setInt(1, id);
        ResultSet rs = pr.executeQuery();
        
        if (rs.next()) {
            game = new GameModel();
            game.setId(rs.getInt("id"));
            game.setTitle(rs.getString("title"));
            game.setYear(rs.getInt("year"));
            game.setCost(rs.getFloat("cost"));
            game.setRate(rs.getFloat("rate"));
        }
        
    } catch (SQLException ex) {
        Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return game;
}
    
public void edit(GameModel game) {
    Connection connection = DBConnectionConfig.getConnection();
    try {
        PreparedStatement pr = connection.prepareStatement("UPDATE games SET title=?, year=?, cost=?, rate=? WHERE id=?");
        pr.setString(1, game.getTitle());
        pr.setInt(2, game.getYear());
        pr.setFloat(3, game.getCost());
        pr.setFloat(4, game.getRate());
        pr.setInt(5, game.getId());
        pr.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(GameDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}    
    
   
}
