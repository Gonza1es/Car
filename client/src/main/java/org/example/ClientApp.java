package org.example;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientApp {

    private final static String SERVICE_PATH = "rmi://localhost:1099/CarServiceImpl";

    public static void start() throws MalformedURLException, NotBoundException, RemoteException {
        CarService carService = (CarService) Naming.lookup(SERVICE_PATH);

        System.out.println("Результат вызова getAllCars() до добавление машин: " + carService.getAllCars());
        Car porsche = new Car("o911рм", "Владимир");
        Car audi = new Car("о777оо", "Виталий");
        Car swallow = new Car("в004хх", "Анна");

        carService.addNewCar(porsche);
        carService.addNewCar(audi);
        carService.addNewCar(swallow);

        System.out.println("Результат вызова getAllCars() после добавление машин: " + carService.getAllCars());
        carService.changeOwner(porsche, "Максим");
        System.out.println("Результат вызова getOwner() для машины o911рм: \n" + carService.getOwner(porsche));



    }
}
