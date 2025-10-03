package com.sebastian.app;

import java.util.Scanner;

import com.sebastian.model.Satellite;
import com.sebastian.service.SatelliteService;

public class Menu {
    private SatelliteService service; 

    public Menu(SatelliteService service){
        this.service = service;
    }
    public  void showMenu(){
        int decision = 0; 
        Scanner sc = new Scanner(System.in);
        String id = null;

        do{
            System.out.println("-----Showing menu-----\n1. Register satellite\n2. Check satellite status\n3. Add cosmic radiation measurements\n4. Check cosmic radiation history\n5. Change satellite status\n6. Exit\nEnter your option: ");
            decision = Integer.parseInt(sc.nextLine());

            switch (decision) {
                case 1:
                    service.addSatellite(new Satellite());
                    System.out.println("Satellite added");
                    break;
                case 2:
                    System.out.println("Enter the id (SAT-00X): ");
                    id = sc.nextLine(); 
                    System.out.println("The status for the satellite " + id + " is " + service.consultStatus(id));
                    break;
                case 3:
                    System.out.println("Enter de the id (SAT-00X): ");
                    id = sc.nextLine(); 
                    System.out.println("Enter the value of the radiation: ");
                    double rad = Double.parseDouble(sc.nextLine());
                    service.addMeasurements(id, rad);
                    System.out.println("Measurement added");
                    break;
                case 4:
                    System.out.println("Enter de the id (SAT-00X): ");
                    id = sc.nextLine(); 
                    System.out.println("The history for the satellite with id " + id + " is " +service.getAllmeasurements(id));
                    break;
                case 5:
                    System.out.println("Enter de the id (SAT-00X): ");
                    id = sc.nextLine();
                    System.out.println("Give me the status (\"Active, Inactive or Maintenance\")");
                    String status = sc.nextLine();
                    service.changeStatus(id, status);
                    System.out.println("Status changed to " + status);
                default:
                    break;
            }

            id = null;
            
        }while(decision < 6);

        sc.close();

    }
}
