package com.baldur.flight_booking.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//@Data
@JsonIgnoreProperties(ignoreUnknown = true)
//@ToString
public class FlightRequestDto {

    //a flight might have different charge for tickets
//    private String id;

//    {
//        "flightNumber": "AB123",
//            "departureCity": "New York",
//            "arrivalCity": "Los Angeles",
//            "seatLimit": 150,
//            "availableSeat": 150,
//            "departureTime": "2024-06-12T14:00:00",
//            "arrivalTime": "2024-06-12T17:30:00",
//            "ticketCharge": 299.99,

    @Override
    public String toString() {
        return "FlightRequestDto{" +
                "airLineNumber='" + airLineNumber + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
                ", departureCity='" + departureCity + '\'' +
                ", arrivalCity='" + arrivalCity + '\'' +
                ", seatLimit=" + seatLimit +
                ", availableSeat=" + availableSeat +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", ticketCharge=" + ticketCharge +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", adultTicketCharge=" + adultTicketCharge +
                ", childTicketCharge=" + childTicketCharge +
                ", infantTicketCharge=" + infantTicketCharge +
                ", aircraftName='" + aircraftName + '\'' +
                '}';
    }
//            "departureAirport": "JFK",
//            "arrivalAirport": "LAX",
//            "adultTicketCharge": 299.99,
//            "childTicketCharge": 149.99,
//            "infantTicketCharge": 49.99
//    }

    private String airLineNumber;

    private String flightNumber;

    private String departureCity;

    private String arrivalCity;

    private int seatLimit;

    private int availableSeat;

    private LocalDateTime departureTime;

    private LocalDateTime arrivalTime;

    //charge
    private BigDecimal ticketCharge;

    public String getAirLineNumber() {
        return airLineNumber;
    }

    public void setAirLineNumber(String airLineNumber) {
        this.airLineNumber = airLineNumber;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getArrivalCity() {
        return arrivalCity;
    }

    public void setArrivalCity(String arrivalCity) {
        this.arrivalCity = arrivalCity;
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

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public BigDecimal getTicketCharge() {
        return ticketCharge;
    }

    public void setTicketCharge(BigDecimal ticketCharge) {
        this.ticketCharge = ticketCharge;
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

    public String getAircraftName() {
        return aircraftName;
    }

    public void setAircraftName(String aircraftName) {
        this.aircraftName = aircraftName;
    }

    private String departureAirport;

    private String arrivalAirport;
    //charge
    private BigDecimal adultTicketCharge;

    private BigDecimal childTicketCharge;

    private BigDecimal infantTicketCharge;

    private String aircraftName;
}
