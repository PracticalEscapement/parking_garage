package com.parkinggarage;

import com.parkinggarage.billing.Ticket;
import com.parkinggarage.car.Car;
import com.parkinggarage.car.CarSize;
import com.parkinggarage.exception.ParkingFullException;
import com.parkinggarage.parking.ParkingSection;
import com.parkinggarage.parking.ParkingType;

public class Main {
    public static void main(String[] args) throws ParkingFullException {
        Car car1 = new Car(CarSize.MEDIUM, true, "xxxxx");
        Car car2 = new Car(CarSize.SMALL, true, "yyyyyy");
        Car car3 = new Car(CarSize.LARGE, true, "ZZZZZZ");

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);

        ParkingSection electricHourly = new ParkingSection(ParkingType.ELECTRIC_HOURLY, 10, 15.0);
        electricHourly.parkCar(car1);
        Ticket ticketCar2 = electricHourly.parkCar(car2);
        Ticket ticketCar3 = electricHourly.parkCar(car3);
        electricHourly.getParkedCars();

        System.out.println("\n\n\n");

        electricHourly.unParkCar(ticketCar2);
        electricHourly.unParkCar(ticketCar3);







    }
}