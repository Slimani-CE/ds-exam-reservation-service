package com.slimani.reservationservice.entity;

import com.slimani.reservationservice.model.Resource;
import jakarta.persistence.*;
import lombok.*;

import java.time.Duration;
import java.util.Date;

@Entity @Getter @Setter @Builder
@AllArgsConstructor @NoArgsConstructor
public class Reservation {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;
    private String context;
    private Date createdAt;
    private Duration duration;
    private String resourceId;
    private String userId;
    @Transient
    private Resource resource;
}