package org.example;

import java.io.Serializable;

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private String owner;
    private String number;

    public Car(String number, String owner) {
        super();
        this.owner = owner;
        this.number = number;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object car) {
        return this.getNumber().equals(((Car)car).getNumber());
    }


    @Override
    public String toString() {
        return "Car{" +
                " owner = " + owner  +
                ", number = " + number +
                "} ";
    }
}
