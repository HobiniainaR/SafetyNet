package com.hobiniaina.safetynet.repository;


import com.hobiniaina.safetynet.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
 public class PersonRepository {
        private final List<Person> persons = new ArrayList<>();

        public Optional<Person> findByFirstNameAndLastName(String firstName, String lastName) {
            return persons.stream()
                    .filter(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                    .findFirst();
        }

        public void save(Person person) {
            persons.add(person);
        }

        public void update(String firstName, String lastName, Person updatedPerson) {
            persons.stream()
                    .filter(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                    .findFirst()
                    .ifPresent(existingPerson -> {
                        existingPerson.setAddress(updatedPerson.getAddress());
                        existingPerson.setCity(updatedPerson.getCity());
                        existingPerson.setZip(updatedPerson.getZip());
                        existingPerson.setPhone(updatedPerson.getPhone());
                        existingPerson.setEmail(updatedPerson.getEmail());
                    });
        }

        public void deletePerson(String firstName, String lastName) {
            persons.removeIf(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName));
        }

        public List<Person> getAllPersons() {

            return new ArrayList<>(persons);
        }
    }


