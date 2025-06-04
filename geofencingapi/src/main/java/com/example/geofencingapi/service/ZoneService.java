package com.example.geofencingapi.service;

import com.example.geofencingapi.model.Zone;
import com.example.geofencingapi.repository.ZoneRepository;
import com.example.geofencingapi.dto.ZoneUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Zone updateZonePartial(Long id, ZoneUpdateRequest updateRequest) {
        Zone zone = zoneRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Zone not found"));

        if (updateRequest.getName() != null) {
            zone.setName(updateRequest.getName());
        }

        if (updateRequest.getCoordinates() != null) {
            // Convert List<List<Double>> to List<String> — e.g., "41.123,20.456"
            List<String> formattedCoordinates = updateRequest.getCoordinates().stream()
                    .map(pair -> pair.get(0) + "," + pair.get(1))
                    .toList();

            zone.setCoordinates(formattedCoordinates);
        }

        return zoneRepository.save(zone);
    }

    public void deleteZone(Long id) {
        zoneRepository.deleteById(id);
    }
}
