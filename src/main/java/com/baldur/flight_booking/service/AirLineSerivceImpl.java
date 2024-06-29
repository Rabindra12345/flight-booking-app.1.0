package com.baldur.flight_booking.service;

import com.baldur.flight_booking.exception.FieldNotFoundException;
import com.baldur.flight_booking.model.Aircraft;
import com.baldur.flight_booking.model.Airline;
import com.baldur.flight_booking.model.Seat;
import com.baldur.flight_booking.repository.AirLineRepository;
import com.baldur.flight_booking.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 *  @Author:Rabindra
 */
@Service
public class AirLineSerivceImpl implements AirLineService{

    @Autowired
    private AirLineRepository airLineRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Override
    public Airline addAirlines(String airLineName) {
        if(airLineName!=null && !airLineName.isEmpty()){
            String randomId = UUID.randomUUID().toString();
            var airLine = new Airline();
            airLine.setId(randomId);
            airLine.setName(airLineName);
            airLineRepository.save(airLine);
            return airLine;

        }
        throw new FieldNotFoundException("AirLine field not found","AirLine name is not passed.","601");
    }


    @Override
    public void addSeatInfo(Seat seatInfo) {

    }

    @Override
    public Aircraft addAirCraft(String airlineName, String aircraftName) {
       if(aircraftName!=null && !aircraftName.isEmpty()){
           Aircraft aircraft = new Aircraft();
           Airline airline = new Airline();
           airline.setId(airlineName);
            aircraft.setName(aircraftName);
            aircraft.setAirline(airline);
            aircraftRepository.save(aircraft);
            return aircraft;
       }
        throw new FieldNotFoundException("AirLine field not found","AirLine name is not passed.","601");
    }
}
