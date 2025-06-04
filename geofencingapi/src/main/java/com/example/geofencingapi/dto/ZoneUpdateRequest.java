package com.example.geofencingapi.dto;

import java.util.List;

public class ZoneUpdateRequest {
    private String name;
    private List<List<Double>> coordinates;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<List<Double>> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(List<List<Double>> coordinates) {
        this.coordinates = coordinates;
    }
}
