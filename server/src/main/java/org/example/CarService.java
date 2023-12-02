package org.example;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface CarService extends Remote {

    void addNewCar(Car car) throws RemoteException;

    List<Car> getAllCars() throws RemoteException;

    void changeOwner(Car car, String owner) throws RemoteException;

    String getOwner(Car car) throws RemoteException;
}
