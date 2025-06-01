package com.example.geofencingapi.dto;

import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BatchLocationUpdateDTO {
    private List<LocationUpdateDTO> updates;

    public LocationUpdateDTO[] getUpdates() {
        return new LocationUpdateDTO[0];
    }
}
