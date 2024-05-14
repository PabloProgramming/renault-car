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
        Car renault = createCar(carRequestDto);

        renault.setWeight(renault.getPlatformWeight() + calculateVariableWeight(carRequestDto));
        renault.setPrice(renault.getBasePrice() + calculateVariablePrice(carRequestDto));
        Car renaultSaved = carRepository.save(renault);
        return carMapper.entityToResponse(renaultSaved);
    }

    private Car createCar(CarRequestDto carRequestDto) {
        Car renault = new Car();
        renault.setBasePrice(12000);
        renault.setPlatformWeight(1000);
        renault.setBuyerId(carRequestDto.getBuyerId());
        renault.setColour(carRequestDto.getColour());
        renault.setWindows(carRequestDto.getWindows());
        renault.setLeatherSeats(carRequestDto.isLeatherSeats());
        renault.setSatNav(carRequestDto.isSatNav());
        return renault;
    }


    private double calculateVariablePrice(CarRequestDto carRequestDto) {
        return calculatePriceByColour(carRequestDto.getColour()) +
                calculatePriceByWindow(carRequestDto.getWindows()) + calculatePriceBySeats(carRequestDto.isLeatherSeats()) + calculatePriceBySatNav(carRequestDto.isSatNav());
    }

    private double calculatePriceByColour(String colour) {
        if (colour.equalsIgnoreCase("red")) {
            return 500;
        } else if (colour.equalsIgnoreCase("golden")) {
            return 700;

        } else if (colour.equalsIgnoreCase("silver")) {
            return 600;

        }
        return 0;
    }

    private double calculatePriceByWindow(String window) {
        if (window.equalsIgnoreCase("tempered")) {
            return 200;
        } else if (window.equalsIgnoreCase("ceramic tinted")) {
            return 250;
        } else if (window.equalsIgnoreCase("rear windshield")) {
            return 220;
        }
        return 0;
    }

    private double calculatePriceBySeats(boolean leatherSeats) {
        if (leatherSeats) {
            return 1200;
        }
        return 0;
    }

    private double calculatePriceBySatNav(boolean satNav) {
        if (satNav) {
            return 800;
        }
        return 0;
    }

    private double calculateVariableWeight(CarRequestDto carRequestDto) {
        return calculateWeightByWindow(carRequestDto.getWindows()) + calculateWeightBySeats(carRequestDto.isLeatherSeats()) + calculateWeightBySatNav(carRequestDto.isSatNav());
}

        private double calculateWeightBySeats (boolean leatherSeats){
            if (leatherSeats) {
                return 50;
            }
            return 0;
        }

        private double calculateWeightBySatNav (boolean satNav){
            if (satNav) {
                return 130;
            }
            return 0;
        }

        private double calculateWeightByWindow (String window){
            if (window.equalsIgnoreCase("tempered")) {
                return 20;
            } else if (window.equalsIgnoreCase("ceramic tinted")) {
                return 25;
            } else if (window.equalsIgnoreCase("rear windshield")) {
                return 22;
            }
            return 0;
        }


}

