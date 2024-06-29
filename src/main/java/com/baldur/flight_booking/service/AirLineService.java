package com.baldur.flight_booking.service;

import com.baldur.flight_booking.model.Aircraft;
import com.baldur.flight_booking.model.Airline;
import com.baldur.flight_booking.model.Seat;

public interface AirLineService {
    public Airline addAirlines(String airLineName);

    public void addSeatInfo(Seat seatInfo);

    Aircraft addAirCraft(String airlineName, String aircraftName);
}
