package com.mycompany.main;

public class Inpatient extends Patient {
    private String wardNumber;
    private String bedNumber;

    public Inpatient(String id, String name, String surname, int age, String gender,
                     String medCondition, PatientCategory patCategory,
                     String wardNumber, String bedNumber){
        
                super(id, name, surname, age, gender, medCondition, patCategory);
                this.wardNumber = wardNumber;
                this.bedNumber = bedNumber;
    }

    @Override
    public String getDetails(){
        
        return super.getDetails() +
               "\nWard Number: " + wardNumber +
               "\nBed Number: " + bedNumber;
    }
}

