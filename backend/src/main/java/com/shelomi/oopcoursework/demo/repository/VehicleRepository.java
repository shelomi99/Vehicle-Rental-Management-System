package com.shelomi.oopcoursework.demo.repository;
import com.shelomi.oopcoursework.demo.model.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends MongoRepository<Vehicle,String> {
    Vehicle findByPlateNo(String plateNo);
}

