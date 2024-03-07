package com.hobiniaina.safetynet.controller;


import com.hobiniaina.safetynet.model.Firestation;
import com.hobiniaina.safetynet.service.FirestationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/firestation")
public class FirestationController {

    private final FirestationService firestationService;

    public FirestationController(FirestationService firestationService){

           this.firestationService=firestationService;
    }
    @GetMapping
    public ResponseEntity<List<Firestation>> getAllFirestation() {
        List<Firestation> firestations = firestationService.getAllFirestations();
        return new ResponseEntity<>(firestations, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<String> addFirestation (@RequestBody Firestation firestation){
        firestationService.addFirestation(firestation);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<String> updateFirestation(@RequestBody Firestation firestation){
        firestationService.updateFirestation(firestation);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{station}/{address}")
    public ResponseEntity<String> deleteFirestation(@PathVariable Integer station,@PathVariable String address){
        firestationService.deleteFirestation(station,address);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}




