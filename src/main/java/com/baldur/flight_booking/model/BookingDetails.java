package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingDetails {

    @Id
    private String bookingDetailsId;

    @ManyToOne
    @JoinColumn(name="booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @OneToOne
    @JoinColumn(name="airline_id")
    private Airline airline;


    @OneToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;


    private BigDecimal totalFare;
}
