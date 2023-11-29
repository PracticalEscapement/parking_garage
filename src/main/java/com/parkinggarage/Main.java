package com.parkinggarage;

import com.parkinggarage.car.Car;
import com.parkinggarage.car.CarSize;

public class Main {
    public static void main(String[] args) {
        Car myCar = new Car(CarSize.MEDIUM, false, "xxxxx");
        Car hisCar = new Car(CarSize.LARGE, true, "yyyyyy");

        System.out.println(myCar.toString());
        System.out.println(hisCar.toString());

    }
}