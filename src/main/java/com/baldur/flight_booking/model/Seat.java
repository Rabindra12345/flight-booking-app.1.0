package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
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

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;
}
