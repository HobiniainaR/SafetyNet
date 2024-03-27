package com.hobiniaina.safetynet.repository;

import com.hobiniaina.safetynet.model.Person;
import com.hobiniaina.safetynet.model.SafetyData;


import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.stream.Collectors;

import java.util.List;

@Repository
public class  CommunityEmailRepository {

        SafetyData safetyData = SafetyData.readFromJsonFile("C:\\Users\\rabho\\Documents\\Openclassrooms\\safetynet\\src\\main\\resources\\data.json");
        List<Person> persons=safetyData.getPersons();

        public CommunityEmailRepository() throws IOException {
            this.safetyData=safetyData;
        }

        public List<String> getEmailsByCity(String city) {
            return persons.stream()
                    .filter(person -> person.getCity().equalsIgnoreCase(city))
                    .map(Person::getEmail)
                    .collect(Collectors.toList());
        }
    }