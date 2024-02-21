package com.controller;

import com.model.Energy;
import com.service.EnergyService;
import com.service.EnergyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EnergyController {

    private EnergyService energyService;

    @Autowired
    public void setEnergyService(EnergyService energyService) {
        this.energyService = energyService;
    }

    @RequestMapping(value ="/energy", method = RequestMethod.GET)
    public ModelAndView allEnergys() {
        List<Energy> energys = energyService.allEnergys();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("energy");
        modelAndView.addObject("energyList", energys);
        return modelAndView;
    }

    @RequestMapping(value = "/editEnergy/{id}", method = RequestMethod.GET)
    public ModelAndView editEnergy(@PathVariable("id") int id) {
        Energy energy = energyService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editEnergy");
        modelAndView.addObject("energy", energyService.getById(id));
        return modelAndView;
    }

    @RequestMapping(value = "/editEnergy", method = RequestMethod.POST)
    public ModelAndView editEnergy(@ModelAttribute("energy") Energy energy) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/energy");
        energyService.edit(energy);
        return modelAndView;
    }

    @RequestMapping(value = "/addEnergy", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editEnergy");
        return modelAndView;
    }

    @RequestMapping(value = "/addEnergy", method = RequestMethod.POST)
    public ModelAndView addEnergy(@ModelAttribute("energy") Energy energy) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/energy");
        energyService.add(energy);
        return modelAndView;
    }

    @RequestMapping(value = "/deleteEnergy/{id}", method = RequestMethod.GET)
    public ModelAndView deleteEnergy(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/energy");
        Energy energy = energyService.getById(id);
        if (energy != null) {
            energyService.delete(energy);
        }
        return modelAndView;
    }
}