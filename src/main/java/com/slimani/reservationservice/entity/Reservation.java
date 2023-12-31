package com.slimani.reservationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.Duration;
import java.util.Date;

@Entity
@Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String context;
    private Date createdAt;
    private Duration duration;
}
