package com.hobiniaina.safetynet.service;

import com.hobiniaina.safetynet.repository.FirestationRepository;
import com.hobiniaina.safetynet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneAlertService {

    private final FirestationRepository firestationRepository;
    private final PersonRepository personRepository;

    @Autowired
    public PhoneAlertService(FirestationRepository firestationRepository, PersonRepository personRepository) {
        this.firestationRepository = firestationRepository;
        this.personRepository = personRepository;
    }

    public List<String> getAddressesOfFirestation(Integer station) {

        return firestationRepository.getAddressesByFirestation(station);
    }

    public List<String> getPhoneNumbersByAddress(String address) {

        return personRepository.getPhoneNumbersByAddress(address);
    }

    public List<String> getPhoneNumbersByFirestation(Integer station) {
        return getAddressesOfFirestation(station)
                .stream()
                .flatMap(address -> getPhoneNumbersByAddress(address).stream())
                .collect(Collectors.toList());
    }
}
