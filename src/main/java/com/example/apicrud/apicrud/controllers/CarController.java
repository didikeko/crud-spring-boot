package com.example.apicrud.apicrud.controllers;

import com.example.apicrud.apicrud.entities.CarEntitiy;
import com.example.apicrud.apicrud.repositories.CarRepository;
import com.example.apicrud.apicrud.response.CommonResponGenerator;
import com.example.apicrud.apicrud.response.CommonResponse;
import com.example.apicrud.apicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    CommonResponGenerator commonResponGenerator;
    @GetMapping(value = "checkAPI")
    public CommonResponse<String> checkApi(){
        return  commonResponGenerator.successResponse("halo kakak", "succcess check API");
    }

    @PostMapping(value = "addNewCar")
    public CommonResponse<CarEntitiy> addNewCar(@RequestBody CarEntitiy param){
        try{
            CarEntitiy car = carService.addCar(param);
            return commonResponGenerator.successResponse(car, "car successfully added");
        }catch (Exception e){
            return commonResponGenerator.failedResponse(e.getMessage());
        }

    }
    @GetMapping(value = "getAllCar")
    public CommonResponse<List<CarEntitiy>> getAllCar(){
        List<CarEntitiy> car = carService.getAllCar();
        return commonResponGenerator.successResponse(car, "list of cars");
    }

    @GetMapping(value = "getById")
    public CommonResponse<CarEntitiy> getById(@RequestParam int id){
        CarEntitiy car = carService.getCarById(id);
        return commonResponGenerator.successResponse(car, "successfully get car with id = "+ id);
    }

    @PutMapping(value = "updateCar")
    public CommonResponse<CarEntitiy> updateCar(@RequestBody CarEntitiy param){
       try {
           CarEntitiy car = carService.updateCar(param);
           return commonResponGenerator.successResponse(car,"car successfully updated");
       }catch (Exception e){
           return  commonResponGenerator.failedResponse(e.getMessage());
       }
    }

    @DeleteMapping(value = "deleteCarById")
    public  CommonResponse<CarEntitiy> deleteCarById(@RequestParam int id){
        CarEntitiy car = carService.getCarById(id);
        carService.deleteCarById(id);
        return commonResponGenerator.successResponse(car, "successfully delete car with id = " + id);
    }

}
