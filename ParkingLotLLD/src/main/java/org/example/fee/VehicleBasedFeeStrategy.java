package org.example.fee;

import org.example.ParkingTicket;
import org.example.vehicle.VehicleType;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy {

    private final Map<VehicleType, Double> vehicleFee = Map.of(

            VehicleType.BIKE, 10.0,
            VehicleType.CAR, 15.0,
            VehicleType.TRUCK, 20.0
    );

    public double calculateFee(ParkingTicket parkingTicket) {

        long entryTime = parkingTicket.getEntryTimestamp();
        long exitTime = parkingTicket.getExitTimestamp();

        long durationMillis = exitTime - entryTime;

        // Convert to hours (always round up to charge for partial hours)
        long durationHours = (long) Math.ceil(durationMillis / (1000.0 * 60 * 60));

        double rate = vehicleFee.get(parkingTicket.getVehicle().getVehicleType());

        return durationHours * rate;
    }
}
