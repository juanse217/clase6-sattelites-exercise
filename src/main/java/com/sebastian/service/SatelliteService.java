package com.sebastian.service;

import java.util.List;

import com.sebastian.enums.SatelliteStatus;
import com.sebastian.model.Satellite;
import com.sebastian.repository.ISatelliteRepository;

public class SatelliteService {
     //TODO: loggers for methods
    private ISatelliteRepository repo; 

    public SatelliteService(ISatelliteRepository repository){
        this.repo = repository;
    }

    public void addSatellite(Satellite sat){
        repo.addSatellite(sat);
    }

    public String consultStatus(String id){
        Satellite sat = repo.getSatelliteById(id);
        return sat.getCurrentStatus().toString();
    }

    public void addMeasurements(String id, double radiation){
        Satellite sat = repo.getSatelliteById(id);
        sat.addRadiationMeasurement(radiation);
    }

    public List<Double> getAllmeasurements(String id){
        Satellite sat = repo.getSatelliteById(id);
        return sat.getRadiationHistory();
    }

    public void changeStatus(String id, String status){
        Satellite sat = repo.getSatelliteById(id);
        SatelliteStatus changedStatus = status.equalsIgnoreCase("Active") ? SatelliteStatus.ACTIVE : status.equalsIgnoreCase("Inactive") ? SatelliteStatus.INACTIVE : SatelliteStatus.MAINTENANCE;
        sat.setCurrentStatus(changedStatus);
    }

}
