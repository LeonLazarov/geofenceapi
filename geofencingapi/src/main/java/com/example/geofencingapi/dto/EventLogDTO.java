package com.example.geofencingapi.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventLogDTO {
    private Long id;
    private String deviceId;
    private Long zoneId;
    private String eventType;
    private LocalDateTime timestamp;
}
