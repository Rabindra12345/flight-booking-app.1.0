package com.baldur.flight_booking.service;

import com.baldur.flight_booking.exception.DatabaseException;
import com.baldur.flight_booking.exception.DuplicateValueException;
import com.baldur.flight_booking.exception.FlightCrieteriaNotMet;
import com.baldur.flight_booking.exception.UserNotFoundException;
import com.baldur.flight_booking.model.Airline;
import com.baldur.flight_booking.model.Flight;
import com.baldur.flight_booking.model.User;
import com.baldur.flight_booking.payload.request.FlightRequestDto;
import com.baldur.flight_booking.repository.FlightRepository;
import jakarta.transaction.Transactional;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.Optional;

@Service
public class FlightServiceImpl  implements FlightService{

    private static final Logger logger = LogManager.getLogger(FlightServiceImpl.class);

    @Autowired
    private FlightRepository flightRepository;

//    @Autowired
//    private FlightToFlightReponseDtoMapper mapper;

    @Override
    @Transactional
    public FlightRequestDto saveFlight(String userId, String airLineId,FlightRequestDto flightRequest) {

        if(userId == null || userId.isEmpty())
            throw new UserNotFoundException("User not found ","User with given Id not found","404");
        Optional<Flight> flightOpt = flightRepository.getFlightByFlightNumber(flightRequest.getFlightNumber());
        if(flightOpt.isPresent())
            throw new DuplicateValueException(604, "Flight with given flight number already exists","Try adding next flight");

        logger.info("LOGGING FLIGHT REQUEST DTO {} ", flightRequest.toString());
        //CHECK IF THESE TWO CONDITION CAN BE OPTIMIZED.
        String flightID ="someRandomId";
        if(flightRequest.getDepartureCity()!=null && !flightRequest.getDepartureCity().isEmpty() && flightRequest.getArrivalCity()!=null && !flightRequest.getArrivalCity().isEmpty()
        ){
            var flight = new Flight();
            flight.setFlightNumber(flightRequest.getFlightNumber());
            var user = new User();
            user.setId(userId);
            flight.setUser(user);
            var airLine = new Airline();
            airLine.setId(airLineId);
            flight.setDepartureCity(flightRequest.getDepartureCity());
            flight.setArrivalCity(flightRequest.getArrivalCity());
            flight.setDepartureTime(flightRequest.getDepartureTime());
            flight.setArrivalTime(flightRequest.getArrivalTime());
            flight.setAirline(airLine);
            flight.setAdultTicketCharge(flightRequest.getAdultTicketCharge());
            flight.setInfantTicketCharge(flightRequest.getInfantTicketCharge());
            flight.setChildTicketCharge(flightRequest.getChildTicketCharge());
            flight.setSeatLimit(flightRequest.getSeatLimit());
            flight.setArrivalAirport(flightRequest.getArrivalAirport());
            flight.setDepartureAirport(flightRequest.getDepartureAirport());


            //how to return saved db entity without hitting the db
           flightRepository.save(flight);

           return flightRequest;
        }
        //ticket charge comes from flightrequest because it might get changed
        //
        // .here include robus approach to set fields of exception
        throw new FlightCrieteriaNotMet(407,"each field is required","Please include all field");
    }

    @Override
    public FlightRequestDto updateFlight(FlightRequestDto flightRequest) {

        if (flightRequest.getDepartureCity() == null || flightRequest.getDepartureCity().isEmpty() ||
                flightRequest.getArrivalCity() == null || flightRequest.getArrivalCity().isEmpty()) {
            throw new FlightCrieteriaNotMet(407, "Each field is required", "Please include all fields");
        }

        try {
            Optional<Flight> flightOpt = flightRepository.getFlightByFlightNumber(flightRequest.getFlightNumber());

            if (flightOpt.isPresent()) {
                Flight flight = flightOpt.get();


                // Update fields if they are different
                updateField(flightRequest.getFlightNumber(), flight::getFlightNumber, flight::setFlightNumber);
                updateField(flightRequest.getDepartureTime(), flight::getDepartureTime, flight::setDepartureTime);
                updateField(flightRequest.getArrivalTime(), flight::getArrivalTime, flight::setArrivalTime);
                updateField(flightRequest.getSeatLimit(), flight::getSeatLimit, flight::setSeatLimit);
                updateField(flightRequest.getAdultTicketCharge(), flight::getAdultTicketCharge, flight::setAdultTicketCharge);
                updateField(flightRequest.getInfantTicketCharge(), flight::getInfantTicketCharge, flight::setInfantTicketCharge);
                updateField(flightRequest.getChildTicketCharge(), flight::getChildTicketCharge, flight::setChildTicketCharge);
                updateField(flightRequest.getDepartureCity(), flight::getDepartureCity, flight::setDepartureCity);
                updateField(flightRequest.getArrivalCity(), flight::getArrivalCity, flight::setArrivalCity);

//                // Save the updated flight
//                flightRepository.save(flight);

                // Update fields if they are different
//                if (flightRequest.getFlightNumber() != null && !flightRequest.getFlightNumber().equals(flight.getFlightNumber())) {
//                    flight.setFlightNumber(flightRequest.getFlightNumber());
//                }
//                if (flightRequest.getDepartureTime() != null && !flightRequest.getDepartureTime().equals(flight.getDepartureTime())) {
//                    flight.setDepartureTime(flightRequest.getDepartureTime());
//                }
//                if (flightRequest.getArrivalTime() != null && !flightRequest.getArrivalTime().equals(flight.getArrivalTime())) {
//                    flight.setArrivalTime(flightRequest.getArrivalTime());
//                }
//                if (flightRequest.getSeatLimit() != flight.getSeatLimit()) {
//                    flight.setSeatLimit(flightRequest.getSeatLimit());
//                }
//                if (flightRequest.getTicketCharge() != null && flightRequest.getTicketCharge().compareTo(flight.getTicketCharge()) != 0) {
//                    flight.setTicketCharge(flightRequest.getTicketCharge());
//                }
//                if (flightRequest.getDepartureCity() != null && !flightRequest.getDepartureCity().equals(flight.getDepartureCity())) {
//                    flight.setDepartureCity(flightRequest.getDepartureCity());
//                }
//                if (flightRequest.getArrivalCity() != null && !flightRequest.getArrivalCity().equals(flight.getArrivalCity())) {
//                    flight.setArrivalCity(flightRequest.getArrivalCity());
//                }

                // Save the updated flight
                flightRepository.save(flight);

                return flightRequest;
            } else {
                //USER PROPER EXCEPTION BECAUSE IT THROWS DEFAULT EXCEPTION THAT SHOWS THE EXCEPTION IN ALL RED FORMAT
                throw new NotFoundException("Flight not found with ID: " + flightRequest.getFlightNumber());
            }
        } catch (DataIntegrityViolationException dataIntegrityViolationException) {
            throw new DatabaseException(123, "Error occurred while updating flight: " + dataIntegrityViolationException.getMessage(), "Integrity Violation");
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("An unexpected error occurred while updating the flight");
        }

    }

    private <T> void updateField(T newValue, Supplier<T> getter, Consumer<T> setter) {
        if (newValue != null && !newValue.equals(getter.get())) {
            setter.accept(newValue);
        }
    }

}
