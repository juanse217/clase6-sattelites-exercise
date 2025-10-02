package com.sebastian.sharedExceptions;

public class SatelliteNotFoundException extends RuntimeException {
    public SatelliteNotFoundException(String msg){
        super(msg);
    }
}
