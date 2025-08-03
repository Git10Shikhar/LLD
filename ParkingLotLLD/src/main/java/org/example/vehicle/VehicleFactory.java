package org.example.vehicle;

import org.example.vehicle.types.Bike;
import org.example.vehicle.types.Car;
import org.example.vehicle.types.Truck;

public class VehicleFactory {
    // DESIGN PATTERN :: FACTORY PATTERN
    public static Vehicle createVehicle(String licensePlate, VehicleType vehicleType) {

        return switch (vehicleType) {
            case CAR -> new Car(licensePlate);
            case BIKE -> new Bike(licensePlate);
            case TRUCK -> new Truck(licensePlate);
        };
    }
}
