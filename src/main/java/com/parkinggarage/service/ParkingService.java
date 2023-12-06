package com.parkinggarage.service;

import com.parkinggarage.billing.Ticket;
import com.parkinggarage.car.Car;
import com.parkinggarage.exception.ParkingFullException;
import com.parkinggarage.parking.ParkingSpace;

public interface ParkingService {
    Ticket parkCar(Car car) throws ParkingFullException;
    void unParkCar(Ticket ticket);

}
