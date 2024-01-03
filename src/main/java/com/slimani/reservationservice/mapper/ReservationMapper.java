package com.slimani.reservationservice.mapper;

import com.slimani.reservationservice.dto.ReservationRequestDTO;
import com.slimani.reservationservice.dto.ReservationResponseDTO;
import com.slimani.reservationservice.entity.Reservation;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ReservationMapper {
    public Reservation mapToReservation(ReservationRequestDTO reservationRequestDTO) {
        return Reservation.builder()
                .name(reservationRequestDTO.getName())
                .context(reservationRequestDTO.getContext())
                .createdAt(reservationRequestDTO.getCreatedAt())
                .duration(reservationRequestDTO.getDuration())
                .resourceId(reservationRequestDTO.getResourceId())
                .userId(reservationRequestDTO.getUserId())
                .build();
    }

    public ReservationResponseDTO mapToReservationResponseDTO(Reservation savedReservation) {
        return ReservationResponseDTO.builder()
                .id(savedReservation.getId())
                .name(savedReservation.getName())
                .context(savedReservation.getContext())
                .createdAt(savedReservation.getCreatedAt())
                .duration(savedReservation.getDuration())
                .resourceId(savedReservation.getResourceId())
                .userId(savedReservation.getUserId())
                .build();
    }
}
