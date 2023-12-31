package com.slimani.reservationservice.service;

import com.slimani.reservationservice.dto.ReservationRequestDTO;
import com.slimani.reservationservice.dto.ReservationResponseDTO;
import com.slimani.reservationservice.entity.Reservation;
import com.slimani.reservationservice.mapper.ReservationMapper;
import com.slimani.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService{
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    @Override
    public ReservationResponseDTO saveReservation(ReservationRequestDTO reservationRequestDTO) {
        Reservation savedReservation = reservationRepository.save(reservationMapper.mapToReservation(reservationRequestDTO));
        return reservationMapper.mapToReservationResponseDTO(savedReservation);
    }

    @Override
    public List<ReservationResponseDTO> getAllReservations() {
        return reservationRepository.findAll().stream().map(reservationMapper::mapToReservationResponseDTO).toList();
    }
}
