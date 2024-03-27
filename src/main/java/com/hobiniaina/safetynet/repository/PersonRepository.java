package com.hobiniaina.safetynet.repository;


import com.hobiniaina.safetynet.model.Person;
import com.hobiniaina.safetynet.model.SafetyData;
import org.springframework.stereotype.Repository;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;


@Repository
 public class PersonRepository {
    SafetyData safetyData = SafetyData.readFromJsonFile("C:\\Users\\rabho\\Documents\\Openclassrooms\\safetynet\\src\\main\\resources\\data.json");
    List<Person> persons = safetyData.getPersons();

    public PersonRepository() throws IOException {
        this.safetyData = safetyData;
    }

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

    public List<String> getPhoneNumbersByAddress(String address) {

        List<String> phoneNumbers = new ArrayList<>();
        return phoneNumbers;
    }
    public List<Person> getPersonsByAddress(String address){
        return this.persons.stream()
                .filter(person -> Objects.equals(person.getAddress(), address))
                .collect(Collectors.toList());
    }
}


