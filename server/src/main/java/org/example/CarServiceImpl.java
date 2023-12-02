package org.example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class CarServiceImpl extends UnicastRemoteObject implements CarService {

    private List<Car> carList = new ArrayList<>();

    protected CarServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public void addNewCar(Car car) throws RemoteException {
        carList.add(car);
    }

    @Override
    public List<Car> getAllCars() throws RemoteException {
        return carList;
    }

    @Override
    public void changeOwner(Car car, String owner) throws RemoteException {
        if (carList.contains(car)) {
            carList.forEach(it -> {
                if (it.equals(car))
                    it.setOwner(owner);
            });
        } else {
            System.out.println("Такой машины не существует");
        }
    }

    @Override
    public String getOwner(Car car) throws RemoteException {
        AtomicReference<String> result = new AtomicReference<>();
        if (carList.contains(car)) {
            carList.forEach(it -> {
                if (it.equals(car))
                    result.set(it.getOwner());
            });
            return result.get();
        } else {
            System.out.println("Такой машины не существует");
            return "Такой машины не существует";
        }
    }
}
