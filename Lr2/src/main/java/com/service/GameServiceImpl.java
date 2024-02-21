package com.service;

import com.dao.GameDAO;
import com.dao.GameDAOImpl;
import com.model.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class GameServiceImpl implements GameService {
    private GameDAO gameDAO;

    @Autowired
    public void setGameDAO(GameDAO gameDAO) {
        this.gameDAO = gameDAO;
    }
    @Override
    @Transactional
    public List<Game> allGames() {
        return gameDAO.allGames();
    }
    @Transactional
    @Override
    public void add(Game game) {
        gameDAO.add(game);
    }
    @Transactional
    @Override
    public void delete(Game game) {
        gameDAO.delete(game);
    }
    @Transactional
    @Override
    public void edit(Game game) {
        gameDAO.edit(game);
    }
    @Transactional
    @Override
    public Game getById(int id) {
        return gameDAO.getById(id);
    }
}