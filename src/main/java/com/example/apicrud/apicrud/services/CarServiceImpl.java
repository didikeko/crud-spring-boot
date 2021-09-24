package com.example.apicrud.apicrud.services;

import com.example.apicrud.apicrud.entities.CarEntitiy;
import com.example.apicrud.apicrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public CarEntitiy addCar(CarEntitiy param) {

        return carRepository.save(param);
    }

    @Override
    public List<CarEntitiy> getAllCar() {
        return carRepository.findAll();
    }

    @Override
    public CarEntitiy getCarById(int id) {
        return carRepository.findById(id).get();
    }

    @Override
    public CarEntitiy updateCar(CarEntitiy param) {
        CarEntitiy findCar = carRepository.findById(param.getId()).get();
//        findCar.setCarName(param.getCarName());
//        findCar.setColor(param.getColor());
//        findCar.setNumber(param.getNumber());
//        findCar.setType(param.getType());

        return carRepository.save(param);
    }

    @Override
    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }
}
