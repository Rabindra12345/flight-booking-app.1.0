package com.baldur.flight_booking.controller;


import com.baldur.flight_booking.constants.ApiResponse;
import com.baldur.flight_booking.constants.ErrorCode;
import com.baldur.flight_booking.model.Airline;
import com.baldur.flight_booking.model.Seat;
import com.baldur.flight_booking.service.AirLineService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AirLineController {

    @Autowired
    private AirLineService airLineService;

    @PostMapping(value="/createAirline/{airlineName}",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addAirlines(@PathVariable("airlineName") String airLineName){

        Airline airline = airLineService.addAirlines(airLineName);
//        return ResponseEntity.ok(ErrorCode.OK.getStatusCode());

        return ResponseEntity.ok(ApiResponse.forSuccess(ErrorCode.OK.getStatusCode(),airline));

    }
    //get all airlines
    @PostMapping(value="/setSeatInfo",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addSeatDetails(@RequestBody Seat seatInfo){
        airLineService.addSeatInfo(seatInfo);
//        return ResponseEntity.ok(ErrorCode.OK.getStatusCode());
        return ResponseEntity.ok(ApiResponse.forSuccessWithoutBody(ErrorCode.OK.getStatusCode()));
    }

}
