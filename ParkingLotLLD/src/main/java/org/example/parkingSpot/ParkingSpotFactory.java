package org.example.parkingSpot;

import org.example.parkingSpot.types.LargeSpot;
import org.example.parkingSpot.types.MediumSpot;
import org.example.parkingSpot.types.SmallSpot;

public class ParkingSpotFactory {

    public static ParkingSpot createParkingSpot(ParkingSpotType parkingSpotType, String spotId) {
        return switch (parkingSpotType) {
            case SMALL -> new SmallSpot(spotId);
            case MEDIUM -> new MediumSpot(spotId);
            case LARGE -> new LargeSpot(spotId);
        };
    }
}
