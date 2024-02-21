package com.javamaster.service;

import com.javamaster.dao.GameDAO;
import com.javamaster.model.GameModel;
import java.util.List;

public class GameServiceImpl implements GameService {
    
    private static GameServiceImpl instance;
    
    private GameServiceImpl() {
        
    }

    public static synchronized GameServiceImpl getInstance() {
        if(instance == null) {
            instance = new GameServiceImpl();
        }
        return instance;
    }

    @Override
    public void addGame(String title, Integer year, float cost, float rate) {
        GameModel game = new GameModel();
        game.setTitle(title);
        game.setYear(year);
        game.setCost(cost);
        game.setRate(rate);
        GameDAO.getInstance().save(game);
    }

    @Override
    public void deleteGameById(int id) {
        GameDAO.getInstance().deleteById(id);
    }

    public List<GameModel> getAllGames() {
        return GameDAO.getInstance().getAllGames();
    }
    
    public GameModel getGameById(int id) {
    return GameDAO.getInstance().getGameById(id);
}
    
 public void editGame(int id, String title, Integer year, float cost, float rate) {
    GameModel game = new GameModel();
    game.setId(id);
    game.setTitle(title);
    game.setYear(year);
    game.setCost(cost);
    game.setRate(rate);
    GameDAO.getInstance().edit(game);
}   
    
}