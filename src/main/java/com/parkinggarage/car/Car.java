package com.parkinggarage.car;

import org.apache.commons.lang3.StringUtils;

public class Car {
    // CarSize is an enum that has a list of the different car sizes. I did not have the chance to do anything with this.
    // I originally wanted to factor in the car size into the calculated cost.
    private CarSize carSize;
    private boolean isElectric;
    protected String plateNumber;

    public Car(CarSize carSize, boolean isElectric, String plateNumber) {
        this.carSize = carSize;
        this.isElectric = isElectric;
        this.plateNumber = plateNumber;
    }

    public CarSize getSize() {
        return carSize;
    }

    public void setSize(CarSize carSize) {
        this.carSize = carSize;
    }

    public boolean isElectric() {
        return isElectric;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }
    @Override
    public String toString() {
        // TODO figure out how to print car size

        String size = carSize.toString();

        return (!isElectric) ? StringUtils.capitalize(size) + " Gasoline Car" : StringUtils.capitalize(size) + " Electric Car";
    }
}
