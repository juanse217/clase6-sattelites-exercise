package com.sebastian.enums;

public enum SatelliteStatus {
    ACTIVE("Active"), MAINTENANCE("Maintenance"), INACTIVE("Inactive");

    private String status; 

    private SatelliteStatus(String statusStr){
        this.status = statusStr;
    }

    @Override
    public String toString() {
        return status; 
    }
}
