package com.slimani.reservationservice.service;

import com.slimani.reservationservice.dto.ReservationRequestDTO;
import com.slimani.reservationservice.dto.ReservationResponseDTO;
import com.slimani.reservationservice.entity.Reservation;
import com.slimani.reservationservice.exceptions.ReservationNotFoundException;
import com.slimani.reservationservice.feign.ResourceFeignClientService;
import com.slimani.reservationservice.mapper.ReservationMapper;
import com.slimani.reservationservice.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {
    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;
    private final ResourceFeignClientService resourceFeignClientService;

    public ReservationServiceImpl(ReservationRepository reservationRepository, ReservationMapper reservationMapper, ResourceFeignClientService resourceFeignClientService) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
        this.resourceFeignClientService = resourceFeignClientService;
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

    @Override
    public ReservationResponseDTO getReservationById(String id) throws ReservationNotFoundException {
        return reservationRepository.findById(id).map(reservationMapper::mapToReservationResponseDTO).orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id: " + id));
    }

    @Override
    public void deleteReservation(String id) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id: " + id));
        reservationRepository.delete(reservation);
    }

    @Override
    public ReservationResponseDTO updateReservation(String id, ReservationRequestDTO reservationRequestDTO) throws ReservationNotFoundException {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new ReservationNotFoundException("Reservation not found with id: " + id));
        if (reservationRequestDTO.getName() != null) reservation.setName(reservationRequestDTO.getName());
        if (reservationRequestDTO.getContext() != null) reservation.setContext(reservationRequestDTO.getContext());
        if (reservationRequestDTO.getCreatedAt() != null) reservation.setCreatedAt(reservationRequestDTO.getCreatedAt());
        if (reservationRequestDTO.getDuration() != null) reservation.setDuration(reservationRequestDTO.getDuration());
        Reservation savedReservation = reservationRepository.save(reservation);
        return reservationMapper.mapToReservationResponseDTO(savedReservation);
    }
}
