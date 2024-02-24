package com.example.demo.controllers;

import com.example.demo.model.entity.Game;
import com.example.demo.services.GameServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import static com.example.demo.xsl.XSLTransform.getModelAndView;

@RestController
@RequestMapping(
        value = "/api",
        produces = {"application/xml", "application/json"}
)
public class GameController {
    private final GameServiceImpl energyService;

    @Autowired
    public GameController(GameServiceImpl energyService) {
        this.energyService = energyService;
    }

    @RequestMapping("/game")
    public @ResponseBody Iterable<Game> getEnergy() {
        return energyService.all();
    }

    @PostMapping("/game")
    public @ResponseBody Game createGame(@RequestBody Game game) {
        return energyService.add(game);
    }

    @DeleteMapping("/game/{id}")
    public @ResponseBody void deleteGame(@PathVariable int id) {
        energyService.delete(energyService.getById(id));
    }

    @GetMapping(path = "xsl/game")
    public @ResponseBody ModelAndView getEnergies() throws JsonProcessingException {
        Iterable<Game> list = energyService.all();
        return getModelAndView(list, "gameXSL");
    }
}
