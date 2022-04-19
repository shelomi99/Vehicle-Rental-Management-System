package com.shelomi.oopcoursework.demo.model;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document(collection = "Van")
@TypeAlias("van")
public class Van extends Vehicle {
    private int numOfDoors;
    private int numOfPassengers;
    private boolean airCondition;

    public Van(String plateNo, String make, String model, Double speed, int seatCapacity, int numOfDoors, int numOfPassengers, boolean airCondition) {
        super(plateNo, make, model, speed, seatCapacity);
        this.numOfDoors = numOfDoors;
        this.numOfPassengers = numOfPassengers;
        this.airCondition = airCondition;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public int getNumOfPassengers() {
        return numOfPassengers;
    }

    public void setNumOfPassengers(int numOfPassengers) {
        this.numOfPassengers = numOfPassengers;
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
    public int hashCode() {
        return Objects.hash(super.hashCode(), numOfDoors, numOfPassengers, airCondition);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Van van = (Van) o;
        return numOfDoors == van.numOfDoors &&
                numOfPassengers == van.numOfPassengers &&
                airCondition == van.airCondition;
    }


    @Override
    public String toString() {
        return "Van{" +
                "numOfDoors=" + numOfDoors +
                ", numOfPassengers=" + numOfPassengers +
                ", airCondition=" + airCondition +
                "} " + super.toString();
    }
}
