package com.parkinggarage.parking;

import java.util.List;

public class ParkingComplex {
    private final List<ParkingSection> parkingLot;

    public ParkingComplex(List<ParkingSection> parkingLot) {
        this.parkingLot = parkingLot;
    }

    public void getAllParkingSections() {
        for (ParkingSection section : parkingLot) {
            System.out.println(section);
        }
    }
}
