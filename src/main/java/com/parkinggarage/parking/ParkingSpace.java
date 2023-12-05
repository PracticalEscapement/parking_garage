package com.parkinggarage.parking;

public class ParkingSpace {
    private int spaceNumber;
    private boolean occupied;

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

    public void setOccupiedStatus() {
        this.occupied = !occupied;
    }

    @Override
    public String toString() {
        return "ParkingSpace{" +
                "spaceNumber=" + spaceNumber +
                ", occupied=" + occupied +
                '}';
    }
}
