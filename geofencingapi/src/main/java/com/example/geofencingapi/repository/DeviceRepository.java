package com.example.geofencingapi.repository;

import com.example.geofencingapi.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<Device, String> {
}
