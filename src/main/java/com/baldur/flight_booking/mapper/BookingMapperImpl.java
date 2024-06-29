//package com.baldur.flight_booking.mapper;
//
//import com.baldur.flight_booking.model.Booking;
//import com.baldur.flight_booking.payload.response.BookingResponseDto;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.ReportingPolicy;
//
//import java.util.List;
//import java.util.stream.Collectors;
//
//@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
//public abstract class BookingMapperImpl {
//
//    @Mapping(target = "flights", source = "booking.flightList")
//    public abstract BookingResponseDto bookingToBookingResponseDto(Booking booking);
//
//    public abstract List<BookingResponseDto> bookingListToBookingResponseListDto(List<Booking> bookingList);
//
//    public List<BookingResponseDto> bookingListToBookingResponseListDtoImpl(List<Booking> bookingList) {
//        return bookingList.stream()
//                .map(this::bookingToBookingResponseDto)
//                .collect(Collectors.toList());
//    }
//}
//
