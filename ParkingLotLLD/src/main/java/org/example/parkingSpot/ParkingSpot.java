package org.example.parkingSpot;

import org.example.vehicle.Vehicle;

public abstract class ParkingSpot {

    protected final String spotId;
    protected boolean isOccupied;
    protected Vehicle vehicle;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
    }

    public synchronized boolean isAvailable() {
        return !isOccupied;
    }

    public abstract boolean canFitVehicle(Vehicle vehicle);

    public synchronized boolean assignVehicle(Vehicle vehicle) {

        if (isAvailable() && canFitVehicle(vehicle)) {

            this.vehicle = vehicle;
            this.isOccupied = true;
            return true;
        }

        return false;
    }

    public synchronized void removeVehicle() {

        this.vehicle = null;
        this.isOccupied = false;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getSpotId() {
        return spotId;
    }
}
