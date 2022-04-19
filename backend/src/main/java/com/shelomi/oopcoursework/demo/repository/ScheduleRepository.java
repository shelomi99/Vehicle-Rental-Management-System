package com.shelomi.oopcoursework.demo.repository;

import com.shelomi.oopcoursework.demo.model.Schedule;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ScheduleRepository  extends MongoRepository<Schedule,String> {
}
