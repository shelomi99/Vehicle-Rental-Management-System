package com.shelomi.oopcoursework.demo.service;

import java.net.URISyntaxException;

public interface RentalVehicleManager {
    void addVehicle();
    void deleteVehicle();
    void editVehicle();
    void saveVehicle();
    void displayListOfVehicles();
    void createReport() throws URISyntaxException;
}
