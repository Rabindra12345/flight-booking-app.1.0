package com.baldur.flight_booking.controller;


import com.baldur.flight_booking.payload.request.BookingRequestDto;
import com.baldur.flight_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlightBookingController {

    @Autowired
    private BookingService bookingRequestService;

    @GetMapping(value = "/createBooking",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createBooking(@RequestBody BookingRequestDto request){

        if(request!=null){
            //flightid and booking id empty or not check
//            if(request.getUser()){
                request = bookingRequestService.createBookingRequest(request);
        }
        return ResponseEntity.ok(request);
    }
}
