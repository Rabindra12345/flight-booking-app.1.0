//package com.baldur.flight_booking.service;
//
//import com.baldur.flight_booking.model.Flight;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.math.BigDecimal;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@ExtendWith(MockitoExtension.class)
//@Disabled
//public class BookingServiceImplTest {
//
//    @InjectMocks
//    private BookingServiceImpl bookingService;
//
//    private Flight flight;
//
//    @BeforeEach
//    @Disabled
//    public void setUp() {
//        flight = new Flight();
//        flight.setAdultTicketCharge(new BigDecimal("100.00"));
//        flight.setChildTicketCharge(new BigDecimal("50.00"));
//        flight.setInfantTicketCharge(new BigDecimal("25.00"));
//    }
//
//    @Test
//    @Disabled
//    public void testCalculateTotalCharge_OneAdultOneChildOneInfant() {
//        BookingServiceImpl bookingService = new BookingServiceImpl();
//        BigDecimal expectedTotalCharge = new BigDecimal("175.00");
//        BigDecimal actualTotalCharge = bookingService.calculateTotalCharge(flight, 1, 1, 1);
//        assertEquals(expectedTotalCharge, actualTotalCharge);
//    }
//
//}
