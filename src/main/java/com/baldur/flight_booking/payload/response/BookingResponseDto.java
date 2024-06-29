package com.baldur.flight_booking.payload.response;

import com.baldur.flight_booking.model.BookingStatus;
import com.baldur.flight_booking.model.Flight;
import com.baldur.flight_booking.payload.request.UserRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.ToString;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

//@Data
@JsonIgnoreProperties(ignoreUnknown = true)
//@ToString
public class BookingResponseDto {

    private String bookingId;

    private BigDecimal fare;

    private int noOfInfantPerson;

    private int noOfChildPerson;

    private int noOfAdultPerson;

    private LocalDateTime bookingDate;

    private BookingStatus bookingStatus;

    private UserRequestDto user;

    private String userId;

    public BookingResponseDto(String bookingId, BigDecimal fare, int noOfInfantPerson, int noOfChildPerson, int noOfAdultPerson, LocalDateTime bookingDate, BookingStatus bookingStatus, UserRequestDto user, String userId, List<Flight> flights) {
        this.bookingId = bookingId;
        this.fare = fare;
        this.noOfInfantPerson = noOfInfantPerson;
        this.noOfChildPerson = noOfChildPerson;
        this.noOfAdultPerson = noOfAdultPerson;
        this.bookingDate = bookingDate;
        this.bookingStatus = bookingStatus;
        this.user = user;
        this.userId = userId;
        this.flights = flights;
    }

    public BookingResponseDto() {
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

    public int getNoOfAdultPerson() {
        return noOfAdultPerson;
    }

    public void setNoOfAdultPerson(int noOfAdultPerson) {
        this.noOfAdultPerson = noOfAdultPerson;
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

    public UserRequestDto getUser() {
        return user;
    }

    public void setUser(UserRequestDto user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    private List<Flight> flights;
}
