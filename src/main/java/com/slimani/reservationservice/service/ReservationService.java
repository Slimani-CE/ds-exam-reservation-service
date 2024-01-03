package com.slimani.reservationservice.service;

import com.slimani.reservationservice.dto.ReservationRequestDTO;
import com.slimani.reservationservice.dto.ReservationResponseDTO;
import com.slimani.reservationservice.exceptions.ReservationNotFoundException;
import com.slimani.reservationservice.model.Resource;
import org.springframework.hateoas.PagedModel;

import java.util.List;

public interface ReservationService {
    // Save a new reservation
    ReservationResponseDTO saveReservation(ReservationRequestDTO reservationRequestDTO);

    // Get all reservations
    List<ReservationResponseDTO> getAllReservations();

    // Get reservation by id
    ReservationResponseDTO getReservationById(String id) throws ReservationNotFoundException;

    // Delete reservation
    void deleteReservation(String id) throws ReservationNotFoundException;

    // Patch reservation
    ReservationResponseDTO updateReservation(String id, ReservationRequestDTO reservationRequestDTO) throws ReservationNotFoundException;
}
