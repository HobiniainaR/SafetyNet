package com.hobiniaina.safetynet.Repository;


import com.hobiniaina.safetynet.model.Person;
import com.hobiniaina.safetynet.model.SafetyData;
import com.hobiniaina.safetynet.repository.CommunityEmailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CommunityEmailRepositoryTest {

    private CommunityEmailRepository communityEmailRepository;
    private SafetyData safetyData;

    @BeforeEach
    void setUp() throws IOException {
        safetyData = mock(SafetyData.class);
        List<Person> persons = List.of(
                new Person("John", "Doe", "1509 Culver St", "Culver", "97451", "841-874-6512", "jaboyd@email.com"),
                new Person("Jacob", "Boyd", "1509 Culver St", "Culver", "97451", "841-874-6513", "drk@email.com")

        );
        when(safetyData.getPersons()).thenReturn(persons);

        communityEmailRepository = new CommunityEmailRepository();
    }

    @Test
    void getEmailsByCity_ShouldReturnDistinctEmails() {
        String city = "Culver";

        List<String> emails = communityEmailRepository.getEmailsByCity(city);


        assertEquals(2, emails.size());
        assertEquals("jaboyd@email.com", emails.get(0));
        assertEquals("drk@email.com", emails.get(1));
    }
}



