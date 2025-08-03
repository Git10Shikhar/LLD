package org.example.fee;

import org.example.ParkingTicket;

public interface FeeStrategy {

    double calculateFee(ParkingTicket parkingTicket);
}
