package com.sebastian.enums;

public enum SatelliteStatus {
    ACTIVE("Active"), MAINTENANCE("Maintenance"), INACTIVE("Inactive"), ERROR("Status error");

    private String status; 

    private SatelliteStatus(String statusStr){
        this.status = statusStr;
    }

    @Override
    public String toString() {
        return status; 
    }
}
