package org.example;

import org.example.fee.VehicleBasedFeeStrategy;
import org.example.parkingSpot.ParkingSpot;
import org.example.parkingSpot.ParkingSpotFactory;
import org.example.parkingSpot.ParkingSpotType;
import org.example.vehicle.Vehicle;
import org.example.vehicle.VehicleFactory;
import org.example.vehicle.VehicleType;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        ParkingLot parkingLot = ParkingLot.getInstance();

        ParkingSpot b1 = ParkingSpotFactory.createParkingSpot(ParkingSpotType.SMALL, "B1");
        ParkingSpot c1 = ParkingSpotFactory.createParkingSpot(ParkingSpotType.MEDIUM, "C1");
        ParkingSpot t1 = ParkingSpotFactory.createParkingSpot(ParkingSpotType.LARGE, "T1");

        ParkingFloor parkingFloor = new ParkingFloor(1, List.of(b1, c1, t1));

        parkingLot.addFloor(parkingFloor);
        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());

        Vehicle bike = VehicleFactory.createVehicle("B01-1234", VehicleType.BIKE);
        Vehicle car = VehicleFactory.createVehicle("C01-1234", VehicleType.CAR);
        Vehicle truck = VehicleFactory.createVehicle("T01-1234", VehicleType.TRUCK);

        ParkingTicket bikeTicket = parkingLot.parkVehicle(bike);
        ParkingTicket carTicket = parkingLot.parkVehicle(car);
        ParkingTicket truckTicket = parkingLot.parkVehicle(truck);

        Thread.sleep(1000);

        double bikeFee = parkingLot.unparkVehicle(bike);
        double carFee = parkingLot.unparkVehicle(car);
        double truckFee = parkingLot.unparkVehicle(truck);

        System.out.println("Unparked. Bike fee - ₹" + bikeFee);
        System.out.println("Unparked. Car fee - ₹" + carFee);
        System.out.println("Unparked. Truck fee - ₹" + truckFee);


    }
}
