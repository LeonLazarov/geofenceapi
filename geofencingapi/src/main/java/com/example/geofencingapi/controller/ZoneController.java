package com.example.geofencingapi.controller;

import com.example.geofencingapi.model.Zone;
import com.example.geofencingapi.service.ZoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zones")
@RequiredArgsConstructor
public class ZoneController {

    private final ZoneService zoneService;

    @PostMapping
    public Zone createZone(@RequestBody Zone zone) {
        return zoneService.createZone(zone);
    }

    @GetMapping
    public List<Zone> getAllZones() {
        return zoneService.getAllZones();
    }

    @GetMapping("/{id}")
    public Zone getZone(@PathVariable Long id) {
        return zoneService.getZoneById(id).orElseThrow();
    }

    @PatchMapping("/{id}")
    public Zone updateZone(@PathVariable Long id, @RequestBody Zone zone) {
        return zoneService.updateZone(id, zone);
    }

    @DeleteMapping("/{id}")
    public void deleteZone(@PathVariable Long id) {
        zoneService.deleteZone(id);
    }
}
