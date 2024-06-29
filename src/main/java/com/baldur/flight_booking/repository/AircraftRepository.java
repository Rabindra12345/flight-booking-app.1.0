package com.baldur.flight_booking.repository;

import com.baldur.flight_booking.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft,Integer> {

    @Query("SELECT a FROM Aircraft a WHERE a.airline.id =:airlineId")
    Aircraft findByAirlineId(@Param("airlineId") Integer airlineId);

    @Query("SELECT a FROM Aircraft a WHERE a.name =:aircraftName")
    Aircraft findByAircraftName(@Param("aircraftName") String aircraftName);
}
