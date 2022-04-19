package com.shelomi.oopcoursework.demo.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document(collection = "Cars")//create a collection to add the cars
@TypeAlias("car")
public class Car extends Vehicle {
    private int numOfDoors;
    private boolean isAutomatic;
    private boolean airCondition;

    public Car(String plateNo, String make, String model, Double speed, int seatCapacity, int numOfDoors, boolean isAutomatic, boolean airCondition) {
//        super(plateNo, make, model, speed, seatCapacity);
        this.numOfDoors = numOfDoors;
        this.isAutomatic = isAutomatic;
        this.airCondition = airCondition;
        super.setPlateNo(plateNo);
        super.setMake(make);
        super.setModel(model);
        super.setSpeed(speed);
        super.setSeatCapacity(seatCapacity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Car car = (Car) o;
        return numOfDoors == car.numOfDoors &&
                isAutomatic == car.isAutomatic &&
                airCondition == car.airCondition;
    }
//getter setter
    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), numOfDoors, isAutomatic, airCondition);
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }


    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Car{" +
                "numOfDoors=" + numOfDoors +
                ", isAutomatic=" + isAutomatic +
                ", airCondition=" + airCondition +
                "} " + super.toString();
    }
}
