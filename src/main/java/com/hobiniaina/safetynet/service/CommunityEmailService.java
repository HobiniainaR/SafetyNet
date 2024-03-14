package com.hobiniaina.safetynet.service;

import com.hobiniaina.safetynet.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityEmailService {
    private final PersonRepository personRepository;

    @Autowired
    public CommunityEmailService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public List<String> getEmailsByCity(String city) {
        return personRepository.getEmailsByCity(city);
    }
}
