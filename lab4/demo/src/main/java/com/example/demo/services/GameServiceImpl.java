package com.example.demo.services;

import com.example.demo.model.entity.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class GameServiceImpl implements IService<Game> {
    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Iterable<Game> all() {
        return gameRepository.findAll();
    }

    @Override
    public Game add(Game entity) {
        return gameRepository.save(entity);
    }

    @Override
    public void delete(Game entity) {
        gameRepository.delete(entity);
    }

    @Override
    public void edit(Game entity) {
        Game game = getById(entity.getId());
        game.setCost(entity.getCost());
        game.setRate(entity.getRate());
        game.setYear(entity.getYear());
        game.setTitle(entity.getTitle());
    }

    @Override
    public Game getById(int id) {
        System.out.println(all());
        return gameRepository.findById(id).get();
    }
}
