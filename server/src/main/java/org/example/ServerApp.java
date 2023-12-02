package org.example;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerApp {

    public static void start() throws RemoteException {
        CarService carService = new CarServiceImpl();
        String serviceName = "CarServiceImpl";
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind(serviceName, carService);
        System.out.println("Start server");
    }
}
