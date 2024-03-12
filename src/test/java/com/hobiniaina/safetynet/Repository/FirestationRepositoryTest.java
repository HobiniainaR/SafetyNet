
package com.hobiniaina.safetynet.Repository;

import static org.junit.jupiter.api.Assertions.*;

import com.hobiniaina.safetynet.model.Firestation;
import com.hobiniaina.safetynet.repository.FirestationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

class FirestationRepositoryTest {

    private FirestationRepository firestationRepository;

    @BeforeEach
    public void setUp() throws IOException {
        firestationRepository = new FirestationRepository();
    }

   @Test
   public void testGetAllFirestations() {
        List<Firestation> firestations = firestationRepository.getAllFirestations();
        assertNotNull(firestations);
        assertFalse(firestations.isEmpty());
    }

   @Test
   public void testSave() {
        Firestation firestation = new Firestation();
        firestation.setAddress("4567 Culver St");
        firestation.setStation(1);
        firestationRepository.save(firestation);

        assertTrue(firestationRepository.getAllFirestations().contains(firestation));
    }

    @Test
   public void testUpdate() {
        Firestation firestation = new Firestation();
        firestation.setAddress("4567 Culver St");
        firestation.setStation(1);
        firestationRepository.save(firestation);

        Firestation updatedFirestation = new Firestation();
        updatedFirestation.setAddress("4567 Culver St");
        updatedFirestation.setStation(3);
        firestationRepository.update(updatedFirestation);

        Firestation result = firestationRepository.getAllFirestations().stream()
                .filter(f -> f.getAddress().equals("4567 Culver St"))
                .findFirst()
                .orElse(null);

        assertNotNull(result);
        assertEquals(3, result.getStation());
    }

  @Test
  public void testDeleteByStationOrAddress() {
        Firestation firestation = new Firestation();
        firestation.setAddress("4567 Culver St");
        firestation.setStation(1);
        firestationRepository.save(firestation);

        firestationRepository.deleteByStationOrAddress(1, "4567 Culver St");
        assertFalse(firestationRepository.getAllFirestations().contains(firestation));
    }
}
