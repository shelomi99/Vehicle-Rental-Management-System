package com.shelomi.oopcoursework.demo.model;

import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Objects;

@Data
@Document(collection = "MotorBike")
@TypeAlias("motorbike")
public class Motorbike extends Vehicle{
    private String type;
    private Double seatHeight;

    public Motorbike(String plateNo, String make, String model, Double speed, int seatCapacity, String type, Double seatHeight) {
        super(plateNo, make, model, speed, seatCapacity);
        this.type = type;
        this.seatHeight = seatHeight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getSeatHeight() {
        return seatHeight;
    }

    public void setSeatHeight(Double seatHeight) {
        this.seatHeight = seatHeight;
    }

    @Override
    public int compareTo(Vehicle o) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Motorbike motorbike = (Motorbike) o;
        return type.equals(motorbike.type) &&
                seatHeight.equals(motorbike.seatHeight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), type, seatHeight);
    }

    @Override
    public String toString() {
        return "Motorbike{" +
                "type='" + type + '\'' +
                ", seatHeight=" + seatHeight +
                "} " + super.toString();
    }
}
