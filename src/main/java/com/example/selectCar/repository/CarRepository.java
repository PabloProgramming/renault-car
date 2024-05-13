package com.example.selectCar.repository;

import com.example.selectCar.model.Car;
import jakarta.persistence.Id;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, String> {

}
