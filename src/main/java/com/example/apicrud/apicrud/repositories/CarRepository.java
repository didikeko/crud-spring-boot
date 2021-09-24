package com.example.apicrud.apicrud.repositories;

import com.example.apicrud.apicrud.entities.CarEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<CarEntitiy, Integer> {

}
