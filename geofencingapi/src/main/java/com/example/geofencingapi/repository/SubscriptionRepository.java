package com.example.geofencingapi.repository;

import com.example.geofencingapi.model.Subscription;
import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.model.Zone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    Optional<Subscription> findByDeviceAndZone(Device device, Zone zone);
    List<Subscription> findByDevice(Device device);
    List<Subscription> findByZone(Zone zone);
}
