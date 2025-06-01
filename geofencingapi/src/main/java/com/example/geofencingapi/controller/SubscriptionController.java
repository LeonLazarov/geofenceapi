package com.example.geofencingapi.controller;

import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.model.Subscription;
import com.example.geofencingapi.model.Zone;
import com.example.geofencingapi.service.DeviceService;
import com.example.geofencingapi.service.SubscriptionService;
import com.example.geofencingapi.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/subscriptions") // ✅ More descriptive and namespaced
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionService subscriptionService;
    private final DeviceService deviceService;
    private final ZoneService zoneService;

    // Subscribe a device to a zone
    @PostMapping
    public Subscription subscribe(
            @RequestParam String deviceId,
            @RequestParam Long zoneId
    ) {
        Device device = deviceService.getDeviceById(deviceId).orElseThrow();
        Zone zone = zoneService.getZoneById(zoneId).orElseThrow();
        return subscriptionService.subscribe(device, zone);
    }

    // Unsubscribe a device from a zone
    @DeleteMapping("/{subscriptionId}")
    public void unsubscribe(@PathVariable Long subscriptionId) {
        subscriptionService.unsubscribe(subscriptionId);
    }
}
