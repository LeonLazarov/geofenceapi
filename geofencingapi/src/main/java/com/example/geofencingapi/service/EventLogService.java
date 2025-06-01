package com.example.geofencingapi.service;

import lombok.RequiredArgsConstructor;

import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.model.EventLog;
import com.example.geofencingapi.model.Zone;
import com.example.geofencingapi.repository.EventLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventLogService {

    private final EventLogRepository eventLogRepository;

    public EventLog logEvent(Device device, Zone zone, String eventType) {
        return eventLogRepository.save(
                EventLog.builder()
                        .device(device)
                        .zone(zone)
                        .eventType(eventType)
                        .timestamp(LocalDateTime.now())
                        .build()
        );
    }

    public List<EventLog> getLogsByDevice(Device device) {
        return eventLogRepository.findByDevice(device);
    }

    public List<EventLog> getLogsByZone(Zone zone) {
        return eventLogRepository.findByZone(zone);
    }
}
