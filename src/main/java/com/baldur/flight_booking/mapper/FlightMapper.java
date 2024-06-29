//package com.baldur.flight_booking.mapper;
//
//import com.baldur.flight_booking.model.Flight;
//import com.baldur.flight_booking.payload.response.FlightResponseDto;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//import org.mapstruct.Mappings;
//import org.mapstruct.factory.Mappers;
//
//import java.util.List;
//
//@Mapper
//public interface FlightMapper {
//
//    FlightMapper INSTANCE = Mappers.getMapper(FlightMapper.class);
//
////    @Mappings({
////            @Mapping(source = "flight.airline", target = "airlineName"),
////            @Mapping(source = "aircraft.name", target = "aircraftName")
////    })
//    FlightResponseDto toDto(Flight flight);
//
//    List<FlightResponseDto> toDtoList(List<Flight> flights);
//}
//
//
//
