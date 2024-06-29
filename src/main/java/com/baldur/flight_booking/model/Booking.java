package com.baldur.flight_booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
//@NoArgsConstructor
//@Data
//@AllArgsConstructor
public class Booking {

    @Id
    private String bookingId;

    //totalfare or fare
    private BigDecimal fare;

    private int noOfAdultPerson;

    private int noOfInfantPerson;

    private int noOfChildPerson;

    private int bookedSeats;

    private LocalDateTime bookingDate;

    @Enumerated(EnumType.STRING)
    @Column
    private BookingStatus bookingStatus;

    //relationship with customer
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId='" + bookingId + '\'' +
                ", fare=" + fare +
                ", noOfAdultPerson=" + noOfAdultPerson +
                ", noOfInfantPerson=" + noOfInfantPerson +
                ", noOfChildPerson=" + noOfChildPerson +
                ", bookedSeats=" + bookedSeats +
                ", bookingDate=" + bookingDate +
                ", bookingStatus=" + bookingStatus +
                ", user=" + user +
                ", flightList=" + flightList +
                ", bookingDetails=" + bookingDetails +
                '}';
    }

    public Booking(BookingStatus bookingStatus, String bookingId, BigDecimal fare, int noOfAdultPerson, int noOfInfantPerson, int noOfChildPerson, int bookedSeats, LocalDateTime bookingDate, User user, List<Flight> flightList, BookingDetails bookingDetails) {
        this.bookingStatus = bookingStatus;
        this.bookingId = bookingId;
        this.fare = fare;
        this.noOfAdultPerson = noOfAdultPerson;
        this.noOfInfantPerson = noOfInfantPerson;
        this.noOfChildPerson = noOfChildPerson;
        this.bookedSeats = bookedSeats;
        this.bookingDate = bookingDate;
        this.user = user;
        this.flightList = flightList;
        this.bookingDetails = bookingDetails;
    }

    @ManyToMany()
    @JoinTable(
            name = "booking_user",
            joinColumns = @JoinColumn(name = "booking_id"),
            inverseJoinColumns = @JoinColumn(name = "flight_id")
    )
    //relationship with flight
    private List<Flight> flightList;


    @OneToOne(mappedBy="booking")
    private BookingDetails bookingDetails;


    public Booking() {
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public BigDecimal getFare() {
        return fare;
    }

    public void setFare(BigDecimal fare) {
        this.fare = fare;
    }

    public int getNoOfAdultPerson() {
        return noOfAdultPerson;
    }

    public void setNoOfAdultPerson(int noOfAdultPerson) {
        this.noOfAdultPerson = noOfAdultPerson;
    }

    public int getNoOfInfantPerson() {
        return noOfInfantPerson;
    }

    public void setNoOfInfantPerson(int noOfInfantPerson) {
        this.noOfInfantPerson = noOfInfantPerson;
    }

    public int getNoOfChildPerson() {
        return noOfChildPerson;
    }

    public void setNoOfChildPerson(int noOfChildPerson) {
        this.noOfChildPerson = noOfChildPerson;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(int bookedSeats) {
        this.bookedSeats = bookedSeats;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Flight> getFlightList() {
        return flightList;
    }

    public void setFlightList(List<Flight> flightList) {
        this.flightList = flightList;
    }

    public BookingDetails getBookingDetails() {
        return bookingDetails;
    }

    public void setBookingDetails(BookingDetails bookingDetails) {
        this.bookingDetails = bookingDetails;
    }


}
