package com.example.selectCar.controller;

import com.example.selectCar.model.dtos.CarRequestDto;
import com.example.selectCar.model.dtos.CarResponseDto;
import com.example.selectCar.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping ("/renault")
public class CarController {

    @Autowired
    CarService carService;


    @GetMapping
    private ResponseEntity<CarResponseDto> getCarById(@PathVariable String buyerId){
        return ResponseEntity.ok(carService.getRenaultById(buyerId));
    }

    @PostMapping ("{/your-car}")
    private ResponseEntity<CarResponseDto> saveCar (@RequestBody CarRequestDto carRequestDto){
        return ResponseEntity.ok(carService.saveCar(carRequestDto));

    }


}
