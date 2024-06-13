package com.baldur.flight_booking.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table
@NoArgsConstructor
@Data
public class Notification {

    @Id
    private String notificationId;

    private boolean isRead;

    @NotEmpty
    @Column(name = "message")
    private String message;

    @Column(name = "link")
    private String link;

    private LocalDateTime notificationTime;

    //relationship with user
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiver_user_id")
    private User receiver;

    //relationship with booking
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "booking_id")
    private Booking booking;
}
