package com.hobiniaina.safetynet.controller;


import com.hobiniaina.safetynet.service.PersonService;
import com.hobiniaina.safetynet.service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RestController
public class PhoneAlertController {

    private final FirestationService firestationService;
    private final PersonService personService;

    @Autowired
    public PhoneAlertController(FirestationService firestationService, PersonService personService) {
        this.firestationService = firestationService;
        this.personService = personService;
    }

    @GetMapping("/phoneAlert")
    public ResponseEntity<List<String>> getPhoneNumbersByFirestation(@RequestParam(value = "firestation") Integer station) {
        List<String> stationAddresses = this.firestationService.getAddressesOfFirestation(station);

        List<String> phoneNumbers = this.personService.getPersons().stream()
                .filter(person -> stationAddresses.stream().anyMatch(address -> Objects.equals(person.getAddress(), address)))
                .map(person -> person.getPhone())
                .collect(Collectors.toList());

        return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
    }

}





