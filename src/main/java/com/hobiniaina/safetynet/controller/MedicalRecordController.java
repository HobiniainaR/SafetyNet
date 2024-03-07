package com.hobiniaina.safetynet.controller;

import com.hobiniaina.safetynet.model.medicalRecord;
import com.hobiniaina.safetynet.service.MedicalRecordService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medicalRecord")
public class MedicalRecordController {

    private final MedicalRecordService medicalRecordService;

    public MedicalRecordController(MedicalRecordService medicalRecordService){
        this.medicalRecordService=medicalRecordService;
    }
    @GetMapping
    public ResponseEntity<List<medicalRecord>>getAllmedicalRecords(){
        List<medicalRecord>medicalrecords=medicalRecordService.getAllmedicalRecords();
        return new ResponseEntity<>(medicalrecords, HttpStatus.OK);
    }
    @GetMapping("/firstName/lastName")
    public ResponseEntity<medicalRecord>getmedicalRecordByFirstNameAndLastName(
            @PathVariable String firstName,@PathVariable String lastName){
        Optional<medicalRecord> medicalrecord = medicalRecordService.getmedicalRecordByFirstNameAndLastName(firstName, lastName);
        return medicalrecord.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping
    public ResponseEntity<Void>addmedicalRecord(@RequestBody medicalRecord medicalrecord ){
        medicalRecordService.addmedicalRecord(medicalrecord);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{firstName}/{lastName}")
    public ResponseEntity<Void>updatemedicalRecord(
            @PathVariable String firstName,@PathVariable String lastName,
            @RequestBody medicalRecord updatedmedicalRecord){
        return new ResponseEntity<>(HttpStatus.OK);

    }
    @DeleteMapping("/{firstName}/{lastName}")
    public  ResponseEntity<Void>deletemedicalRecord(
            @PathVariable String firstName,@PathVariable String lastName ){
        medicalRecordService.deletemedicalRecord(firstName,lastName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
