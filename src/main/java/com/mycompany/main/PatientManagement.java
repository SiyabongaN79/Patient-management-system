package com.mycompany.main;
import java.util.*;

public class PatientManagement {
    
    //Creating a scanner for user input and an ArrayList to store registered users
    Scanner sc = new Scanner(System.in);
    ArrayList<Patient> patients = new ArrayList<>();
    
    //A method to register a patient
    public boolean patientRegistration(){
        
        System.out.println("Enter Patient ID: ");
        String id = sc.nextLine();
        
        System.out.println("Enter Patient Name: ");
        String name = sc.nextLine();
        
        System.out.println("Enter Patient Last Name: ");
        String surname = sc.nextLine();
        
        System.out.println("Enter Patient Age: ");
        int age = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Enter Patient's gender: ");
        String gender = sc.nextLine();
        
        System.out.println("Enter Patient's condition: ");
        String condition = sc.nextLine();
        
        System.out.println("Enter Patient's category, Choose between Inpatient/Outpatient/Emergency  NB first letter should be entered in Caps");
        String categoryInput = sc.nextLine();
        
        PatientCategory patCategory;
        switch(categoryInput){
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
                 System.out.println("Invalid category entered, Patient will be stored as an outpatient");  
                 patCategory = PatientCategory.Outpatient;
        }
        
        //Storing the user input into the object patient
        Patient patient = new Patient(id,name,surname,age,gender,condition, patCategory);
        
        //Saving the patient object in an array list after receiving user input
        patients.add(patient);
        
        System.out.println("Patient has been registered successfully");
        System.out.println();
        
        return true;

    }  
    
    //Creating a method that searches a patient using the patients ID
    public Patient searchPatients(String id){
        for(Patient patient : patients){
            if(patient.getID().equals(id)){
                return patient;
            }
        }
       
       return null;
    }
    
    //Creating a method to delete a patient from the arraylist
    public boolean deletePatient(String id){
        for(Patient patient : patients){
            
            if(patient.getID().equals(id)){
                
                patients.remove(patient);
                
                System.out.println("Patient with ID: " + id + " has been removed");
                return true;
 
            }
        }
        System.out.println("Patient with ID: " + id + " was not found");
        return false;
    }
    
    //Creating a method to update Patients' details
    public boolean updatePatient(String id, String newName, String newSurname, int newAge, String newGender, String newCondition, PatientCategory newCategory) {
    Patient patient = searchPatients(id);
       if (patient != null) {
           
           patient.setName(newName);
           patient.setSurname(newSurname);
           patient.setAge(newAge);
           patient.setGender(newGender);
           patient.setMedCondition(newCondition);
           patient.setPatCategory(newCategory);
           
           System.out.println("Patient updated successfully!");
           
           return true;
        }
           System.out.println("Patient not found.");
           
           return false;
    }
    
    //Creating a method to display all patients stored in the arrayList
    public void displayPatients(){
        
        for(Patient patient : patients){
            
            System.out.println(patient.getDetails() + "\nAge: " + patient.getAge());
            System.out.println();
        }
    }
    
    public int getTotalPatients(){
        
    return patients.size();
    
    }


}
