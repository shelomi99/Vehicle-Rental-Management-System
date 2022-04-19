package com.shelomi.oopcoursework.demo.service;

import com.shelomi.oopcoursework.demo.model.Car;
import com.shelomi.oopcoursework.demo.model.Motorbike;
import com.shelomi.oopcoursework.demo.model.Van;
import com.shelomi.oopcoursework.demo.model.Vehicle;
import com.shelomi.oopcoursework.demo.repository.CarRepository;
import com.shelomi.oopcoursework.demo.repository.MotorbikeRepository;
import com.shelomi.oopcoursework.demo.repository.VanRepository;
import com.shelomi.oopcoursework.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

    @Autowired
    private CarRepository carRepository;
    @Autowired
    private MotorbikeRepository bikeRepository;
    @Autowired
    private VanRepository vanRepository;
    @Autowired
    private VehicleRepository vehicleRepository;


    public void addCar( Car car){
        carRepository.save(car);
    }
    public void addBike(Motorbike bike){
        bikeRepository.save(bike);
    }
    public void addVan(Van van){
        vanRepository.save(van);
    }
    public void addVehicle(Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }
}
