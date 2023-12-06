package com.parkinggarage.billing;

import com.parkinggarage.parking.ParkingSpace;
import com.parkinggarage.car.Car;
import com.parkinggarage.parking.ParkingType;
import com.parkinggarage.service.ReceiptService;

import java.util.Random;
public class Ticket implements ReceiptService {
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

    @Override
    public Receipt generateReceipt(Ticket ticket) throws Exception{
        if (ticket.lotSection.equals(ParkingType.DAILY) || ticket.lotSection.equals(ParkingType.ELECTRIC_DAILY)) {
            return new Receipt(ticket);
        } else if (ticket.lotSection.equals(ParkingType.HOURLY) || ticket.lotSection.equals(ParkingType.ELECTRIC_HOURLY)) {
            Random random = new Random();
            int hours = random.nextInt(1, 12);
            return new Receipt(ticket, true, hours);
        } else {
            throw new Exception("Error Generating Receipt");
        }
    }

    public static int getTicketNumber() {
        return ticketNumber;
    }

    public double getSectionRate() {
        return sectionRate;
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
