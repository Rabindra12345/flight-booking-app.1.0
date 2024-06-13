package com.baldur.flight_booking.service;

import com.baldur.flight_booking.payload.request.FlightRequestDto;

public interface FlightService {

    public FlightRequestDto saveFlight(String userId,String airLineId,FlightRequestDto flightRequest);

    public FlightRequestDto updateFlight(FlightRequestDto flightRequest);

//    public List<FlightResponseDto> getAllFlight();
    //get all flight based on give date day.


}
