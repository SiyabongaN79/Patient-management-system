package com.mycompany.main;
import java.util.*;

public class BedManagement {
    private final int rows = 4;
    private final int cols = 5;
    private Patient[][] beds;
//commit
    public BedManagement() {
        beds = new Patient[rows][cols];
    }

    // Allocate a bed to an inpatient
    public boolean allocateBed(Patient patient){
        if (patient.getPatCategory() != PatientCategory.Inpatient) {
            System.out.println("Only inpatients can be allocated a bed.");
            return false;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (beds[i][j] == null){
                    beds[i][j] = patient;
                    System.out.println("Bed allocated at position (" + i + "," + j + ") to patient " + patient.getID());
                    return true;
                }
            }
            
            System.out.println();
        }
        System.out.println("No beds available for allocation.");
        return false;
    }

    // Release a bed when patient is discharged
    public boolean releaseBed(String patientId) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (beds[i][j] != null && beds[i][j].getID().equals(patientId)) {
                    beds[i][j] = null;
                    System.out.println("Bed at (" + i + "," + j + ") released for patient " + patientId);
                    return true;
                }
            }
        }
        System.out.println("Patient with ID " + patientId + " not found in any bed.");
        return false;
    }

    // Display ward layout
    public void displayWardLayout() {
        System.out.println("Ward Layout (X = occupied, O = available):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (beds[i][j] == null) {
                    System.out.print("O ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    // Display available beds
    public void displayAvailableBeds() {
        System.out.println("Available beds:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (beds[i][j] == null) {
                    System.out.println("Bed at (" + i + "," + j + ")");
                }
            }
            System.out.println();
        }
    }

    // Display occupied beds
    public void displayOccupiedBeds() {
        System.out.println("Occupied beds:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (beds[i][j] != null) {
                    System.out.println("Bed at (" + i + "," + j + ") occupied by patient " + beds[i][j].getID());
                }
            }
            System.out.println();
        }
    }
    
    public int getOccupiedCount(){
        int count = 0;
            for(int i=0; i<rows; i++) {
                for(int j=0; j<cols; j++) {
                    if(beds[i][j] != null) count++;
                }
            }
        return count;
    }

    public double getOccupancyPercentage(){
        int occupied = getOccupiedCount();
        int totalBeds = rows * cols;
        return ((double) occupied / totalBeds) * 100;
    }

}
