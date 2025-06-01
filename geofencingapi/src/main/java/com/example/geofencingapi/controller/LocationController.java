package com.example.geofencingapi.controller;

import com.example.geofencingapi.dto.BatchLocationUpdateDTO;
import com.example.geofencingapi.dto.LocationUpdateDTO;
import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class LocationController {

    private final DeviceService deviceService;

    @PostMapping("/{deviceId}/location")
    public ResponseEntity<Device> updateLocation(
            @PathVariable String deviceId,
            @RequestBody LocationUpdateDTO dto
    ) {
        Device updated = deviceService.updateLocation(deviceId, dto.getLatitude(), dto.getLongitude());
        return ResponseEntity.ok(updated);
    }

    @PostMapping("/locations/batch")
    public ResponseEntity<Void> batchUpdate(@RequestBody BatchLocationUpdateDTO batch) {
        for (LocationUpdateDTO dto : batch.getUpdates()) {
            deviceService.updateLocation(dto.getDeviceId(), dto.getLatitude(), dto.getLongitude());
        }
        return ResponseEntity.ok().build();
    }
}
