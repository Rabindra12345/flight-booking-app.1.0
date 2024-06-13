package com.baldur.flight_booking.service;


import com.baldur.flight_booking.payload.request.BookingRequestDto;

public interface BookingService {

    public  BookingRequestDto createBookingRequest(BookingRequestDto request);
}
