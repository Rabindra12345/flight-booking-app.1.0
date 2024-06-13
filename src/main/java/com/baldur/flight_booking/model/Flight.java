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
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    private String flightNumber;

    private String departureCity;

    private String arrivalCity;

    private int seatLimit;

    private int availableSeat;

    private LocalDateTime departureTime;

    private String departureAirport;

    private String arrivalAirport;

    private LocalDateTime arrivalTime;

    //charge
    private BigDecimal adultTicketCharge;

    private BigDecimal childTicketCharge;

    private BigDecimal infantTicketCharge;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @OneToMany(mappedBy = "flight",cascade= CascadeType.ALL)
    private List<Seat> seats;

    //realationship with customer
    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User user;

    //relationship with booking
    @ManyToMany(mappedBy = "flightList",cascade= CascadeType.ALL)
    private List<Booking> bookings;

}
