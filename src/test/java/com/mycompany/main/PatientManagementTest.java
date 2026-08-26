package com.mycompany.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PatientManagementTest {
    
    PatientManagement pm = new PatientManagement();

    
    @Test
    public void testPatientRegistration(){
        
        Patient patient = new Patient("P001", "Siya", "Ndhlovu", 25, "Male", "Flu", PatientCategory.Outpatient);
        pm.patients.add(patient);
        
        assertEquals("P001", pm.patients.get(0).getID()); 
        
    }
    
    @Test
    public void testSearchPatient(){
        
        Patient patient = new Patient("P002", "Zandile", "Zulu", 25, "Female", "Cold", PatientCategory.Inpatient);
        pm.patients.add(patient);

        // Search by ID
        Patient found = pm.searchPatients("P002");
        assertEquals("P002", found.getID());

    }
    
    @Test
    void testUpdatePatientDetails() {
        
        Patient patient = new Patient("P003", "Thato", "Zwane", 25, "Male", "Asthma", PatientCategory.Outpatient);
        pm.patients.add(patient);

        boolean updated = pm.updatePatient("P003", "Thato", "Zwane", 26, "Male", "Asthma", PatientCategory.Inpatient);
        assertTrue(updated);

        Patient updatedPatient = pm.searchPatients("P003");
        assertEquals(26, updatedPatient.getAge());
        assertEquals(PatientCategory.Inpatient, updatedPatient.getPatCategory());
    }
    
    @Test
    void testDeletePatient() {
        
        Patient patient = new Patient("P004", "Wes", "Ndlovu", 20, "Male", "Injury", PatientCategory.Emergency);
        pm.patients.add(patient);

        boolean deleted = pm.deletePatient("P004");
        assertTrue(deleted);
        assertNull(pm.searchPatients("P004"));
    }
    
    
    
}
