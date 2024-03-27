package com.hobiniaina.safetynet.Repository;


import com.hobiniaina.safetynet.model.Person;
import com.hobiniaina.safetynet.repository.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class PersonRepositoryTest {
    private PersonRepository personRepository;

    @BeforeEach
   public void setUp() throws IOException {
        personRepository = new PersonRepository();
    }

    @Test
   public void testFindByFirstNameAndLastName() {

        Person person = new Person();
        person.setFirstName("James");
        person.setLastName("Brown");
        personRepository.save(person);


        Optional<Person> foundPerson = personRepository.findByFirstNameAndLastName("James", "Brown");

        assertTrue(foundPerson.isPresent());
        assertEquals("James", foundPerson.get().getFirstName());
        assertEquals("Brown", foundPerson.get().getLastName());
    }

    @Test
   public  void testSave() {

        Person person = new Person();
        person.setFirstName("Alicia");
        person.setLastName("Keys");

        personRepository.save(person);

        assertTrue(personRepository.getAllPersons().contains(person));
    }

    @Test
   public void testUpdate() {

        Person existingPerson = new Person();
        existingPerson.setFirstName("Dwayne");
        existingPerson.setLastName("Johnson");
        personRepository.save(existingPerson);

        Person updatedPerson = new Person();
        updatedPerson.setAddress("123 Manchester St");
        updatedPerson.setCity("Culver");
        updatedPerson.setZip("97451");
        updatedPerson.setPhone("841-123-4567");
        updatedPerson.setEmail("dwayne@email.com");


        personRepository.update("Dwayne", "Johnson", updatedPerson);


        Person retrievedPerson = personRepository.findByFirstNameAndLastName("Dwayne", "Johnson").orElse(null);
        assertNotNull(retrievedPerson);
        assertEquals("123 Manchester St", retrievedPerson.getAddress());
        assertEquals("Culver", retrievedPerson.getCity());
        assertEquals("97451", retrievedPerson.getZip());
        assertEquals("841-123-4567", retrievedPerson.getPhone());
        assertEquals("dwayne@email.com", retrievedPerson.getEmail());
    }

    @Test
   public void testDeletePerson() {

        Person personToDelete = new Person();
        personToDelete.setFirstName("Robert");
        personToDelete.setLastName("Clay");
        personRepository.save(personToDelete);

        personRepository.deletePerson("Robert", "Clay");

        assertFalse(personRepository.getAllPersons().contains(personToDelete));
    }
    @Test
    public void testGetPhoneNumbersByAddress() {
        String address = "1509 Culver St";

        List<String> phoneNumbers = personRepository.getPhoneNumbersByAddress(address);

        assertNotNull(phoneNumbers);

    }
}


