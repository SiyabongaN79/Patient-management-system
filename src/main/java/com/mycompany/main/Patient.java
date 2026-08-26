package com.mycompany.main;

public class Patient {
    
    //Creating the objects' attributes
    
    private String patientID;
    private String firstName;
    private String lastName;
    private int age;
    private String gender;
    private String medicalCondition;
    private PatientCategory patientCategory;
    
    //A constructor to initialize the attributes
    
    Patient(){
        
       patientID = "xxxxxxxxx"; 
       firstName = "xxxxxxxxx";
       lastName = "xxxxxxxx";
       age = 1;
       gender = "xxxx";
       medicalCondition = "xxxxxxxx";
    }
    
    //Overloading the Patient constructor to receive arguements for the patients' attributes
    
    Patient(String id, String name, String surname, int age, String gender, 
            String medCondition, PatientCategory patCategory){
        
            this.patientID = id;
            this.firstName = name;
            this.lastName = surname;
            this.age = age;
            this.gender = gender;
            this.medicalCondition = medCondition;
            this.patientCategory = patCategory;
    }
    
    //Setting up mutators and accessor methods for the patient object
    
    public void setID(String id){
        
        this.patientID = id;
    }
    
    public void setName(String name){
       
        this.firstName = name; 
    }
    
    public void setSurname(String surname){
        
        this.lastName = surname;
    }
    
    public void setAge(int age){
        
        this.age = age;
    }
    
    public void setGender(String gender){
        
        this.gender = gender;
    }
    
    public void setMedCondition(String medCondition){
        
        this.medicalCondition = medCondition;
    }
    
    public void setPatCategory(PatientCategory patCategory){
        
        this.patientCategory = patCategory;
    }
    
    public String getDetails(){
        
        return "Patient ID: " + patientID + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nGender: " + gender + "\nMedical Condition: " + medicalCondition + "\nPatient Category: " + patientCategory ;
    }
    
    public int getAge(){
        
        return age;
    }
    
    public String getID(){
        
        return patientID;
    }
    
    public PatientCategory getPatCategory(){
        
        return patientCategory; 
    }
    

    
}
