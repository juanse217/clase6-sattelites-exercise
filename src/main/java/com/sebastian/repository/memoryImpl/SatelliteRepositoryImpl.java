package com.sebastian.repository.memoryImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.sebastian.model.Satellite;
import com.sebastian.repository.ISatelliteRepository;
import com.sebastian.sharedExceptions.NullSatelliteException;
import com.sebastian.sharedExceptions.SatelliteNotFoundException;

public class SatelliteRepositoryImpl implements ISatelliteRepository {
    Map<String, Satellite> satellites;

    public SatelliteRepositoryImpl(){
        satellites = new HashMap<>();
    }

    @Override
    public void addSatellite(Satellite sat) {
        if(sat == null){
            throw new NullSatelliteException("The satellite you're trying to add is null");
        }
        satellites.put(sat.getId(), sat);
    }

    @Override
    public Satellite getSatelliteById(String id) throws SatelliteNotFoundException{
        Optional<Satellite> foundSatellite = satellites.values().stream().filter(x -> x.getId().equals(id)).findFirst();

        return foundSatellite.orElseThrow(() -> new SatelliteNotFoundException("The satellite with the id " + id + " wasn't found"));
    }

    @Override
    public Map<String, Satellite> getAllSatellites() {
        return satellites;
    } 
}
