package com.slimani.reservationservice;

import com.slimani.reservationservice.dto.ReservationRequestDTO;
import com.slimani.reservationservice.service.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Date;

@SpringBootApplication
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ReservationService reservationService) {
        return args -> {
            reservationService.saveReservation(ReservationRequestDTO.builder()
                            .name("IT Club Conference")
                            .context("IT Club Conference 2020")
                            .createdAt(new Date())
                            .duration(Duration.ofHours(2))
                            .build());
            reservationService.saveReservation(ReservationRequestDTO.builder()
                            .name("IT Club Workshop")
                            .context("IT Club Workshop 2020")
                            .createdAt(new Date())
                            .duration(Duration.ofHours(1))
                            .build());
            reservationService.saveReservation(ReservationRequestDTO.builder()
                            .name("IT Club Meeting")
                            .context("IT Club Meeting 2020")
                            .createdAt(new Date())
                            .duration(Duration.ofHours(1))
                            .build());
        };
    }
}
