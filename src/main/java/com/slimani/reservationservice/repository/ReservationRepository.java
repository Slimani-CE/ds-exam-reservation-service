package com.slimani.reservationservice.repository;

import com.slimani.reservationservice.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
