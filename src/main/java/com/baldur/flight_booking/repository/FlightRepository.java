package com.baldur.flight_booking.repository;

import com.baldur.flight_booking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {

    Optional<Flight> getFlightByFlightNumber(String id);
}
