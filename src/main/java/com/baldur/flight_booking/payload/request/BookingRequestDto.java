package com.baldur.flight_booking.payload.request;

import com.baldur.flight_booking.model.BookingStatus;
import com.baldur.flight_booking.model.Flight;
import com.baldur.flight_booking.model.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingRequestDto {

    private String bookingId;

    private BigDecimal fare;

    private int noOfPerson;

    private LocalDateTime bookingDate;

    private BookingStatus bookingStatus;

    private List<UserRequestDto> user;

    private List<FlightRequestDto> flight;

}
