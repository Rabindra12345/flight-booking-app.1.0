package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
//@Data
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int totalSeats;

    public Aircraft() {
    }

    public Aircraft(Integer id, String name, int totalSeats, Airline airline, List<Seat> seats, List<Flight> flight) {
        this.id = id;
        this.name = name;
        this.totalSeats = totalSeats;
        this.airline = airline;
        this.seats = seats;
        this.flight = flight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Flight> getFlight() {
        return flight;
    }

    public void setFlight(List<Flight> flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", totalSeats=" + totalSeats +
                ", airline=" + airline +
                '}';
    }

    @ManyToOne
    @JoinColumn(name = "airlineId")
    private Airline airline;

    @OneToMany(mappedBy = "aircraft",cascade= CascadeType.ALL)
    private List<Seat> seats;

    @OneToMany(mappedBy = "aircraft",cascade= CascadeType.ALL)
    private List<Flight> flight;
}
