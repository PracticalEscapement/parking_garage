package com.parkinggarage.billing;

import com.parkinggarage.parking.ParkingType;

public class Receipt {
    private double calculatedCost;
    private Ticket ticket;
    private boolean isHourly;
    private int hours;

    // Constructor overloading
    // specific constructor is called depending on whether the parking type is daily or hourly
    // Constructors are also only able to be instantiated by other classes in the same package (Ticket).
    Receipt(Ticket ticket) {
        this.ticket = ticket;
        this.isHourly = false;
        this.hours = 1;
        this.calculatedCost = setCalculatedCost(ticket);
    }
    Receipt(Ticket ticket, boolean isHourly, int hours) {
        this.ticket = ticket;
        this.isHourly = isHourly;
        this.hours = hours;
        this.calculatedCost = setCalculatedCost(ticket, isHourly, hours);
    }

    // Method overloading to return the daily rate, or multiply the hourly rate by hours spent parked.
    private double setCalculatedCost(Ticket ticket) {
        double sectionRate = ticket.getSectionRate();
        return sectionRate;
    }
    private double setCalculatedCost(Ticket ticket, boolean isHourly, int hours) {
        double sectionRate = ticket.getSectionRate();
        return sectionRate * hours;
    }

    @Override
    public String toString() {
        return "RECEIPT\n===================================\n" +
                ticket.toString() + ((isHourly) ? "\n\t\t-Hours:" : "") + hours +
                "\n\n" + "Total Cost: "
                + "$" + calculatedCost + "\n\n";
    }
}
