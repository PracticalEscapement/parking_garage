package com.parkinggarage;

import com.parkinggarage.billing.Ticket;
import com.parkinggarage.car.Car;
import com.parkinggarage.car.CarSize;
import com.parkinggarage.exception.ParkingFullException;
import com.parkinggarage.parking.ParkingSection;
import com.parkinggarage.parking.ParkingType;

public class Main {
    public static void main(String[] args) throws ParkingFullException {
        // Car instantiation
        Car car1 = new Car(CarSize.MEDIUM, true, "AAA-1111");
        Car car2 = new Car(CarSize.SMALL, true, "BBB-2222");
        Car car3 = new Car(CarSize.LARGE, true, "CCC-3333");
        Car car4 = new Car(CarSize.MEDIUM, true, "DDD-4444");
        Car car5 = new Car(CarSize.SMALL, false, "EEE-5555");
        Car car6 = new Car(CarSize.LARGE, false, "FFF-6666");
        Car car7 = new Car(CarSize.SMALL, false, "GGG-7777");
        Car car8 = new Car(CarSize.LARGE, false, "HHH-8888");

        // parking section instantiation
        ParkingSection electricHourly = new ParkingSection(ParkingType.ELECTRIC_HOURLY, 5, 15.0);
        ParkingSection electricDaily = new ParkingSection(ParkingType.ELECTRIC_DAILY, 5, 50.0);
        ParkingSection daily = new ParkingSection(ParkingType.DAILY, 10, 30.0);
        ParkingSection hourly = new ParkingSection(ParkingType.HOURLY, 10, 10);

        // Hourly electric section
        Ticket ticketCar1 = electricHourly.parkCar(car1);
        Ticket ticketCar2 = electricHourly.parkCar(car2);
        Ticket ticketCar3 = electricHourly.parkCar(car3);
        electricHourly.getParkedCars();
        electricHourly.unParkCar(ticketCar2);
        electricHourly.unParkCar(ticketCar3);
        electricHourly.getParkedCars();

//        // Daily electric section
//        electricHourly.parkCar(car1);
//        Ticket ticketCar2 = electricHourly.parkCar(car2);
//        Ticket ticketCar3 = electricHourly.parkCar(car3);
//        electricHourly.getParkedCars();
//        electricHourly.unParkCar(ticketCar2);
//        electricHourly.unParkCar(ticketCar3);
//        electricHourly.getParkedCars();
//
//        // Electric section
//        electricHourly.parkCar(car1);
//        Ticket ticketCar2 = electricHourly.parkCar(car2);
//        Ticket ticketCar3 = electricHourly.parkCar(car3);
//        electricHourly.getParkedCars();
//        electricHourly.unParkCar(ticketCar2);
//        electricHourly.unParkCar(ticketCar3);
//        electricHourly.getParkedCars();
//
//        // Electric section
//        electricHourly.parkCar(car1);
//        Ticket ticketCar2 = electricHourly.parkCar(car2);
//        Ticket ticketCar3 = electricHourly.parkCar(car3);
//        electricHourly.getParkedCars();
//        electricHourly.unParkCar(ticketCar2);
//        electricHourly.unParkCar(ticketCar3);
//        electricHourly.getParkedCars();
//














    }
}