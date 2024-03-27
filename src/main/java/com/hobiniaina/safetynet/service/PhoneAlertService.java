package com.hobiniaina.safetynet.service;

import com.hobiniaina.safetynet.repository.FirestationRepository;
import com.hobiniaina.safetynet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PhoneAlertService {

    private final FirestationRepository firestationRepository;
    private final PersonRepository personRepository;
    private final FirestationService firestationService;
    private final PersonService personService;


    @Autowired
    public PhoneAlertService(FirestationRepository firestationRepository, PersonRepository personRepository, FirestationService firestationService, PersonService personService) {
        this.firestationRepository = firestationRepository;
        this.personRepository = personRepository;
        this.firestationService = firestationService;
        this.personService = personService;
    }

    public List<String> getAddressesOfFirestation(Integer station) {

        return firestationRepository.getAddressesByFirestation(station);
    }

    public List<String> getPhoneNumbersByAddress(String address) {

        return personRepository.getPhoneNumbersByAddress(address);
    }

    public List<String> getPhoneNumbersByFirestation(Integer station) {
        List<String> stationAddresses = this.firestationService.getAddressesOfFirestation(station);

        List<String> phoneNumbers = this.personService.getPersons().stream()
                .filter(person -> stationAddresses.stream().anyMatch(address -> Objects.equals(person.getAddress(), address)))
                .map(person -> person.getPhone()).distinct()
                .collect(Collectors.toList());
        return phoneNumbers;

    }

}




