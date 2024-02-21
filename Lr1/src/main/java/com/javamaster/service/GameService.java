/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.javamaster.service;

import com.javamaster.model.GameModel;

/**
 *
 * @author yepp
 */
public interface GameService {
    void addGame(String title, Integer year, float cost, float rate);
    void deleteGameById(int id);
}
