package com.baldur.flight_booking.payload.response;

import com.baldur.flight_booking.model.Aircraft;
import com.baldur.flight_booking.model.Airline;
import com.baldur.flight_booking.model.Booking;
import com.baldur.flight_booking.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
//@Data
//@ToString
public class FlightResponseDto {

//    private String flightNumber;
//
//    private String departureCity;
//
//    private String arrivalCity;
//
//    private int seatLimit;
//
//    private int availableSeat;
//
//    private LocalDateTime departureTime;
//
//    private String departureAirport;
//
//    private String arrivalAirport;
//
//    private LocalDateTime arrivalTime;
//
//    private BigDecimal adultTicketCharge;
//
//    private BigDecimal childTicketCharge;
//
//    private BigDecimal infantTicketCharge;
//
//    private Airline airline;
//
//    private User user;
//
//    private List<Booking> bookings;
//
//    private Aircraft aircraft;
    private String flightNumber;
    private int seatLimit;
    private int availableSeat;
    private LocalDateTime departureTime;
    private String departureAirport;

    public FlightResponseDto(String flightNumber, int seatLimit, int availableSeat, LocalDateTime departureTime, String departureAirport, String arrivalAirport, LocalDateTime arrivalTime, BigDecimal adultTicketCharge, BigDecimal childTicketCharge, BigDecimal infantTicketCharge) {
        this.flightNumber = flightNumber;
        this.seatLimit = seatLimit;
        this.availableSeat = availableSeat;
        this.departureTime = departureTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime = arrivalTime;
        this.adultTicketCharge = adultTicketCharge;
        this.childTicketCharge = childTicketCharge;
        this.infantTicketCharge = infantTicketCharge;
    }

    public FlightResponseDto() {
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getSeatLimit() {
        return seatLimit;
    }

    public void setSeatLimit(int seatLimit) {
        this.seatLimit = seatLimit;
    }

    public int getAvailableSeat() {
        return availableSeat;
    }

    public void setAvailableSeat(int availableSeat) {
        this.availableSeat = availableSeat;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BigDecimal getAdultTicketCharge() {
        return adultTicketCharge;
    }

    public void setAdultTicketCharge(BigDecimal adultTicketCharge) {
        this.adultTicketCharge = adultTicketCharge;
    }

    public BigDecimal getChildTicketCharge() {
        return childTicketCharge;
    }

    public void setChildTicketCharge(BigDecimal childTicketCharge) {
        this.childTicketCharge = childTicketCharge;
    }

    public BigDecimal getInfantTicketCharge() {
        return infantTicketCharge;
    }

    public void setInfantTicketCharge(BigDecimal infantTicketCharge) {
        this.infantTicketCharge = infantTicketCharge;
    }

    private String arrivalAirport;
    private LocalDateTime arrivalTime;
    private BigDecimal adultTicketCharge;
    private BigDecimal childTicketCharge;
    private BigDecimal infantTicketCharge;
//    private String airlineName;
//    private String aircraftName;

}
