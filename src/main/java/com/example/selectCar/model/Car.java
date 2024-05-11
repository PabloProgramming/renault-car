package com.example.selectCar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    private long buyerId;
    private int wheels;
    private int lenght;
    private int width;
    private int engine;
    private int platformWeight;
    private String colour;
    private boolean leatherSeats;
    private String windows;
    private int price;
    private int basePrice;
    private int weight;
    private boolean satNav;
}
