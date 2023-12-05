package com.parkinggarage.billing;

import com.parkinggarage.parking.ParkingComplex;
import com.parkinggarage.parking.ParkingSpace;
import com.parkinggarage.car.Car;
import com.parkinggarage.parking.ParkingType;

public class Ticket {
    public static int ticketNumber = 100;
    private ParkingSpace parkingSpace;
    private Car car;
    private ParkingType lotSection;
    private double sectionRate;

    public Ticket(ParkingType lotSection, ParkingSpace parkingSpace, Car car, double sectionRate) {
        this.lotSection = lotSection;
        this.parkingSpace = parkingSpace;
        this.car = car;
        this.sectionRate = sectionRate;
        ticketNumber++;
    }

    public void printTicket() {
        System.out.println(lotSection + ": " + ticketNumber + " " + car.getSize() + " " + ((car.isElectric()) ? "Electric" : "Gasoline") + " " + "Rate: " + sectionRate);
    }

    public static int getTicketNumber() {
        return ticketNumber;
    }

    public ParkingSpace getParkingSpace() {
        return parkingSpace;
    }

    public String getCar() {
        return car.getPlateNumber();
    }

    @Override
    public String toString() {
        return "|" + lotSection.toString() + "| " + "Space Number: " + parkingSpace.getSpaceNumber() + '\n' +
                "\t-" + "Now " + (parkingSpace.isOccupied() ? "Occupied" : "Vacant") + '\n' +
                "\t-" + "Licence Plate: " + car.getPlateNumber() + "\n" +
                "\t-" + "Rate: " + sectionRate;
    }
}
