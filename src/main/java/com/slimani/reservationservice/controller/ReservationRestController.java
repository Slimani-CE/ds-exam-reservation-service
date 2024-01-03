package com.slimani.reservationservice.controller;

import com.slimani.reservationservice.dto.ReservationRequestDTO;
import com.slimani.reservationservice.dto.ReservationResponseDTO;
import com.slimani.reservationservice.exceptions.ReservationNotFoundException;
import com.slimani.reservationservice.service.ReservationService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@OpenAPIDefinition
@RequestMapping("/reservations")
public class ReservationRestController {
    private final ReservationService reservationService;

    public ReservationRestController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    // Get authenticated user
    @GetMapping("/auth")
    @ResponseBody
    public ResponseEntity<Authentication> getAuthenticatedUser(Authentication authentication) {
        if (authentication == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(authentication);
    }

    // Get all reservations
    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<List<ReservationResponseDTO>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    // Get reservation by id
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReservationResponseDTO> getReservationById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(reservationService.getReservationById(id));
        } catch (ReservationNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Save reservation
    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReservationResponseDTO> saveReservation(@RequestBody ReservationRequestDTO reservationRequestDTO) {
        return ResponseEntity.ok(reservationService.saveReservation(reservationRequestDTO));
    }

    // Update reservation
    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ReservationResponseDTO> updateReservation(@PathVariable String id, @RequestBody ReservationRequestDTO reservationRequestDTO) {
        try {
            return ResponseEntity.ok(reservationService.updateReservation(id, reservationRequestDTO));
        } catch (ReservationNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete reservation
    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteReservation(@PathVariable String id) {
        try {
            reservationService.deleteReservation(id);
            return ResponseEntity.ok().build();
        } catch (ReservationNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
