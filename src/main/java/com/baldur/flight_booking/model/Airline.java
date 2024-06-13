package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Airline {

    @Id
    private String id;

    @Column(name = "airline_name",columnDefinition = "TEXT")
    private String name;

    @OneToMany(mappedBy = "airline",cascade = CascadeType.ALL)
    private List<Flight> flight;
}
