package com.baldur.flight_booking.controller;


import com.baldur.flight_booking.constants.ApiResponse;
import com.baldur.flight_booking.constants.ErrorCode;
//import com.baldur.flight_booking.mapper.BookingMapperImpl;
import com.baldur.flight_booking.model.Booking;
import com.baldur.flight_booking.payload.request.BookingRequestDto;
import com.baldur.flight_booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.webjars.NotFoundException;

@RestController
public class FlightBookingController {

    @Autowired
    private BookingService bookingRequestService;



//    @Autowired
//    private BookingMapperImpl bookingMapper;


    @PostMapping(value = "/createBooking",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createBooking(@RequestBody BookingRequestDto request){
        if(request==null){
            throw new NotFoundException("Booking not found");
        }
        Booking booking = bookingRequestService.createBookingRequest(request);
        return ResponseEntity.ok(ApiResponse.forSuccess( ErrorCode.OK.getStatusCode(),booking));
//        return ResponseEntity.ok(ApiResponse.forSuccess( ErrorCode.OK.getStatusCode(),booking));

    }

//    @PostMapping(value = "/completeBooking",produces = MediaType.APPLICATION_JSON_VALUE)
//    public ResponseEntity<?> completeBooking(){
//
////        if(request!=null){
//            //flightid and booking id empty or not check
////            if(request.getUser()){
//        return null ;
//    }

}

