package com.hobiniaina.safetynet.controller;


import com.hobiniaina.safetynet.model.Person;
import com.hobiniaina.safetynet.service.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonService personService;


    public PersonController(PersonService personService) {

        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> persons = personService.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/firstName/lastName")
    public ResponseEntity<Person> getPersonByFirstNameAndLastName(
            @PathVariable String firstName, @PathVariable String lastName) {
        Optional<Person> person = personService.getPersonByFirstNameAndLastName(firstName, lastName);
        return person.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Void> addPerson(@RequestBody Person person) {
        personService.addPerson(person);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{firstName}/{lastName}")
    public ResponseEntity<Void> updatePerson(
            @PathVariable String firstName, @PathVariable String lastName, @RequestBody Person updatedPerson) {
        personService.update(firstName, lastName, updatedPerson);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{firstName}/{lastName}")
    public ResponseEntity<Void> deletePerson(
            @PathVariable String firstName, @PathVariable String lastName) {
        personService.deletePerson(firstName, lastName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


