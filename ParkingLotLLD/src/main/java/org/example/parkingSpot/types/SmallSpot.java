package org.example.parkingSpot.types;

import org.example.parkingSpot.ParkingSpot;
import org.example.vehicle.Vehicle;
import org.example.vehicle.VehicleType;

public class SmallSpot extends ParkingSpot {
    public SmallSpot(String spotId) {
        super(spotId);
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.BIKE;
    }
}
