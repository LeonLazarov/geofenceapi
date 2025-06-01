package com.example.geofencingapi.dto;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZoneDTO {
    private Long id;
    private String name;
    private List<String> coordinates;
    private String zoneType;
}
