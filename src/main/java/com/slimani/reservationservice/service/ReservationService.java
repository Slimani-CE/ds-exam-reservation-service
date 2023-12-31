package com.slimani.reservationservice.service;

import com.slimani.reservationservice.dto.ReservationRequestDTO;
import com.slimani.reservationservice.dto.ReservationResponseDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ReservationService {
    // Save a new reservation
    ReservationResponseDTO saveReservation(ReservationRequestDTO reservationRequestDTO);

    // Get all reservations
    List<ReservationResponseDTO> getAllReservations();
}
