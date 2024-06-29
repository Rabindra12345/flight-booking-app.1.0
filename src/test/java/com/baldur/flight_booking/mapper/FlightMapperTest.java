//package com.baldur.flight_booking.mapper;
//
//import com.baldur.flight_booking.model.Flight;
//import com.baldur.flight_booking.payload.request.FlightRequestDto;
//import com.baldur.flight_booking.payload.response.FlightResponseDto;
//import org.hibernate.annotations.DialectOverride;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
////@ExtendWith(MockitoExtension.class)
////with spring boot context it loads all the context of our project but extend with doensot do that
///**
// @author:rabindra
// **/
//@SpringBootTest
//@Disabled
//public class FlightMapperTest {
//
//    @Autowired
//    CustomFlightMapper flightMapper;
//
//    @Test
//    @Disabled
//    public void givenSourceToDestination_whenMaps_thenCorrect() {
//        Flight flight = new Flight();
//        flight.setFlightNumber("1234FX");
//        flight.setInfantTicketCharge(new BigDecimal(12.34));
//
//
//        FlightResponseDto destination = flightMapper.flightToFlightResponseDto(flight);
//
//        assertEquals(flight.getFlightNumber(), destination.getFlightNumber());
////        assertEquals(simpleSource.getDescription(), destination.getDescription());
//    }
//
////    @Test
////    public void givenDestinationToSource_whenMaps_thenCorrect() {
////        FlightResponseDto destination = new FlightResponseDto();
////        destination.setAvailableSeat(120);
////        destination.setFlightNumber("BDH-1234");
////
////        Flight source = flightMapper.destinationToSource(destination);
////
////        assertEquals(destination.getName(), source.getName());
////        assertEquals(destination.getDescription(), source.getDescription());
////    }
//
//}
