package com.shelomi.oopcoursework.demo.repository;

import com.shelomi.oopcoursework.demo.model.Motorbike;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorbikeRepository extends MongoRepository<Motorbike,String> {
    Motorbike findByPlateNo(String plateNo);
}
