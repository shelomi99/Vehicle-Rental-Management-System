package com.shelomi.oopcoursework.demo.service;
import com.shelomi.oopcoursework.demo.model.*;
import com.shelomi.oopcoursework.demo.repository.CarRepository;
import com.shelomi.oopcoursework.demo.repository.ScheduleRepository;
import com.shelomi.oopcoursework.demo.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

@Component
public class WestminsterRentalVehicleManager implements RentalVehicleManager, CommandLineRunner {

    @Autowired
    private MongoService mongoService;

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    private static ArrayList<Vehicle> listOfVehicles = new ArrayList<Vehicle>();
    private static final int MAX_PARKING_SPOTS = 50;

    //method to Validate integer input
    private int inputValidation() {
        while (!input.hasNextInt()) {
            System.out.println("Invalid input please re-enter");
            input.next();
        }
        return input.nextInt();
    }

    //method to Validate double inputs
    private double inputValidationDouble() {
        while (!input.hasNextDouble()) {
            System.out.println("Invalid input please re-enter");
            input.next();
        }
        return input.nextDouble();
    }

    //method to Validate  boolean inputs
    private boolean booleanValidation(){
        boolean answer=false;
        int option;
        do {
            System.out.println("Choose an option");
            System.out.println("1. True");
            System.out.println("2. False");
            option = inputValidation();
            if (option==1){
                answer = true;
            }
        } while (option>2 || option<1 && input.hasNextBoolean());
        return (answer);
    }
    //Create a Scanner object to take inputs
    private Scanner input = new Scanner(System.in).useDelimiter("\n");

    @Override
    public void addVehicle() {

        int choice;
        if (listOfVehicles.size() < MAX_PARKING_SPOTS) {//to check if the parking is full or not
            System.out.println("What kind of vehicle would you like to add");
            System.out.println("1.Car");
            System.out.println("2.MotorBike");
            System.out.println("3.Van");
            do { choice = inputValidation();
            } while (choice < 1 || choice > 3);

            if (choice == 1) {
                System.out.println("Enter the following information for the car");
                System.out.println("Enter the plate number of the Car(ABC123) :");
                String plateNo = input.next();

                int length = plateNo.length();
                if (length > 6) {//to check if the plate number id valid
                    System.out.println("License plate numbers can not be more then 6 characters");
                    input.next();
                }
                System.out.println("Enter the vehicle make:");
                String make = input.next();
                System.out.println("Enter the vehicle model:");
                String model = input.next();
                System.out.println("Enter the speed of the car(kmph):");
                Double speed = inputValidationDouble();
                System.out.println("What is the seat capacity of the Car:");
                int seatCapacity = inputValidation();
                System.out.println("How many doors are there in the car:");
                int numOfDoors = inputValidation();
                System.out.println("Is the car automatic(true/false):");
                boolean isAutomatic = booleanValidation();
                System.out.println("Is the car air conditioned(true/false):");
                boolean airCondition = booleanValidation();
                //create a constructor to add the attributes of the car
                Car car = new Car(plateNo, make, model, speed, seatCapacity, numOfDoors, isAutomatic, airCondition);
                mongoService.addCar(car);//save the vehicle inside the car repository
                mongoService.addVehicle(car);//save the vehicle in the main vehicle repository
                listOfVehicles.add(car);//to add the vehicle to the Array list

            } else if (choice == 2) {
                System.out.println("Enter the following information for the Motorbike");
                System.out.println("Enter the plate number of the Motorbike");
                String plateNo = input.next();
                System.out.println("Enter the vehicle make");
                String make = input.next();
                System.out.println("Enter the vehicle model");
                String model = input.next();
                System.out.println("Enter the speed of the motorbike(kmph)");
                Double speed = inputValidationDouble();
                System.out.println("What is the seat capacity of the Motorbike?");
                int seatCapacity = inputValidation();
                System.out.println("What is the type of the motorbike(Sports/Naked/Scooter)");
                String type = input.next();
                System.out.println("What is the seat height(inches)?");
                Double seatHeight = input.nextDouble();
                //create a constructor to add the attributes of the bike
                Motorbike bike = new Motorbike(plateNo, make, model, speed, seatCapacity, type, seatHeight);
                mongoService.addBike(bike);//save the vehicle inside the bike repository
                mongoService.addVehicle(bike);//save the vehicle in the main vehicle repository
                listOfVehicles.add(bike);//to add the vehicle to the Array list

            } else if (choice == 3) {
                System.out.println("Enter the following information for the Van");
                System.out.println("Enter the plate number of the Van");
                String plateNo = input.next();
                System.out.println("Enter the vehicle make");
                String make = input.next();
                System.out.println("Enter the vehicle model");
                String model = input.next();
                System.out.println("Enter the speed of the van");
                Double speed = inputValidationDouble();
                System.out.println("What is the seat capacity of the Van?");
                int seatCapacity = inputValidation();
                System.out.println("How many doors are there in the van");
                int numOfDoors = inputValidation();
                System.out.println("How many passengers are there in the van");
                int numOfPassengers = inputValidation();
                System.out.println("Is the van air conditioned(true/false)");
                boolean airCondition = booleanValidation();
                //create a constructor to add the attributes of the van
                Van van = new Van(plateNo, make, model, speed, seatCapacity, numOfDoors, numOfPassengers, airCondition);
                mongoService.addVan(van);//save the vehicle inside the van repository
                mongoService.addVehicle(van);//save the vehicle in the main vehicle repository
                listOfVehicles.add(van);//to add the vehicle to the Array list

            } else {
                System.out.println("invalid input, Please re-enter");
                input.next();
            }
        }
        //if the car park is full display error message
        else {
            System.out.println("Sorry the vehicle park is full, you cannot add more vehicles!");
        }
    }

