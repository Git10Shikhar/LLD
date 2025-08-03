package org.example.vehicle.types;

import org.example.vehicle.Vehicle;
import org.example.vehicle.VehicleType;

public class Truck extends Vehicle {

    public Truck(String licensePlate) {
        super(licensePlate, VehicleType.TRUCK);
    }
}
