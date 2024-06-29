package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table
//@Data
//@Setter
//@Getter
//@NoArgsConstructor
//@AllArgsConstructor
public class Airline {

    public Airline() {
    }

    @Id
    private String id;

    @Column(name = "airline_name",columnDefinition = "TEXT")
    private String name;

    @OneToMany(mappedBy = "airline",cascade = CascadeType.ALL)
    private List<Flight> flight;

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    public void setAircraft(List<Aircraft> aircraft) {
        this.aircraft = aircraft;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @OneToMany(mappedBy = "airline",cascade = CascadeType.ALL)
    private List<Aircraft> aircraft;

    public Airline(String id, String name, List<Flight> flight, List<Aircraft> aircraft) {
        this.id = id;
        this.name = name;
        this.flight = flight;
        this.aircraft = aircraft;
    }
}
