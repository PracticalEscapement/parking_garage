package com.parkinggarage;

import car.Car;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car("small", false);
        Car hisCar = new Car("small", true);

        System.out.println(myCar.toString());
        System.out.println(hisCar.toString());
    }
}