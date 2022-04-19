package com.shelomi.oopcoursework.demo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;


public abstract class Vehicle implements Comparable<Vehicle>{
    @Id
    private String plateNo;
    private String make;
    private String model;
    private Double speed;
    private int  seatCapacity;

    public Vehicle(String plateNo, String make, String model, Double speed, int seatCapacity) {
        this.plateNo = plateNo;
        this.make = make;
        this.model = model;
        this.speed = speed;
        this.seatCapacity = seatCapacity;
    }
    public Vehicle(){

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return plateNo == vehicle.plateNo &&
                seatCapacity == vehicle.seatCapacity &&
                make.equals(vehicle.make) &&
                model.equals(vehicle.model) &&
                speed.equals(vehicle.speed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(plateNo, make, model, speed, seatCapacity);
    }

    public String  getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public int getSeatCapacity() {
        return seatCapacity;
    }

    public void setSeatCapacity(int seatCapacity) {
        this.seatCapacity = seatCapacity;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "plateNo=" + plateNo +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", speed=" + speed +
                ", seatCapacity=" + seatCapacity +
                '}';
    }
}
