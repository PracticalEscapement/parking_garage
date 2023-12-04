package com.parkinggarage.parking;
import com.parkinggarage.billing.Ticket;
import com.parkinggarage.car.Car;
import com.parkinggarage.exception.ParkingFullException;
import com.parkinggarage.service.ParkingService;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ParkingSection implements ParkingService {
    private ParkingType parkingType;
    private int numSpaces;
    private final double rate;
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

    private void initializeParkingSpaces(int numSpaces) {
        for (int i = 1; i<=numSpaces; i++) {
            sectionStack.add(new ParkingSpace(i));
        }
    }

    private Ticket generateTicket(ParkingType lotSection, ParkingSpace parkingSpace, Car car) {
        return new Ticket(lotSection, parkingSpace, car);
    }

    public void parkCar(Car car) throws ParkingFullException {
        if (isSpaceAvailable()) {
            ParkingSpace space = sectionStack.getFirst();
            Ticket ticket = generateTicket(parkingType, space, car);

            space.setOccupiedStatus();
            sectionStack.pop();
            parkedCars.add(ticket);

            System.out.println(getNumAvailableSpaces() + " spaces left.");
        } else {
            throw new ParkingFullException("No Available spaces");
        }
    }

    public void unParkCar(Ticket ticket) {

    }

    public void getParkedCars() {
        if (parkedCars.isEmpty()) {
            System.out.println("Lot is empty");
        } else {
            System.out.println("List of parked cars in " + parkingType + " section");
            System.out.println("========================================================");
            for (int i=0; i<parkedCars.size(); i++) {
                System.out.println(parkedCars.get(i).toString());
            }
        }
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
        return "ParkingSection{" +
                "parkingType=" + parkingType +
                ", numSpaces=" + numSpaces +
                '}';
    }


}
