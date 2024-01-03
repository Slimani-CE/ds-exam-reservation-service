package com.slimani.reservationservice;

import com.slimani.reservationservice.dto.ReservationRequestDTO;
import com.slimani.reservationservice.enums.ResourceType;
import com.slimani.reservationservice.feign.ResourceFeignClientService;
import com.slimani.reservationservice.model.Resource;
import com.slimani.reservationservice.service.ReservationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.Duration;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class ReservationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReservationServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ReservationService reservationService, ResourceFeignClientService resourceFeignClientService) {
        return args -> {
            // Get resources
//            List<Resource> resources = resourceFeignClientService.getResources();
            reservationService.saveReservation(ReservationRequestDTO.builder()
                            .name("IT Club Conference")
                            .context("IT Club Conference 2020")
                            .createdAt(new Date())
                            .duration(Duration.ofHours(2))
//                            .resourceId(resources.get(0).getId())
                            .build());
            reservationService.saveReservation(ReservationRequestDTO.builder()
                            .name("IT Club Workshop")
                            .context("IT Club Workshop 2020")
                            .createdAt(new Date())
                            .duration(Duration.ofHours(1))
//                            .resourceId(resources.get(1).getId())
                            .build());
            reservationService.saveReservation(ReservationRequestDTO.builder()
                            .name("IT Club Meeting")
                            .context("IT Club Meeting 2020")
                            .createdAt(new Date())
                            .duration(Duration.ofHours(1))
//                            .resourceId(resources.get(2).getId())
                            .build());
            reservationService.saveReservation(ReservationRequestDTO.builder()
                    .name("IT Club Meeting")
                    .context("IT Club Meeting 2020")
                    .createdAt(new Date())
                    .duration(Duration.ofHours(1))
//                    .resourceId(resources.get(3).getId())
                    .build());
        };
    }
}
