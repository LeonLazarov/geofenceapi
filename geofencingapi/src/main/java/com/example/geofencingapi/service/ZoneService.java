package com.example.geofencingapi.service;

import com.example.geofencingapi.model.Zone;
import com.example.geofencingapi.repository.ZoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ZoneService {

    private final ZoneRepository zoneRepository;

    public Zone createZone(Zone zone) {
        return zoneRepository.save(zone);
    }

    public List<Zone> getAllZones() {
        return zoneRepository.findAll();
    }

    public Optional<Zone> getZoneById(Long id) {
        return zoneRepository.findById(id);
    }

    public Zone updateZone(Long id, Zone updatedZone) {
        Zone zone = zoneRepository.findById(id).orElseThrow();
        zone.setName(updatedZone.getName());
        zone.setCoordinates(updatedZone.getCoordinates());
        zone.setZoneType(updatedZone.getZoneType());
        return zoneRepository.save(zone);
    }

    public void deleteZone(Long id) {
        zoneRepository.deleteById(id);
    }
}
