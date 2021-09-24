package com.example.apicrud.apicrud.services;

import com.example.apicrud.apicrud.entities.CarEntitiy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarService {
    CarEntitiy addCar(CarEntitiy param);

    List<CarEntitiy> getAllCar();

    CarEntitiy getCarById(int id);

    CarEntitiy updateCar(CarEntitiy param);

    void deleteCarById(int id);
}
