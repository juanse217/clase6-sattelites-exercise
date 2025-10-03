package com.sebastian.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sebastian.enums.SatelliteStatus;
import com.sebastian.model.Satellite;
import com.sebastian.repository.ISatelliteRepository;

public class SatelliteService {
    private ISatelliteRepository repo; 
    private static final Logger logger = LoggerFactory.getLogger(SatelliteService.class);

    public SatelliteService(ISatelliteRepository repository){
        logger.info("Instanciating service class");
        this.repo = repository;
    }

    public void addSatellite(Satellite sat){
        logger.info("Adding new satellite");
        repo.addSatellite(sat);
        logger.info("Satellite succesfullyy added");
    }

    public String consultStatus(String id){
        logger.info("Checking status");
        Satellite sat = repo.getSatelliteById(id);
        return sat.getCurrentStatus().toString();
    }

    public void addMeasurements(String id, double radiation){
        logger.info("Adding measurements for satellite {}", id);
        Satellite sat = repo.getSatelliteById(id);
        sat.addRadiationMeasurement(radiation);
    }

    public List<Double> getAllmeasurements(String id){
        logger.info("Returning measurements for satellite {}", id);
        Satellite sat = repo.getSatelliteById(id);
        return sat.getRadiationHistory();
    }

    public void changeStatus(String id, String status){
        logger.info("Changing status for satellite {}", id);
        Satellite sat = repo.getSatelliteById(id);
        SatelliteStatus changedStatus = status.equalsIgnoreCase("Active") ? SatelliteStatus.ACTIVE : status.equalsIgnoreCase("Inactive") ? SatelliteStatus.INACTIVE : SatelliteStatus.MAINTENANCE;
        sat.setCurrentStatus(changedStatus);
    }

}
