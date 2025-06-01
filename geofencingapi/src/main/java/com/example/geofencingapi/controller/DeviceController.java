package com.example.geofencingapi.controller;

import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping("/register")
    public ResponseEntity<Device> registerDevice(@RequestBody Device device) {
        Device savedDevice = deviceService.registerDevice(device);
        return ResponseEntity.ok(savedDevice);
    }

    @GetMapping("/{deviceId}/location")
    public ResponseEntity<Device> getDeviceLocation(@PathVariable String deviceId) {
        return deviceService.getDeviceById(deviceId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAllDevices() {
        return ResponseEntity.ok(deviceService.getAllDevices());
    }
}
