package com.example.selectCar.model.dtos;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRequestDto {
    private String buyerId;
    private String colour;
    private boolean leatherSeats;
    private String windows;
    private boolean satNav;
}
