package com.mycompany.main;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        
       PatientManagement pm = new PatientManagement();
       BedManagement bm = new BedManagement();
       Scanner sc = new Scanner(System.in);
       
       int option;
       String id;
       
       //Creating a menu for the user using a do-while loop and a switch structure
       do {
            System.out.println("----------- Main Menu -----------");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient by ID");
            System.out.println("3. Update Existing Patient's Details");
            System.out.println("4. Allocate Bed to Inpatients");
            System.out.println("5. Release Bed (Discharge Patient)");
            System.out.println("6. Reports");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1:
                    pm.patientRegistration();
                    break;

                case 2:
                    System.out.print("Enter Patient ID: ");
                    id = sc.nextLine();
                    Patient found = pm.searchPatients(id);
                    if(found != null) {
                        System.out.println(found.getDetails());
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 3:
                    System.out.println("Enter Patient's existing ID: ");
                    id = sc.nextLine();

                    System.out.println("Enter Patient's new Name: ");
                    String name = sc.nextLine();

                    System.out.println("Enter Patient's new Last Name: ");
                    String surname = sc.nextLine();

                    System.out.println("Enter Patient's new Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.println("Enter Patient's new Gender: ");
                    String gender = sc.nextLine();

                    System.out.println("Enter Patient's new Condition: ");
                    String condition = sc.nextLine();

                    System.out.println("Enter Patient's new Category (Inpatient/Outpatient/Emergency) First letter should be entered in caps:");
                    String categoryInput = sc.nextLine().toUpperCase();

                    PatientCategory patCategory;
                    switch (categoryInput) {
                        case "Inpatient":
                            patCategory = PatientCategory.Inpatient;
                            break;
                        case "Outpatient":
                            patCategory = PatientCategory.Outpatient;
                            break;
                        case "Emergency":
                            patCategory = PatientCategory.Emergency;
                            break;
                        default:
                            System.out.println("Invalid category entered, patient will be automatically declared as an outpatient");
                            patCategory = PatientCategory.Outpatient;
                    }

                    pm.updatePatient(id, name, surname, age, gender, condition, patCategory);

                case 4:
                    System.out.print("Enter Patient ID to allocate bed: ");
                    id = sc.nextLine();
                    Patient inpatient = pm.searchPatients(id);
                    if(inpatient != null) {
                        bm.allocateBed(inpatient);
                    } else {
                        System.out.println("Patient not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Patient ID to release bed: ");
                    id = sc.nextLine();
                    bm.releaseBed(id);
                    break;

                case 6:
                    int reportOption;
                    do {
                        System.out.println("------ Reports Menu ------");
                        System.out.println("1. Display all Registered Patients");
                        System.out.println("2. Display all Available Beds");
                        System.out.println("3. Display all Occupied Beds");
                        System.out.println("4. Display Total Number of Registered Patients");
                        System.out.println("5. Display Total Number of Occupied Beds");
                        System.out.println("6. Display Ward Occupancy Percentage");
                        System.out.println("7. Back to Main Menu");
                        System.out.print("Choose option: ");

                        reportOption = sc.nextInt();
                        sc.nextLine();

                        switch(reportOption) {
                            case 1:
                                pm.displayPatients();
                                break;
                            case 2:
                                bm.displayAvailableBeds();
                                break;
                            case 3:
                                bm.displayOccupiedBeds();
                                break;
                            case 4:
                                System.out.println("Total Registered Patients: " + pm.getTotalPatients());
                                break;
                            case 5:
                                System.out.println("Total Occupied Beds: " + bm.getOccupiedCount());
                                break;
                            case 6:
                                double percentage = bm.getOccupancyPercentage();
                                System.out.println("Ward Occupancy: " + percentage + "%");
                                break;
                            case 7:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid option.");
                        }
                    } 
                    while(reportOption != 7);
                    break;

                    case 7:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid option.");
                }

            }
       
            while(option != 7);
//
    }
}
