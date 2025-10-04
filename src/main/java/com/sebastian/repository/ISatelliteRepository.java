package com.sebastian.repository;

import java.util.Map;

import com.sebastian.model.Satellite;
import com.sebastian.sharedExceptions.SatelliteNotFoundException;

public interface ISatelliteRepository {

    void addSatellite(Satellite sat);
    Satellite getSatelliteById(String id) throws SatelliteNotFoundException;
    Map<String, Satellite> getAllSatellites();
}
