package com.shelomi.oopcoursework.demo.repository;

import com.shelomi.oopcoursework.demo.model.Van;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VanRepository extends MongoRepository<Van,String> {
    Van findByPlateNo(String plateNo);

}
