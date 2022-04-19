package com.shelomi.oopcoursework.demo.model;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Time;
import java.util.Date;
import java.util.Objects;

@Document(collection = "Schedule")
public class Schedule {
    private String pickUpDate;
    private String dropOffDate;
    private Customer customer;
    private String plateNumber;

    public Schedule(String pickUpDate, String dropOffDate, Customer customer, String plateNumber) {
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
        this.customer = customer;
        this.plateNumber = plateNumber;
    }

    public String getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(String pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(String dropOffDate) {
        this.dropOffDate = dropOffDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schedule schedule = (Schedule) o;
        return Objects.equals(pickUpDate, schedule.pickUpDate) &&
                Objects.equals(dropOffDate, schedule.dropOffDate) &&
                Objects.equals(customer, schedule.customer) &&
                Objects.equals(plateNumber, schedule.plateNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pickUpDate, dropOffDate, customer, plateNumber);
    }
}

