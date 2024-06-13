package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Booking {

    @Id
    private String bookingId;

    //totalfare or fare
    private BigDecimal fare;

    private int noOfPerson;

    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @Column
    private BookingStatus bookingStatus;

    //relationship with customer
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany()
    @JoinTable(
            name = "booking_user",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    //relationship with flight
    private List<Flight> flightList;


}
