package com.hobiniaina.safetynet.repository;
import com.hobiniaina.safetynet.model.SafetyData;
import com.hobiniaina.safetynet.model.medicalRecord;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository

public class MedicalRecordRepository {

    SafetyData safetyData = SafetyData.readFromJsonFile("C:\\Users\\rabho\\Documents\\Openclassrooms\\safetynet\\src\\main\\resources\\data.json");
    List<medicalRecord> medicalrecords=safetyData.getMedicalrecords();
    public MedicalRecordRepository ()throws IOException{
        this.safetyData= safetyData;
    }
    public Optional<medicalRecord> findByFirstNameAndLastName(String firstName, String lastName) {
        return medicalrecords.stream()
                .filter(medicalrecord -> medicalrecord.getFirstName().equals(firstName) && medicalrecord.getLastName().equals(lastName))
                .findFirst();
    }
    public void save (medicalRecord medicalrecord){
        medicalrecords.add(medicalrecord);
    }
    public void updatemedicalRecord(String firstName, String lastName, medicalRecord updatedMedicalRecord) {
        medicalrecords.stream()
                .filter(medicalrecord -> medicalrecord.getFirstName().equals(firstName) && medicalrecord.getLastName().equals(lastName))
                .findFirst()
                .ifPresent(existingRecord -> {
                    existingRecord.setBirthdate(updatedMedicalRecord.getBirthdate());
                    existingRecord.setMedications(updatedMedicalRecord.getMedications());
                    existingRecord.setAllergies(updatedMedicalRecord.getAllergies());
                });
    }

    public void deletemedicalRecord(String firstName, String lastName) {
        medicalrecords.removeIf(record -> record.getFirstName().equals(firstName) && record.getLastName().equals(lastName));
    }
    public List<medicalRecord> getAllmedicalRecords() {

        return new ArrayList<>(medicalrecords);
    }
}

