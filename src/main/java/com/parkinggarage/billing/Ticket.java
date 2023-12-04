package com.parkinggarage.billing;

import com.parkinggarage.parking.ParkingSpace;
import com.parkinggarage.car.Car;
import com.parkinggarage.parking.ParkingType;

public class Ticket {
    public static int ticketNumber = 10;
    private ParkingSpace parkingSpace;
    private Car car;
    private ParkingType lotSection;

    public Ticket(ParkingType lotSection, ParkingSpace parkingSpace, Car car) {
        this.lotSection = lotSection;
        this.parkingSpace = parkingSpace;
        this.car = car;
        ticketNumber++;
    }

    public void printTicket() {
        System.out.println(lotSection + ": " + ticketNumber + " " + car.getSize() + " " + ((car.isElectric()) ? "Electric" : "Gasoline") + " " + "Rate: $$$");
    }



}
