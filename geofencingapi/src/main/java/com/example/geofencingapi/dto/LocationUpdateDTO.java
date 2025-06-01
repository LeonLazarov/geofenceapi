package com.example.geofencingapi.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LocationUpdateDTO {
    private String deviceId;
    private Double latitude;
    private Double longitude;

    public String getDeviceId() {
        return "";
    }

    public Double getLatitude() {
        return 0.0;
    }

    public Double getLongitude() {
        return 0.0;
    }
}
