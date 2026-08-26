package com.mycompany.main;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BedManagementTest {
    
    BedManagement bm = new BedManagement();
    
    @Test
    void testAllocateBed() {
        
        Patient inpatient = new Patient("P005", "Siya", "Ndlovu", 25, "Male", "Surgery", PatientCategory.Inpatient);
        boolean allocated = bm.allocateBed(inpatient);

        assertTrue(allocated);
        assertEquals(1, bm.getOccupiedCount());
    }
    
    @Test
    void testReleaseBed() {
        
        Patient inpatient = new Patient("P006", "Wes", "Khumalo", 20, "Male", "Operation", PatientCategory.Inpatient);
        bm.allocateBed(inpatient);

        boolean released = bm.releaseBed("P006");
        assertTrue(released);
        assertEquals(0, bm.getOccupiedCount());
    }
    
     @Test
    void testPreventAllocatingOccupiedBed() {
        Patient inpatient1 = new Patient("P007", "Thato", "Phiri", 24, "Male", "Checkup", PatientCategory.Inpatient);
        bm.allocateBed(inpatient1);

        // Try to allocate the same patient again
        boolean allocatedAgain = bm.allocateBed(inpatient1);

        assertEquals(1, bm.getOccupiedCount());
        assertFalse(allocatedAgain);
    }
    
    @Test
    void testPreventAllocationWhenAllBedsOccupied(){
        // Fill all 20 beds
        for (int i = 0; i < 20; i++) {
            Patient inpatient = new Patient("P020" + (100 + i), "Naledi" + i, "Sonto" + i, 30, "Female", "Epilepsy", PatientCategory.Inpatient);
            bm.allocateBed(inpatient);
        }
        
           // Attempt to allocate another inpatient
        Patient extraPatient = new Patient("P021", "Extra", "Patient", 45, "Female", "Condition", PatientCategory.Inpatient);
        boolean allocated = bm.allocateBed(extraPatient);

        assertFalse(allocated);
        assertEquals(20, bm.getOccupiedCount());
    }
    


}
