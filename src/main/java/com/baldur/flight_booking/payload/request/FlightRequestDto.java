package com.baldur.flight_booking.payload.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@ToString
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

    private String departureAirport;

    private String arrivalAirport;
    //charge
    private BigDecimal adultTicketCharge;

    private BigDecimal childTicketCharge;

    private BigDecimal infantTicketCharge;
}
