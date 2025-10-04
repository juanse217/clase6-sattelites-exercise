package com.sebastian;

import com.sebastian.app.Menu;
import com.sebastian.repository.ISatelliteRepository;
import com.sebastian.repository.memoryImpl.SatelliteRepositoryImpl;
import com.sebastian.service.SatelliteService;
import com.sebastian.sharedExceptions.NullSatelliteException;
import com.sebastian.sharedExceptions.SatelliteNotFoundException;

public class Main {
    public static void main(String[] args) {
        ISatelliteRepository repo = new SatelliteRepositoryImpl();
        SatelliteService service = new SatelliteService(repo);
        Menu menu = new Menu(service);
        try{
            menu.showMenu();
        }catch(SatelliteNotFoundException e){
            System.out.println("The specified id isn't in our database, try again");
            Main.main(args);
        }catch(NullSatelliteException e){
            System.out.println("The satellite is in an incorrect state");
        }
        
    }
}