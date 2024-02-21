package com.service;

import com.model.Energy;

import java.util.List;

public interface EnergyService {
    List<Energy> allEnergys();
    void add(Energy energy);
    void delete(Energy energy);
    void edit(Energy energy);
    Energy getById(int id);
}