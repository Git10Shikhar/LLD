package org.example.parkingSpot.types;

import org.example.parkingSpot.ParkingSpot;
import org.example.vehicle.Vehicle;
import org.example.vehicle.VehicleType;

public class LargeSpot extends ParkingSpot {

    public LargeSpot(String spotId) {
        super(spotId);
    }

    public boolean canFitVehicle(Vehicle vehicle) {
        return vehicle.getVehicleType() == VehicleType.TRUCK;
    }
}
