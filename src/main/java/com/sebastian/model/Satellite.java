package com.sebastian.model;

import java.util.LinkedList;
import java.util.List;

import com.sebastian.enums.SatelliteStatus;

public class Satellite {
    private static int satelliteNum = 1;
    private String id = "SAT-00";
    private SatelliteStatus currentStatus;  
    private List<Double> radiationHistory;

    public Satellite(){
        id = id+(satelliteNum++);
        currentStatus = SatelliteStatus.ACTIVE;
        radiationHistory = new LinkedList<>(); 
    }

    public String getId() {
        return id;
    }


    public SatelliteStatus getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(SatelliteStatus currentStatus) {
        this.currentStatus = currentStatus;
    }

    public List<Double> getRadiationHistory() {
        return radiationHistory;
    }

    /**
     * Metodo para agregar radiation history. 
     * @param rad la radiacion que se va a agregar. 
     */
    public void addRadiationMeasurement(double rad){
        radiationHistory.add(rad);
    }

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Satellite other = (Satellite) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Satellite [id=" + id + ", currentStatus=" + currentStatus + ", radiationHistory=" + radiationHistory
                + "]";
    }

    
}
