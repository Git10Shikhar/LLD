package org.example.fee;

import org.example.ParkingTicket;

public class FlatRateStrategy implements FeeStrategy {

    private static final double FEE_PER_HOUR = 20.0;

    public double calculateFee(ParkingTicket parkingTicket) {

        long duration = (parkingTicket.getExitTimestamp() - parkingTicket.getEntryTimestamp() / (100 * 60 * 60));
        return duration * FEE_PER_HOUR;
    }

}
