package com.baldur.flight_booking.repository;

import com.baldur.flight_booking.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirLineRepository extends JpaRepository<Airline,String> {

}
