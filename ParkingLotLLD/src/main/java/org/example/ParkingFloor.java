package org.example;

import org.example.parkingSpot.ParkingSpot;
import org.example.vehicle.Vehicle;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {

    private final int floorId;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorId, List<ParkingSpot> parkingSpots) {

        this.floorId = floorId;
        this.parkingSpots = parkingSpots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpots(Vehicle vehicle) {

        return parkingSpots.stream()
                .filter(s -> s.isAvailable() && s.canFitVehicle(vehicle))
                .findFirst();
    }
}
