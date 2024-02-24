package com.example.demo.controllers;

import com.example.demo.model.entity.Energy;
import com.example.demo.services.EnergyServiceImpl;
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
public class EnergyController {
    private final EnergyServiceImpl energyService;

    @Autowired
    public EnergyController(EnergyServiceImpl energyRepository) {
        this.energyService = energyRepository;
    }

    @RequestMapping("/energy")
    public @ResponseBody Iterable<Energy> getEnergy() {
        return energyService.all();
    }

    @PostMapping("/energy")
    public @ResponseBody Energy createEnergy(@RequestBody Energy energy) {
        return energyService.add(energy);
    }

    @DeleteMapping("/energy/{id}")
    public @ResponseBody void deleteEnergy(@PathVariable int id) {
        energyService.delete(energyService.getById(id));
    }

    @GetMapping(path = "xsl/energy")
    public @ResponseBody ModelAndView getEnergies() throws JsonProcessingException {
        Iterable<Energy> list = energyService.all();
        System.out.println(list);
        return getModelAndView(list, "energyXSL");
    }
}
