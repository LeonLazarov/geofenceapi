package com.example.geofencingapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    private List<String> coordinates;

    private String zoneType;

    public Object getCoordinates() {
        return null;
    }

    public Object getZoneType() {
        return null;
    }

    public void setZoneType(Object zoneType) {
    }

    public void setCoordinates(Object coordinates) {
    }

    public Object getName() {
        return null;
    }

    public void setName(Object name) {
    }
}
