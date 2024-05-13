package com.example.selectCar.service.mapper;

import com.example.selectCar.model.Car;
import com.example.selectCar.model.dtos.CarRequestDto;
import com.example.selectCar.model.dtos.CarResponseDto;
import org.springframework.stereotype.Service;

@Service
public class CarMapper {


    public Car requestToEntity(CarRequestDto carRequestDto){
        Car renault = new Car();
        renault.setBuyerId(carRequestDto.getBuyerId());
        renault.setColour(carRequestDto.getColour());
        renault.setWindows(carRequestDto.getWindows());
        renault.setLeatherSeats(carRequestDto.isLeatherSeats());
        renault.setSatNav(carRequestDto.isSatNav());
        return renault;
    }

    public CarResponseDto entityToResponse (Car car){
        CarResponseDto renaultData = new CarResponseDto();
        renaultData.setBuyerId(car.getBuyerId());
        renaultData.setColour(car.getColour());
        renaultData.setWindows(car.getWindows());
        renaultData.setLeatherSeats(car.isLeatherSeats());
        renaultData.setSatNav(car.isSatNav());
        renaultData.setWeight(car.getWeight());
        renaultData.setPrice(car.getPrice());
            return renaultData;
        }






}



