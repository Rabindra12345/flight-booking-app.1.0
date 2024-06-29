package com.baldur.flight_booking.mapper;

import com.baldur.flight_booking.model.Booking;
import com.baldur.flight_booking.model.Flight;
import com.baldur.flight_booking.payload.response.BookingResponseDto;
import com.baldur.flight_booking.payload.response.FlightResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class CustomFlightMapper {

//    @Mapping(target = "flights", source = "booking.flightList")
    public FlightResponseDto flightToFlightResponseDto(Flight flight){
        FlightResponseDto flightDto = new FlightResponseDto();
        flightDto.setSeatLimit(flight.getSeatLimit());
        flightDto.setAvailableSeat(flight.getAvailableSeat());
        flightDto.setFlightNumber(flight.getFlightNumber());
        flightDto.setInfantTicketCharge(flight.getInfantTicketCharge());
        flightDto.setDepartureTime(flight.getDepartureTime());
        flightDto.setArrivalTime(flight.getArrivalTime());
        flightDto.setAvailableSeat(flight.getAvailableSeat());
        flightDto.setChildTicketCharge(flight.getChildTicketCharge());
        flightDto.setAdultTicketCharge(flight.getAdultTicketCharge());
        return flightDto;
    }

    public List<FlightResponseDto> flightListToFlightResponseDtoList(List<Flight> flightList){
        return flightList.stream().map(this::flightToFlightResponseDto).collect(Collectors.toList());
    }
}


