package com.example.geofencingapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SubscriptionDTO {
    private Long id;
    private String deviceId;
    private Long zoneId;
}
