/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.service;

import com.javamaster.model.EnergyModel;

/**
 *
 * @author yepp
 */
public interface EnergyService {
    void addEnergy(String title, float cost, float rate);
    void deleteEnergyById(int id);
}
