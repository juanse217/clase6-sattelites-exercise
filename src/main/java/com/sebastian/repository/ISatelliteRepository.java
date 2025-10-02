package com.sebastian.repository;

import java.util.Map;

import com.sebastian.model.Satellite;

public interface ISatelliteRepository {

    void addSatellite(Satellite sat);
    Satellite getSatelliteById(String id);
    Map<String, Satellite> getAllSatellites();
}
