package com.slimani.reservationservice.dto;

import lombok.*;

import java.time.Duration;
import java.util.Date;

@Getter @Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationRequestDTO {
    private String name;
    private String context;
    private Date createdAt;
    private Duration duration;
}
