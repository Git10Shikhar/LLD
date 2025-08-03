package org.example;

import org.example.fee.FeeStrategy;
import org.example.parkingSpot.ParkingSpot;
import org.example.vehicle.Vehicle;

import java.util.*;

public class ParkingLot {

    private static final ParkingLot INSTANCE = new ParkingLot();

    private final List<ParkingFloor> parkingFloors = new ArrayList<>();
    private final Map<String, ParkingTicket> activeTickets = new HashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot() {
    }

    public static synchronized ParkingLot getInstance() {
        return INSTANCE;
    }

    public synchronized void addFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy = feeStrategy;
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle) throws Exception {
        for (ParkingFloor floor : parkingFloors) {

            Optional<ParkingSpot> availableSpots = floor.getAvailableSpots(vehicle);

            if (availableSpots.isPresent()) {

                ParkingSpot spot = availableSpots.get();

                if (spot.assignVehicle(vehicle)) {

                    ParkingTicket ticket = new ParkingTicket(vehicle, spot);
                    activeTickets.put(vehicle.getLicensePlate(), ticket);
                    return ticket;

                }
            }
        }

        throw new Exception("No available spot for vehicle");
    }

    public synchronized double unparkVehicle(Vehicle vehicle) throws Exception {

        ParkingTicket ticket = activeTickets.get(vehicle.getLicensePlate());

        if (ticket == null)
            throw new Exception("ticket not found");

        ticket.setExitTimestamp(System.currentTimeMillis());
        ticket.getParkingSpot().removeVehicle();

        return feeStrategy.calculateFee(ticket);
    }
}
