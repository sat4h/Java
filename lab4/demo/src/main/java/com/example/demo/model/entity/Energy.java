package com.example.demo.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Entity
@Table(name = "energy_drinks")
@Setter
public class Energy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "cost")
    private float cost;

    @Column(name = "rate")
    private float rate;
}