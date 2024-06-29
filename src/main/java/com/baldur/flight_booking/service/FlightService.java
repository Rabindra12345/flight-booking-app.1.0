package com.baldur.flight_booking.service;

import com.baldur.flight_booking.model.Flight;
import com.baldur.flight_booking.payload.request.FlightRequestDto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {

    public FlightRequestDto saveFlight(String userId,String airLineId,FlightRequestDto flightRequest);

    public FlightRequestDto updateFlight(FlightRequestDto flightRequest);

    List<Flight> getFlightUsingDepartureTime(LocalDateTime startTime, LocalDateTime endTime);

}
