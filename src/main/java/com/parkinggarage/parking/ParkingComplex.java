package com.parkinggarage.parking;

import java.util.List;

public class ParkingComplex {
    // Lists all the parking sections within the parking complex
    private List<ParkingSection> parkingLot;

    public ParkingComplex(List<ParkingSection> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void getAllParkingSections() {
        for (ParkingSection section : parkingLot) {
            System.out.println(section.toString());
        }
    }
}
