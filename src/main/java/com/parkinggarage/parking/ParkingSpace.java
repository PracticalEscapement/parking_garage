package com.parkinggarage.parking;

public class ParkingSpace {
    private int spaceNumber;
    private boolean occupied;
//    private boolean hasElectricCharging;


    // Want all the spaces to be created when the parking lot is created.
    // What is the total number of spaces, how many subsets of the parking lot are there?
    // Hourly, Daily, Daily Electric.
    public ParkingSpace(int spaceNumber) {
        this.spaceNumber = spaceNumber;
        this.occupied = false;
    }

    public int getSpaceNumber() {
        return spaceNumber;
    }

    public void setSpaceNumber(int spaceNumber) {
        this.spaceNumber = spaceNumber;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "spaceNumber=" + spaceNumber +
                ", occupied=" + occupied +
                '}';
    }
}
