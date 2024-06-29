package com.baldur.flight_booking.controller;

import com.baldur.flight_booking.constants.ApiResponse;
import com.baldur.flight_booking.constants.ErrorCode;
//import com.baldur.flight_booking.mapper.FlightMapper;
import com.baldur.flight_booking.mapper.CustomFlightMapper;
import com.baldur.flight_booking.model.Flight;
import com.baldur.flight_booking.payload.request.FlightRequestDto;
import com.baldur.flight_booking.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@RestController
public class FlightController {

    //FLIGHT MERGE FUNCITONALITY BY AIRLINE STAFF OR AIRLINE ADMIN CHECK IF BOOKING NUMBER IS DONE WHICH IS COMPLETE THEN AND STILL
    //PASSENGER IS NOT FULL THEN COULD MERGE TWO FLIGHT

    @Autowired
    private FlightService flightService;

    @Autowired
    private CustomFlightMapper flightMapper;


    @PostMapping(value = "/saveFlight/{userId}/{airLineId}", produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> saveFlight(@PathVariable("userId")String userId, @PathVariable("airLineId") String airLineId, @RequestBody FlightRequestDto request) {
        request = flightService.saveFlight(userId,airLineId,request);
        return ResponseEntity.ok(ApiResponse.forSuccess(ErrorCode.OK.getStatusCode(), request));
    }

    //add new airport functionality to admin if he is admin
    // he should be able to add new airport place add garesi arrival or departure dutai update huxa


    //CHECK THIS PREAUTHORIZE IS ROBUST OR NOT.
    @PutMapping(value="/updateFlight",produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> updateFlight(@RequestBody FlightRequestDto flightEditRequest) {
        flightEditRequest = flightService.updateFlight(flightEditRequest);
//        ERole eRole =ERole.ROLE_ADMIN;
        return ResponseEntity.ok(ApiResponse.forSuccess(ErrorCode.OK.getStatusCode(), flightEditRequest));
    }

    @GetMapping(value ="/getFlights",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getFlightUsingDepartureTime(@RequestParam("startDate") @DateTimeFormat(iso= DateTimeFormat.ISO.DATE) LocalDate startDate,@RequestParam(value = "endDate",required = false) LocalDate endDate){
        LocalDateTime startDateTime = startDate.atStartOfDay();
//        System.out.println("LOgging mapper __" +flightMapper);
        LocalDateTime endDateTime = (endDate!=null ? endDate: startDate).atTime(LocalTime.MAX);
        List<Flight> flightRequestDto = flightService.getFlightUsingDepartureTime(startDateTime,endDateTime);
//        return ResponseEntity.ok(  flightRequestDto);
        return ResponseEntity.ok( ApiResponse.forSuccess(ErrorCode.OK.getStatusCode(), flightMapper.flightListToFlightResponseDtoList(flightRequestDto)));
    }
}
