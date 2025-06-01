package com.example.geofencingapi.repository;

import com.example.geofencingapi.model.EventLog;
import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {
    List<EventLog> findByDevice(Device device);
    List<EventLog> findByZone(Zone zone);
}
