package com.controller;

import com.model.Game;
import com.service.GameService;
import com.service.GameServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GameController {

    private GameService gameService;

    @Autowired
    public void setGameService(GameService gameService) {
        this.gameService = gameService;
    }

    @RequestMapping(value ="/games", method = RequestMethod.GET)
    public ModelAndView allGames() {
        List<Game> games = gameService.allGames();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("games");
        modelAndView.addObject("gamesList", games);
        return modelAndView;
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        Game game = gameService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("game", gameService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editGame(@ModelAttribute("game") Game game) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/games");
        gameService.edit(game);
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addGame(@ModelAttribute("game") Game game) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/games");
        gameService.add(game);
        return modelAndView;
    }

    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteGame(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/games");
        Game game = gameService.getById(id);
        gameService.delete(game);
        return modelAndView;
    }
}