package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table
public class Flight {

    @Id
    private String flightNumber;

//    private String departureCity;

    public Flight() {
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

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
//having airport entity is beneficial along with AirCraft entity

    private int seatLimit;

    private int availableSeat;

    private LocalDateTime departureTime;

    private String departureAirport;

    private String arrivalAirport;

    public Flight(BigDecimal infantTicketCharge, String flightNumber, int seatLimit, int availableSeat, LocalDateTime departureTime, String departureAirport, String arrivalAirport, LocalDateTime arrivalTime, BigDecimal adultTicketCharge, BigDecimal childTicketCharge, Airline airline, User user, List<Booking> bookings, Aircraft aircraft) {
        this.infantTicketCharge = infantTicketCharge;
        this.flightNumber = flightNumber;
        this.seatLimit = seatLimit;
        this.availableSeat = availableSeat;
        this.departureTime = departureTime;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.arrivalTime = arrivalTime;
        this.adultTicketCharge = adultTicketCharge;
        this.childTicketCharge = childTicketCharge;
        this.airline = airline;
        this.user = user;
        this.bookings = bookings;
        this.aircraft = aircraft;
    }

    private LocalDateTime arrivalTime;

    //charge
    private BigDecimal adultTicketCharge;

    private BigDecimal childTicketCharge;

    private BigDecimal infantTicketCharge;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    //realationship with customer
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    //relationship with booking
    @ManyToMany(mappedBy = "flightList",cascade= CascadeType.ALL)
    private List<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;
}
