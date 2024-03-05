package com.hobiniaina.safetynet.service;

import com.hobiniaina.safetynet.model.Person;
import com.hobiniaina.safetynet.repository.PersonRepository;
import lombok.Data;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Data
@Service
public class PersonService {
    private PersonRepository personRepository;

    public PersonService( PersonRepository personRepository){

        this.personRepository=personRepository;
    }


    public List<Person> getAllPersons() {

        return personRepository.getAllPersons();
    }

    public Optional<Person> getPersonByFirstNameAndLastName(String firstName, String lastName) {
        return personRepository.findByFirstNameAndLastName(firstName, lastName);
    }

    public void addPerson(Person person) {

        personRepository.save(person);
    }

    public void update(String firstName, String lastName, Person updatedPerson) {
        personRepository.update(firstName, lastName, updatedPerson);
    }

    public void deletePerson(String firstName, String lastName) {
        personRepository.deletePerson(firstName, lastName);
    }

}