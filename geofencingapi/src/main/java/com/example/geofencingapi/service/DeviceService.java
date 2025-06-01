package com.example.geofencingapi.service;

import com.example.geofencingapi.model.Device;
import com.example.geofencingapi.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device registerDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Optional<Device> getDeviceById(String id) {
        return deviceRepository.findById(id);
    }

    public Device updateLocation(String id, Double lat, Double lng) {
        Device device = deviceRepository.findById(id).orElseThrow();
        device.setLastLatitude(lat);
        device.setLastLongitude(lng);
        return deviceRepository.save(device);
    }

    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }
}
