package org.example.vehicle.types;

import org.example.vehicle.Vehicle;
import org.example.vehicle.VehicleType;

public class Bike extends Vehicle {

    public Bike(String licensePlate) {
        super(licensePlate, VehicleType.BIKE);
    }
}
