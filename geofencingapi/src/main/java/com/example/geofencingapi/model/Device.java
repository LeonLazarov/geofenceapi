package com.example.geofencingapi.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Device {

    @Id
    private String id;

    private String description;

    private Double lastLatitude;
    private Double lastLongitude;
}
