package com.parkinggarage;

import car.Car;
import car.CarSize;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car(CarSize.MEDIUM, false);
        Car hisCar = new Car(CarSize.LARGE, true);

        System.out.println(myCar.toString());
        System.out.println(hisCar.toString());
    }
}