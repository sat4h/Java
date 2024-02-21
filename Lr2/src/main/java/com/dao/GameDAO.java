package com.dao;

import com.model.Game;

import java.util.List;

public interface GameDAO {
    List<Game> allGames();
    void add(Game game);
    void delete(Game game);
    void edit(Game game);
    Game getById(int id);
}