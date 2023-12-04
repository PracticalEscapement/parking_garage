package com.parkinggarage.parking;
import com.parkinggarage.billing.Ticket;
import com.parkinggarage.car.Car;
import com.parkinggarage.exception.ParkingFullException;
import com.parkinggarage.service.ParkingService;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class ParkingSection implements ParkingService {

    private ParkingType parkingType;
    private int numSpaces;
    private final Deque<ParkingSpace> sectionStack;
    private Ticket[] parkedCars;

    public ParkingSection(ParkingType parkingType, int numSpaces) {
        this.parkingType = parkingType;
        this.numSpaces = numSpaces;
        this.sectionStack = new ArrayDeque<>();
        this.parkedCars = new Ticket[numSpaces];
        initializeParkingSpaces(numSpaces);
    }

    private void initializeParkingSpaces(int numSpaces) {
        for (int i = 1; i<=numSpaces; i++) {
            sectionStack.add(new ParkingSpace(i));
        }
        System.out.println(sectionStack.toString());
    }

    public ParkingType getParkingType() {
        return parkingType;
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

    //
    private void generateTicket(ParkingType lotSection, ParkingSpace parkingSpace, Car car) {
       Ticket myTicket = new Ticket(lotSection, parkingSpace, car);
       myTicket.printTicket();
    }

    public void parkCar(Car car) throws ParkingFullException {
        if (isSpaceAvailable()) {
            ParkingSpace space = sectionStack.getFirst();
            generateTicket(parkingType, space, car);
            sectionStack.pop();
            System.out.println(getNumAvailableSpaces() + " spaces left.");
        } else {
            throw new ParkingFullException("No Available spaces");
        }
    }

    public void getParkedCars() {
        if (parkedCars.length == 0) {
            System.out.println("Lot is empty");
        } else {
            for (Ticket ticket : parkedCars) {
                ticket.printTicket();
            }
        }
    }


    @Override
    public String toString() {
        return "ParkingSection{" +
                "parkingType=" + parkingType +
                ", numSpaces=" + numSpaces +
                '}';
    }


}
