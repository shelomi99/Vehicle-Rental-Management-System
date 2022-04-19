package com.shelomi.oopcoursework.demo.controller;
import com.shelomi.oopcoursework.demo.model.*;
import com.shelomi.oopcoursework.demo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VehicleController implements CommandLineRunner {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private MotorbikeRepository bikeRepository;

    @Autowired
    private VanRepository vanRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    //an API to get all the vehicles into the browser
    @CrossOrigin
    @RequestMapping("/findAllVehicles")
    public List<Vehicle> getVehicle() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleRepository.findAll().forEach(vehicleList::add);
        return vehicleList;
    }
    //an API to get find the cars in the browser
    @CrossOrigin
    @RequestMapping("/findAllCars")
    public List<Car> getCars() {
        List<Car> carList = new ArrayList<>();
        carRepository.findAll().forEach(carList::add);
        return carList;
    }
    //an API to get find the bikes in the browser
    @CrossOrigin
    @RequestMapping("/findAllBikes")
    public List<Motorbike> getBikes() {
        List<Motorbike> bikeList = new ArrayList<>();
        bikeRepository.findAll().forEach(bikeList::add);
        return bikeList;
    }

    //an API to get find the vans in the browser
    @CrossOrigin
    @RequestMapping("/findAllVans")
    public List<Van> getVans() {
        List<Van> vanList = new ArrayList<>();
        vanRepository.findAll().forEach(vanList::add);
        return vanList;
    }

    @CrossOrigin
    @RequestMapping(method = RequestMethod.POST, value = "/schedule")
    public void schedule(@RequestBody Schedule schedule){
        Schedule scheduleObject = new Schedule(schedule.getPickUpDate(), schedule.getDropOffDate(),schedule.getCustomer(), schedule.getPlateNumber());
        scheduleRepository.save(scheduleObject  );
    }

    @Override
    public void run(String... args) throws Exception {
    }

}
