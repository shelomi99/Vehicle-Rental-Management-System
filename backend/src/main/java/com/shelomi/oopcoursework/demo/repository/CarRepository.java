package com.shelomi.oopcoursework.demo.repository;

import com.shelomi.oopcoursework.demo.model.Car;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends MongoRepository<Car,String> {
Car findByPlateNo(String plateNo);
}
