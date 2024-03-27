package com.hobiniaina.safetynet.Service;



import com.hobiniaina.safetynet.model.Person;



import com.hobiniaina.safetynet.repository.FirestationRepository;
import com.hobiniaina.safetynet.repository.PersonRepository;
import com.hobiniaina.safetynet.service.FirestationService;
import com.hobiniaina.safetynet.service.PersonService;
import com.hobiniaina.safetynet.service.PhoneAlertService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


import org.springframework.test.context.junit.jupiter.SpringExtension;



import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)

public class PhoneAlertServiceTest {

private PhoneAlertService phoneAlertService;
private FirestationRepository firestationRepository;
private PersonRepository personRepository;
private FirestationService firestationService;
private PersonService personService;

@BeforeEach
    void setUp() {
            firestationRepository = mock(FirestationRepository.class);
        personRepository = mock(PersonRepository.class);
        firestationService = mock(FirestationService.class);
        personService = mock(PersonService.class);

        phoneAlertService = new PhoneAlertService(firestationRepository, personRepository, firestationService, personService);
        }

@Test
    void getPhoneNumbersByFirestation_ShouldReturnDistinctPhoneNumbers() {
        int station = 1;
        List<String> stationAddresses = List.of("1509 Culver St", "29 15th St");
        when(firestationService.getAddressesOfFirestation(station)).thenReturn(stationAddresses);


        List<Person> persons = List.of(
        new Person("John", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com"),
        new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com" ),
        new Person("Jonanathan", "Marrack", "29 15th St", "Culver", "97451", "841-874-6513", "drk@email.com")
        );
        when(personService.getPersons()).thenReturn(persons);

        List<String> phoneNumbers = phoneAlertService.getPhoneNumbersByFirestation(station);


        assertNotNull(phoneNumbers);
        assertEquals(2, phoneNumbers.size());
        assertEquals("841-874-6512", phoneNumbers.get(0));
        assertEquals("841-874-6513", phoneNumbers.get(1));
        }
  }