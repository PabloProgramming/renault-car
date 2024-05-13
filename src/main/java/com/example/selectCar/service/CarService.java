package com.example.selectCar.service;

import com.example.selectCar.model.Car;
import com.example.selectCar.model.dtos.CarRequestDto;
import com.example.selectCar.model.dtos.CarResponseDto;
import com.example.selectCar.repository.CarRepository;
import com.example.selectCar.service.mapper.CarMapper;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarMapper carMapper;

    @SneakyThrows
    public CarResponseDto getRenaultById(String buyerId) {
        Optional<Car> car = carRepository.findById(buyerId);
        if (car.isPresent()) {
            return carMapper.entityToResponse(car.get());
        }
        throw new Exception();
    }

    public CarResponseDto saveCar(CarRequestDto carRequestDto) {
        Car renault = createGeneralCar();

        renault.setPrice(renault.getBasePrice() + calculateVariablePrice(carRequestDto));
        renault = carMapper.requestToEntity(carRequestDto);
        Car renaultSaved = carRepository.save(renault);
        return carMapper.entityToResponse(renaultSaved);
    }

    private Car createGeneralCar() {
        Car renault = new Car();
        renault.setBasePrice(12000);
        return renault;
    }


    private int calculateVariablePrice(CarRequestDto carRequestDto) {
        return calculatePriceByColour(carRequestDto.getColour()) +
                calculatePriceByWindow(carRequestDto.getWindows());
    }

    private int calculatePriceByColour(String colour) {
        if (colour.equalsIgnoreCase("red")) {
            return 500;
        }
        return 0;
    }

    private int calculatePriceByWindow(String window) {
        if (window.equalsIgnoreCase("tintaadas")) {
            return 200;
        }
        return 0;
    }


}

