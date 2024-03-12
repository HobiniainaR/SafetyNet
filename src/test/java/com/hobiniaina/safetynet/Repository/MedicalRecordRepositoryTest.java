package com.hobiniaina.safetynet.Repository;


import static org.junit.jupiter.api.Assertions.*;

import com.hobiniaina.safetynet.model.medicalRecord;
import com.hobiniaina.safetynet.repository.MedicalRecordRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

class MedicalRecordRepositoryTest {

    private MedicalRecordRepository medicalRecordRepository;

    @BeforeEach
    void setUp() throws IOException {
        medicalRecordRepository = new MedicalRecordRepository();
    }

    @Test
    public void testFindByFirstNameAndLastName() {

        medicalRecord record = new medicalRecord();
        record.setFirstName("James");
        record.setLastName("Brown");
        medicalRecordRepository.save(record);


        Optional<medicalRecord> foundRecord = medicalRecordRepository.findByFirstNameAndLastName("James", "Brown");

        assertTrue(foundRecord.isPresent());
        assertEquals("James", foundRecord.get().getFirstName());
        assertEquals("Brown", foundRecord.get().getLastName());
    }

    @Test
    public void testSave() {

        medicalRecord record = new medicalRecord();
        record.setFirstName("Alicia");
        record.setLastName("Keys");
        medicalRecordRepository.save(record);


        List<medicalRecord> records = medicalRecordRepository.getAllmedicalRecords();
        assertTrue(records.contains(record));
    }

    @Test
    public void testUpdateMedicalRecord() {

        medicalRecord existingRecord = new medicalRecord();
        existingRecord.setFirstName("Dwayne");
        existingRecord.setLastName("Johnson");
        medicalRecordRepository.save(existingRecord);

        medicalRecord updatedRecord = new medicalRecord();
        updatedRecord.setBirthdate("01/07/1994");
        updatedRecord.setMedications( List.of( new String[]{"aznol:350mg", "hydrapermazol:100mg"}));
        updatedRecord.setAllergies(List.of(new String[]{"nillacilan"}));
        medicalRecordRepository.updatemedicalRecord("Dwayne", "Johnson", updatedRecord);


        Optional<medicalRecord> retrievedRecord = medicalRecordRepository.findByFirstNameAndLastName("Dwayne", "Johnson");
        assertTrue(retrievedRecord.isPresent());
        assertEquals(updatedRecord.getBirthdate(), retrievedRecord.get().getBirthdate());
        assertEquals(updatedRecord.getMedications(), retrievedRecord.get().getMedications());
        assertEquals(updatedRecord.getAllergies(), retrievedRecord.get().getAllergies());
    }

    @Test
    public void testDeleteMedicalRecord() {

        medicalRecord recordToDelete = new medicalRecord();
        recordToDelete.setFirstName("Robert");
        recordToDelete.setLastName("Clay");
        medicalRecordRepository.save(recordToDelete);


        medicalRecordRepository.deletemedicalRecord("Robert", "Clay");


        assertFalse(medicalRecordRepository.getAllmedicalRecords().contains(recordToDelete));
    }
}
