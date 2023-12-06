package com.parkinggarage.parking;
import com.parkinggarage.billing.Receipt;
import com.parkinggarage.billing.Ticket;
import com.parkinggarage.car.Car;
import com.parkinggarage.exception.ParkingFullException;
import com.parkinggarage.service.ParkingService;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ParkingSection implements ParkingService {
    private final ParkingType parkingType;
    private int numSpaces;
    private double rate;
    private final Deque<ParkingSpace> sectionStack;
    private List<Ticket> parkedCars;

    public ParkingSection(ParkingType parkingType, int numSpaces, double rate) {
        this.parkingType = parkingType;
        this.numSpaces = numSpaces;
        this.rate = rate;

        this.sectionStack = new ArrayDeque<>();
        this.parkedCars = new ArrayList<>();

        initializeParkingSpaces(numSpaces);
    }

    // Private method that add parking spaces to the section stack
    // sectionStack represents the parking spaces in the parking section
    private void initializeParkingSpaces(int numSpaces) {
        for (int i = 1; i<=numSpaces; i++) {
            sectionStack.add(new ParkingSpace(i));
        }
    }

    private Ticket generateTicket(ParkingType lotSection, ParkingSpace parkingSpace, Car car, double rate) {
        return new Ticket(lotSection, parkingSpace, car, rate);
    }

    // when car is parked, the section stack has its first value(parking space)  removed and added
    // to the arraylist of parked cars
    public Ticket parkCar(Car car) throws ParkingFullException {
        if (isSpaceAvailable()) {
            ParkingSpace space = sectionStack.getFirst();
            Ticket ticket = generateTicket(parkingType, space, car, rate);

            space.setOccupiedStatus();
            sectionStack.pop();
            parkedCars.add(ticket);

            return ticket;
        } else {
            throw new ParkingFullException("No Available spaces!");
        }
    }

    // this method checks to see if the ticket is present within the parked car array
    // if so, is removes the car, add a parking space back to the sectionStack, then generates a receipt
    public void unParkCar(Ticket ticket) {
        parkedCars.stream()
                .filter(t -> t.equals(ticket))
                .findFirst()
                .map(t -> {
                    ParkingSpace space = t.getParkingSpace();
                    space.setOccupiedStatus();
                    sectionStack.add(space);
                    parkedCars.remove(t);
                    try {
                        return generateReceipt(t);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }

    // The return type will be Receipt.
    private String generateReceipt(Ticket ticket) throws Exception{
        Receipt receipt = ticket.generateReceipt(ticket);
        System.out.println(receipt.toString());
        return receipt.toString();
    }

    // prints out list of all parked cars
    public void getParkedCars() {
        if (parkedCars.isEmpty()) {
            System.out.println("Lot is empty");
        } else {
            System.out.println("\n\nList of parked cars in " + parkingType + " section");
            System.out.println("========================================================");
            for (int i=0; i<parkedCars.size(); i++) {
                System.out.println(parkedCars.get(i).toString());
            }
        }
        System.out.println("\n\n");
    }

    public int getNumTotalSpaces() {
        return numSpaces;
    }
    public int getNumAvailableSpaces() {
        return sectionStack.size();
    }

    public boolean isSpaceAvailable() {
        return !sectionStack.isEmpty();
    }

    public ParkingType getParkingType() {
        return parkingType;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public String toString() {
        return parkingType + ": " + numSpaces + " SPACES";
    }


}
