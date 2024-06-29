//package com.baldur.flight_booking.controller;
//
//import com.baldur.flight_booking.constants.ApiResponse;
//import com.baldur.flight_booking.constants.ErrorCode;
//import com.baldur.flight_booking.mapper.CustomFlightMapper;
//import com.baldur.flight_booking.model.Aircraft;
//import com.baldur.flight_booking.model.Airline;
//import com.baldur.flight_booking.model.Flight;
//import com.baldur.flight_booking.payload.request.FlightRequestDto;
//import com.baldur.flight_booking.payload.response.FlightResponseDto;
//import com.baldur.flight_booking.repository.RoleRepository;
//import com.baldur.flight_booking.service.FlightService;
//import com.baldur.flight_booking.service.FlightServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.junit.jupiter.api.*;
//import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.context.annotation.Import;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.UUID;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import static org.mockito.ArgumentMatchers.*;
//import static org.mockito.Mockito.when;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.http.MediaType;
//import org.springframework.security.test.context.support.WithMockUser;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//@ExtendWith(MockitoExtension.class)
//@WebMvcTest(controllers = FlightController.class)
//public class FlightControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @InjectMocks
//    private FlightController flightController;
//
//    @Mock
//    private FlightService flightService;
//
//    private FlightRequestDto requestDto;
//
//    private FlightRequestDto savedRequestDto;
//
//    @BeforeEach
//    @Disabled
//    public void setup() {
//        requestDto = new FlightRequestDto();
//        requestDto.setAircraftName("BOEING 345");
//
//        //expected output
//        savedRequestDto = new FlightRequestDto();
//        savedRequestDto.setFlightNumber("ABC123");
//        savedRequestDto.setAircraftName(requestDto.getAircraftName());
//    }
//
//    @MockBean
//    private CustomFlightMapper flightMapper;
//
//    @Autowired
//    private ObjectMapper objectMapper;
//
////    @Test
////    public void saveFlight_whenValidInput_thenReturns200() throws Exception {
////        LocalDate startDate = LocalDate.of(2024,06,28);
////        LocalDate endDate = LocalDate.of(2024,07,04);
////        Flight flight = new Flight();
////        flight.setDepartureTime(LocalDateTime.now());
////        Aircraft aircraft = new Aircraft();
////        aircraft.setName("AIRCLARFT");
////        flight.setAircraft(aircraft);
////        Flight requestDto1 = new Flight();
////        requestDto1.setDepartureTime(startDate.atTime(LocalTime.MAX));
////        // FlightRequestDto requestDto2 = new FlightRequestDto();
////        // requestDto2.setDepartureTime(LocalDateTime.MIN);
////        List<Flight> flightRequests = new ArrayList<Flight>();
////        flightRequests.add(flight);
////        flightRequests.add(requestDto1);
////
////        FlightResponseDto responseDto = new FlightResponseDto();
////        responseDto.setFlightNumber("ABC123");
//////        responseDto.setAircraftName(requestDto.getAircraftName());
////
////        String userId = "user123";
////        String airLineId = "airline123";
////
////        // Mock the service and mapper behavior
////        Mockito.when(flightService.getFlightUsingDepartureTime(anyString(), anyString(), any(FlightRequestDto.class)))
////                .thenReturn(flightRequests.get(0));
////        Mockito.when(flightMapper.flightListToFlightResponseDtoList(anyList()))
////                .thenReturn(Collections.singletonList(responseDto));
////
////        ResponseEntity<?> responseEntity = flightController.saveFlight(userId, airLineId, requestDto);
////
////        ApiResponse<?> apiResponse = (ApiResponse<?>) responseEntity.getBody();
////        Assertions.assertNotNull(apiResponse);
////
////        // mockMvc.perform(MockMvcRequestBuilders.post("/saveFlight/{userId}/{airLineId}", "1", "1")
////        //             .contentType(MediaType.APPLICATION_JSON)
////        //             .content(objectMapper.writeValueAsString(requestDto)))
////        //     .andExpect(status().isOk())
////        //     .andExpect(jsonPath("$.status").value(ErrorCode.OK.getStatusCode()))
////        //     .andExpect(jsonPath("$.data").isArray());
////    }
//
//    @Test
//    @DisplayName("TEST FOR SAVING FLIGHT CONTROLLER METHOD.")
//    @Disabled
//    public void testSaveFlight() {
//        String userId = "user123";
//        String airLineId = "airline123";
//        Mockito.when(flightService.saveFlight(userId, airLineId, requestDto)).thenReturn(savedRequestDto);
//        ResponseEntity<?> responseEntity = flightController.saveFlight(userId, airLineId, requestDto);
//        Assertions.assertNotNull(responseEntity);
//        Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
//
//        //  headers checking, not working
////        HttpHeaders headers = responseEntity.getHeaders();
////        Assertions.assertTrue(headers.containsKey(HttpHeaders.CONTENT_TYPE));
////        Assertions.assertEquals(MediaType.APPLICATION_JSON_VALUE, headers.getContentType().toString());
//
//        ApiResponse<?> apiResponse = (ApiResponse<?>) responseEntity.getBody();
//        Assertions.assertNotNull(apiResponse);
//        FlightRequestDto responseBody = (FlightRequestDto) apiResponse.getBody();
//        Assertions.assertNotNull(responseBody);
//        Assertions.assertEquals(savedRequestDto.getFlightNumber(), responseBody.getFlightNumber());
//    }
//
//    @Test
//    @DisplayName("GETTING FLIGHTS WITH START DATE AND END DATE")
//    @Disabled
//    public void testForGettingFlightsUsingBothEndStartDate() {
//        LocalDate startDate = LocalDate.of(2024,06,28);
//        LocalDate endDate = LocalDate.of(2024,07,04);
//         Flight flight = new Flight();
//         flight.setDepartureTime(LocalDateTime.now());
//        Aircraft aircraft = new Aircraft();
//        aircraft.setName("AIRCLARFT");
//         flight.setAircraft(aircraft);
//         Flight requestDto1 = new Flight();
//         requestDto1.setDepartureTime(startDate.atTime(LocalTime.MAX));
////         FlightRequestDto requestDto2 = new FlightRequestDto();
////         requestDto2.setDepartureTime(LocalDateTime.MIN);
//         List<Flight> flightRequests = new ArrayList<Flight>();
//         flightRequests.add(flight);
//         flightRequests.add(requestDto1);
////         flightRequests.add(requestDto2);
//        System.out.println("LOGGING DEPART TIME MAX _ "+requestDto1.getDepartureTime());
//
//        Mockito.when(flightService.getFlightUsingDepartureTime(startDate.atStartOfDay(),endDate.atTime(LocalTime.MAX))).thenReturn(flightRequests);
//        ResponseEntity<?> responseEntity = flightController.getFlightUsingDepartureTime(startDate, endDate);
//        System.out.println("LOGGING RESPONSE__"+responseEntity.getBody());
//        assertEquals(flightRequests,responseEntity.getBody());
//    }
//
//    @Test
//    @Disabled
//    public void testGetFlights_NoFlightsFound_ReturnsEmptyList() {
//        // Arrange
//        LocalDate startDate = LocalDate.of(2024, 6, 12);
//        LocalDate endDate = LocalDate.of(2024, 6, 12);
//        List<Flight> expectedFlights = Collections.emptyList();
//        when(flightService.getFlightUsingDepartureTime(any(), any())).thenReturn(expectedFlights);
//        ResponseEntity<?> response =  flightController.getFlightUsingDepartureTime(startDate, endDate);
//        assertNotNull(response);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
////        assertEquals(ErrorCode.OK.getStatusCode(), response.getBody().getErrorCode());
//    }
//}
//
