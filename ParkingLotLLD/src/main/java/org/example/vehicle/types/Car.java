package org.example.vehicle.types;

import org.example.vehicle.Vehicle;
import org.example.vehicle.VehicleType;

public class Car extends Vehicle {

    public Car(String licensePlate) {
        super(licensePlate, VehicleType.CAR);
    }
}