    @Override
    public void deleteVehicle() {
        System.out.println("Enter the plate number of the vehicle you want to delete ");
        String findVehicle = input.next();
        if (listOfVehicles == null) {
            System.out.println("database is empty");
        }
        for (Vehicle i : vehicleRepository.findAll()) { //to iterate through the vehicle array list
            if (findVehicle.equalsIgnoreCase(i.getPlateNo())) {//to check if an element matches the given input
                listOfVehicles.remove(i);//to remove the vehicle information by the selected vehicle plate number
                System.out.println("The Vehicle which has the plate number " + i.getPlateNo() + " is deleted from the database");
                Vehicle deleteVehicle = vehicleRepository.findByPlateNo(i.getPlateNo());//getting the vehicle object that needs to be deleted
                vehicleRepository.delete(deleteVehicle);//deleting the vehicle form the database
                break;
            }

        }
        long counter = vehicleRepository.count();//get the number of objects in the database
        counter = MAX_PARKING_SPOTS - counter;//calculating the left spaces
        System.out.println("left spaces in the database: "+counter);//Display left spaces
    }
    @Override
    public void editVehicle() {
        Vehicle object = null;
        Car carObject = null;
        Van vanObject = null;
        Motorbike motorbikeObject = null;
        int editElement;

        System.out.println("Enter the plate number of the vehicle which you want to edit");
        String vehicle = input.next();
        for (Vehicle i : vehicleRepository.findAll()) {//to iterate through the vehicle array list
            if (vehicle.equalsIgnoreCase(i.getPlateNo())) {//to check if an element matches the given input
                object = i;//assigning index of i to an variable called object;
                switch (i.getClass().getTypeName()) {
                    //casting the object vehicle into car,bike and van to use the child attributes of them.
                    case "Car":
                        carObject = (Car) i;
                    case "Motorbike":
                        motorbikeObject = (Motorbike) i;
                    case "Van":
                        vanObject = (Van) i;
                }

                if (i instanceof Car) {//to check if the object  is A Car
                    System.out.println("Select which element you want to edit in this car :");
                    System.out.println("1.vehicle make" +
                            " \n2.Vehicle model" +
                            " \n3.Speed of the car(kmph) " +
                            "\n4.seat capacity ");
                    while (!input.hasNextInt()) {
                        input.next();
                        System.out.print("Invalid option enter again : ");
                    }
                    editElement = input.nextInt();
                    switch (editElement) {
                        case 1:
                            System.out.println("Enter the new vehicle make");
                            String newMake = input.next();
                            Vehicle editedMake = vehicleRepository.findByPlateNo(vehicle);//find the relevant object by findPlateNo method
                            editedMake.setMake(newMake);
                            vehicleRepository.save(editedMake);
                            i.setMake(newMake);//to edit the make of the car
                            System.out.println(listOfVehicles);
                            break;
                        case 2:
                            System.out.println("Enter the new vehicle model");
                            String newModel = input.next();
                            Vehicle editedModel = vehicleRepository.findByPlateNo(vehicle);
                            editedModel.setModel(newModel);
                            vehicleRepository.save(editedModel);
                            i.setModel(newModel);//to edit the model of the car
                            break;
                        case 3:
                            System.out.println("Enter the new speed of the car(kmph) ");
                            double newSpeed = inputValidationDouble();
                            Vehicle editedSpeed = vehicleRepository.findByPlateNo(vehicle);
                            editedSpeed.setSpeed(newSpeed);
                            vehicleRepository.save(editedSpeed);
                            i.setSpeed(newSpeed);//to edit the speed of the car
                            break;
                        case 4:
                            System.out.println("What is the new seat capacity of the car");
                            int newSeatCapacity = inputValidation();
                            Vehicle editedSeatCapacity = vehicleRepository.findByPlateNo(vehicle);
                            editedSeatCapacity.setSeatCapacity(newSeatCapacity);//to update the attribute
                            vehicleRepository.save(editedSeatCapacity);//to save the updated vehicle in the database
                            i.setSeatCapacity(newSeatCapacity);//to edit the seat capacity of the car in the array list
                            break;
                        default:
                            System.out.println("Invalid number!");
                            break;
                    }
                } else if (i instanceof Motorbike) {//to check if the object is bike
                    System.out.println("Select which element you want to edit in this bike :");
                    System.out.println("1.vehicle make" +
                            " \n2.Vehicle model" +
                            " \n3. speed of the bike(kmph) " +
                            "\n4. seat capacity of the bike?");
                    while (!input.hasNextInt()) {
                        input.next();
                        System.out.print("Invalid option enter again : ");
                    }

                    editElement = input.nextInt();
                    switch (editElement) {
                        case 1:
                            System.out.println("Enter the new vehicle make");
                            String newMake = input.next();
                            Vehicle editedMake = vehicleRepository.findByPlateNo(vehicle);
                            editedMake.setMake(newMake);
                            vehicleRepository.save(editedMake);
                            i.setMake(newMake);
                            System.out.println(listOfVehicles);
                            break;
                        case 2:
                            System.out.println("Enter the new vehicle model");
                            String newModel = input.next();
                            Vehicle editedModel = vehicleRepository.findByPlateNo(vehicle);
                            editedModel.setModel(newModel);
                            vehicleRepository.save(editedModel);
                            i.setModel(newModel);
                            break;
                        case 3:
                            System.out.println("Enter the new speed of the bike(kmph) ");
                            double newSpeed = inputValidationDouble();
                            Vehicle editedSpeed = vehicleRepository.findByPlateNo(vehicle);
                            editedSpeed.setSpeed(newSpeed);
                            vehicleRepository.save(editedSpeed);
                            i.setSpeed(newSpeed);
                            break;
                        case 4:
                            System.out.println("What is the new seat capacity of the bike");
                            int newSeatCapacity = inputValidation();
                            Vehicle editedSeatCapacity = vehicleRepository.findByPlateNo(vehicle);
                            editedSeatCapacity.setSeatCapacity(newSeatCapacity);
                            vehicleRepository.save(editedSeatCapacity);
                            i.setSeatCapacity(newSeatCapacity);
                            break;
                        default:
                            System.out.println("Invalid number!");
                    }
                } else if (i instanceof Van) {//to check if the object  is van
                    System.out.println("Select which element you want to edit in this van :");
                    System.out.println("1.vehicle make" +
                            " \n2.Vehicle model" +
                            " \n3. speed of the van(kmph) " +
                            "\n4.What is the new seat capacity of the van?");
                    while (!input.hasNextInt()) {
                        input.next();
                        System.out.print("Invalid option enter again : ");
                    }

                    editElement = input.nextInt();
                    switch (editElement) {
                        case 1:
                            System.out.println("Enter the new vehicle make");
                            String newMake = input.next();
                            Vehicle editedMake = vehicleRepository.findByPlateNo(vehicle);
                            editedMake.setMake(newMake);
                            vehicleRepository.save(editedMake);
                            i.setMake(newMake);
                            System.out.println(listOfVehicles);
                            break;
                        case 2:
                            System.out.println("Enter the new vehicle model");
                            String newModel = input.next();
                            Vehicle editedModel = vehicleRepository.findByPlateNo(vehicle);
                            editedModel.setModel(newModel);
                            vehicleRepository.save(editedModel);
                            i.setModel(newModel);
                            break;
                        case 3:
                            System.out.println("Enter the new speed of the van(kmph) ");
                            double newSpeed = inputValidationDouble();
                            Vehicle editedSpeed = vehicleRepository.findByPlateNo(vehicle);
                            editedSpeed.setSpeed(newSpeed);
                            vehicleRepository.save(editedSpeed);
                            i.setSpeed(newSpeed);
                            break;
                        case 4:
                            System.out.println("What is the new seat capacity of the van");
                            int newSeatCapacity = inputValidation();
                            Vehicle editedSeatCapacity = vehicleRepository.findByPlateNo(vehicle);
                            editedSeatCapacity.setSeatCapacity(newSeatCapacity);
                            vehicleRepository.save(editedSeatCapacity);
                            i.setSeatCapacity(newSeatCapacity);
                            break;
                        default:
                            System.out.println("Invalid number!");
                    }
                }
            } else {
                System.out.println("The vehicle does not exist in the database");
            }
        }
    }

