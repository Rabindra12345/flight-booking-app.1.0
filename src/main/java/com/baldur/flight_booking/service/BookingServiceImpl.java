package com.baldur.flight_booking.service;

import com.baldur.flight_booking.constants.ErrorCode;
import com.baldur.flight_booking.exception.UserNotFoundException;
import com.baldur.flight_booking.model.*;
import com.baldur.flight_booking.payload.request.BookingRequestDto;
import com.baldur.flight_booking.repository.AircraftRepository;
import com.baldur.flight_booking.repository.BookingRepository;
import com.baldur.flight_booking.repository.FlightRepository;
import com.baldur.flight_booking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :rabindra
 */
@Service
public class BookingServiceImpl implements BookingService{

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AircraftRepository aircraftRepository;

    @Autowired
    private BookingRepository bookingRepository;

    //flightid and booking id empty or not check


    @Override
    public Booking createBookingRequest(BookingRequestDto request) {

        //THINKING ABOUT SETTING BOOKING DISCOUNT ?
        if(request.getUserId() == null&& request.getUserId().isEmpty())
            throw new UserNotFoundException("User not found","User with id " + request.getUserId() + "no found.", ErrorCode.NOT_FOUND.getStatusCode());
        if(request.getFlightIds() == null)
            throw new NotFoundException("flight ids should not be null");
        Booking booking = new Booking();
        booking.setFare(request.getFare());
        int totalPerson =request.getNoOfAdultPerson()+request.getNoOfChildPerson()+request.getNoOfInfantPerson();
//        booking.setNoOfPerson(request.getNoOfPerson());
        booking.setNoOfAdultPerson(request.getNoOfAdultPerson());
        booking.setNoOfInfantPerson(request.getNoOfInfantPerson());
        booking.setNoOfChildPerson(request.getNoOfChildPerson());
        booking.setBookingDate(request.getBookingDate());
        booking.setBookingStatus(BookingStatus.PENDING);

        User user = userRepository.findById(request.getUserId())
               .orElseThrow(() -> new RuntimeException("User not found"));
        booking.setUser(user);
        List<Flight> flights = request.getFlightIds().stream()
               .map(flightId -> flightRepository.findById(flightId)
                       .orElseThrow(() -> new RuntimeException("Flight not found")))
               .collect(Collectors.toList());
        //fare calculations works for round trip too .
        BigDecimal totalFare = new BigDecimal(0.00);
        for(Flight flight:flights){
            BigDecimal flightCharge= calculateTotalCharge(flight,request.getNoOfAdultPerson(),request.getNoOfChildPerson(),request.getNoOfInfantPerson());
            totalFare = totalFare.add(flightCharge);
        }
        booking.setFare(totalFare);
        booking.setFlightList(flights);
        //rount trip ko case ma ho list of flight aauna sakne tini haru ko case ma booking eutai hunxa flight chai multiple huney vayo.
        booking.setBookingStatus(BookingStatus.BOOKED);
        //get total seats and sets booking or available seats
//        Aircraft aircraftId =flights.get(0).getAircraft();
//        Aircraft aircraft = aircraftRepository.findByAircraftId(aircraftId.getId());
//        int availableSeat =
//        int availableSeat =aircraft.getTotalSeats()-totalPerson;
//        if(availableSeat){
//
//        }
        booking.setBookedSeats(request.getFlightIds().size());
        bookingRepository.save(booking);;
        return booking;

//        return null;
    }

    public BigDecimal calculateTotalCharge(Flight flight, int ... persons){
        int adults = persons[0];
        int children = persons[1];
        int infants = persons[2];
        return  flight.getAdultTicketCharge().multiply(BigDecimal.valueOf(adults))
                .add(flight.getInfantTicketCharge().multiply(BigDecimal.valueOf(infants)))
                .add(flight.getChildTicketCharge().multiply(BigDecimal.valueOf(children)));
    }
}
