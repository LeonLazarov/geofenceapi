package com.example.geofencingapi.service;

import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.model.Subscription;
import com.example.geofencingapi.model.Zone;

import com.example.geofencingapi.repository.SubscriptionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;

    public Subscription subscribe(Device device, Zone zone) {
        return subscriptionRepository.save(
                Subscription.builder().device(device).zone(zone).build()
        );
    }

    public void unsubscribe(Long id) {
        subscriptionRepository.deleteById(id);
    }

    public List<Subscription> getSubscriptionsForDevice(Device device) {
        return subscriptionRepository.findByDevice(device);
    }

    public List<Subscription> getSubscriptionsForZone(Zone zone) {
        return subscriptionRepository.findByZone(zone);
    }
}
