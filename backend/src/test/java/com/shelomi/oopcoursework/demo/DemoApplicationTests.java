package com.shelomi.oopcoursework.demo;
import com.shelomi.oopcoursework.demo.repository.VehicleRepository;
import com.shelomi.oopcoursework.demo.service.MongoService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
 public class DemoApplicationTests {

@Autowired
private MongoService mongoServicel;
@MockBean
private VehicleRepository vehicleRepository;

public void addCarTest() throws Exception{

}

    @Test
    void contextLoads() {
    }

}
