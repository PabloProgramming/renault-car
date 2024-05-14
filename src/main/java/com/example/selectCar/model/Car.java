package com.example.selectCar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    private String buyerId;
    private int wheels;
    private int lenght;
    private int width;
    private int engine;
    private double platformWeight;
    private String colour;
    private boolean leatherSeats;
    private String windows;
    private double price;
    private int basePrice;
    private double weight;
    private boolean satNav;
}
