package com.sebastian;

import com.sebastian.app.Menu;
import com.sebastian.repository.ISatelliteRepository;
import com.sebastian.repository.memoryImpl.SatelliteRepositoryImpl;
import com.sebastian.service.SatelliteService;

public class Main {
    public static void main(String[] args) {
        ISatelliteRepository repo = new SatelliteRepositoryImpl();
        SatelliteService service = new SatelliteService(repo);
        Menu menu = new Menu(service);
        menu.showMenu();
    }
}