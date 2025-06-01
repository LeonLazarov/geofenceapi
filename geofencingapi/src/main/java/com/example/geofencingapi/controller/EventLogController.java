package com.example.geofencingapi.controller;

import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.model.EventLog;
import com.example.geofencingapi.model.Zone;
import com.example.geofencingapi.service.DeviceService;
import com.example.geofencingapi.service.EventLogService;
import com.example.geofencingapi.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event-logs")
@RequiredArgsConstructor
public class EventLogController {

    private final EventLogService eventLogService;
    private final DeviceService deviceService;
    private final ZoneService zoneService;

    @GetMapping("/by-device/{deviceId}")
    public ResponseEntity<List<EventLog>> getLogsByDevice(@PathVariable String deviceId) {
        return deviceService.getDeviceById(deviceId)
                .map(device -> ResponseEntity.ok(eventLogService.getLogsByDevice(device)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/by-zone/{zoneId}")
    public ResponseEntity<List<EventLog>> getLogsByZone(@PathVariable Long zoneId) {
        return zoneService.getZoneById(zoneId)
                .map(zone -> ResponseEntity.ok(eventLogService.getLogsByZone(zone)))
                .orElse(ResponseEntity.notFound().build());
    }
}
