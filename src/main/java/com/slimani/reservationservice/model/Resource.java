package com.slimani.reservationservice.model;

import com.slimani.reservationservice.enums.ResourceType;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Resource {
    private String id;
    private String name;
    private ResourceType type;
}
