package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
//@Data
@Table(indexes= {
        @Index (name="is_available_idx", columnList="isAvailable"),
        @Index (name="seat_class_idx", columnList="seatClass")
})
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String seatNumber;

    private boolean isAvailable;

    @Enumerated(EnumType.STRING)
    private SeatClass seatClass;

    public Seat() {
    }

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    public Seat(Aircraft aircraft, Flight flight, SeatClass seatClass, boolean isAvailable, String seatNumber, Long id) {
        this.aircraft = aircraft;
        this.flight = flight;
        this.seatClass = seatClass;
        this.isAvailable = isAvailable;
        this.seatNumber = seatNumber;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatNumber='" + seatNumber + '\'' +
                ", isAvailable=" + isAvailable +
                ", seatClass=" + seatClass +
                ", flight=" + flight +
                ", aircraft=" + aircraft +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(SeatClass seatClass) {
        this.seatClass = seatClass;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }
}
