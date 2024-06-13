package com.baldur.flight_booking.controller;

import com.baldur.flight_booking.constants.ErrorCode;
import com.baldur.flight_booking.model.ERole;
import com.baldur.flight_booking.payload.request.FlightRequestDto;
import com.baldur.flight_booking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class FlightController {

//
//    {
//        "flightNumber": "AB123",
//            "departureCity": "New York",
//            "arrivalCity": "Los Angeles",
//            "seatLimit": 150,
//            "availableSeat": 100,
//            "departureTime": "2024-06-12T14:00:00",
//            "arrivalTime": "2024-06-12T17:30:00",
//            "ticketCharge": 199.99
//    }


    @Autowired
    private FlightService flightService;


    @PostMapping(value = "/saveFlight/{userId}/{airLineId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveFlight(@PathVariable("userId")String userId, @PathVariable("airLineId") String airLineId, @RequestBody FlightRequestDto request) {

        request = flightService.saveFlight(userId,airLineId,request);
        return ResponseEntity.ok((request));
    }

    //add new airport functionality to admin if he is admin
    // he should be able to add new airport place add garesi arrival or departure dutai update huxa


    //CHECK THIS PREAUTHORIZE IS ROBUST OR NOT.
    @PutMapping(value="/updateFlight",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateFlight(@RequestBody FlightRequestDto flightEditRequest) {
        flightEditRequest = flightService.updateFlight(flightEditRequest);
//        ERole eRole =ERole.ROLE_ADMIN;
        return ResponseEntity.ok(ErrorCode.OK.getStatusCode());
    }
}
