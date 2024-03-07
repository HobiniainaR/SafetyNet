package com.hobiniaina.safetynet.service;

import com.hobiniaina.safetynet.model.medicalRecord;
import com.hobiniaina.safetynet.repository.MedicalRecordRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Data
public class MedicalRecordService {
    private final MedicalRecordRepository medicalRecordRepository;


    public MedicalRecordService(MedicalRecordRepository medicalRecordRepository)  {
        this.medicalRecordRepository = medicalRecordRepository;
    }

    public List<medicalRecord> getAllmedicalRecords() {
        return medicalRecordRepository.getAllmedicalRecords();
    }

    public Optional<medicalRecord> getmedicalRecordByFirstNameAndLastName(String firstName, String lastName) {
        return medicalRecordRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public void addmedicalRecord(medicalRecord medicalrecord) {
        medicalRecordRepository.save(medicalrecord);
    }

    public void updatemedicalRecord(String firstName, String lastName, medicalRecord updatedMedicalRecord) {
        medicalRecordRepository.updatemedicalRecord(firstName, lastName, updatedMedicalRecord);
    }

    public void deletemedicalRecord(String firstName, String lastName) {
        medicalRecordRepository.deletemedicalRecord(firstName, lastName);
    }
}