    @Override
    public void saveVehicle() {
        //saving the vehicle information in a text fils to update any changes
        File file = new File("vehicles.txt");
        FileWriter fw = null;
        PrintWriter pw = null;
        try {
            fw = new FileWriter(file, true);
            pw = new PrintWriter(fw, true);
            pw.println(listOfVehicles);
        }
        catch (IOException e){
            System.err.println("Error Occurred "+e.getMessage());
        }
        finally {
            try {
                fw.close();
                pw.close();
            }catch (IOException e){
                System.err.println("Error Occurred "+e.getMessage());
            }
        }
    }

    @Override
    public void displayListOfVehicles() {
        //get all the vehicle makes into an array
        ArrayList<String> unique = new ArrayList<>();
        for (Vehicle i : vehicleRepository.findAll()) {
            unique.add(i.getMake());
        }
        System.out.println("list of  the vehicle makes in the parking area in alphabetical order ");
        //sorting the array of makes
        Collections.sort(unique);
        //displaying the sorted list of makes
        for (String j : unique) {
            System.out.print(j + "\n");
        }
        //Displaying a report on all the available vehicles in the database
        System.out.println("-----------------Report of the Vehicle Rental System--------------------");
        System.out.println("Available vehicles in the database");
        System.out.println("================================================");
        for (Vehicle i : vehicleRepository.findAll()) {
            System.out.println("\nVehicle plate number - " + i.getPlateNo() + "\nVehicle make - " + i.getMake() +
                    "\nVehicle model- " + i.getModel() + "\nVehicle speed - " + i.getSpeed() + "\nVehicle seat capacity - " + i.getSeatCapacity() + "\n" );
        }
        System.out.println("================================================");
        //Displaying a report on all the vehicles that has been booked by the customers
        System.out.println("Vehicles that has already been booked");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (Schedule i : scheduleRepository.findAll()) {
            System.out.println("\nVehicle plate number - " + i.getPlateNumber() + "\nCustomer Name - " + i.getCustomer().getName()+
                    "\nCustomer Mail- " + i.getCustomer().getEmail() + "\n Vehicle pick up date- " + i.getPickUpDate() + "\n Vehicle drop off date - " + i.getDropOffDate()+ "\n");
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }

    @Override
    public void createReport() throws URISyntaxException {
        System.out.println("Go to the browser from the following link");
        //displaying the url in the browser
        URI uri = new URI("http://localhost:4200/home");
        System.out.println(uri);

    }

    @Override
    public void run(String... args) throws URISyntaxException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter option");
        System.out.println("1.Add vehicle \n2.Delete vehicle \n3.Edit vehicle \n4.Save vehicle\n5.Print list of vehicles \n6.Display the available vehicles in the browser\n7.Exit the System");
        //validation for integer inputs
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Invalid option enter again : ");
        }

        int option = input.nextInt();

        switch (option) {

            case 1:
                addVehicle();
                run(args);
                break;
            case 2:
                deleteVehicle();
                run(args);
                break;
            case 3:
                editVehicle();
                run(args);
                break;
            case 4:
                saveVehicle();
                run(args);
                break;
            case 5:
                displayListOfVehicles();
                run(args);
                break;

            case 6:
                createReport();
                run(args);
                break;

            case 7:
                System.out.println("You are exiting the Vehicle rental system! ");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Option! Please choose a valid option ");
                run(args);

        }
    }


}
