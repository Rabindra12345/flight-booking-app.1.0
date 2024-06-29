package com.baldur.flight_booking.repository;

import com.baldur.flight_booking.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface FlightRepository extends JpaRepository<Flight,String> {

    Optional<Flight> getFlightByFlightNumber(String id);

    @Query("SELECT f FROM Flight f WHERE f.departureTime BETWEEN :startTime AND :endTime")
    List<Flight> findAllByDepartureTimeBetween(@Param("startTime") LocalDateTime startTime,@Param("endTime") LocalDateTime endTime);
}
