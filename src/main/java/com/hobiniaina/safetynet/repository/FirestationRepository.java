package com.hobiniaina.safetynet.repository;

import com.hobiniaina.safetynet.model.Firestation;
import com.hobiniaina.safetynet.model.SafetyData;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



@Repository
public class FirestationRepository {
    SafetyData safetyData = SafetyData.readFromJsonFile("C:\\Users\\rabho\\Documents\\Openclassrooms\\safetynet\\src\\main\\resources\\data.json");
    List<Firestation> firestations=safetyData.getFirestations();

    public FirestationRepository() throws IOException {
        this.safetyData = safetyData;
    }

    public List<Firestation> getAllFirestations() {

        return new ArrayList<>(firestations);
    }

    public void save(Firestation firestation) {

        firestations.add(firestation);
    }

    public void update(Firestation updatedFirestation) {
        firestations.stream()
                .filter(f -> f.getAddress().equals(updatedFirestation.getAddress()))
                .findFirst()
                .ifPresent(existingFirestation -> {
                    existingFirestation.setStation(updatedFirestation.getStation());
                });
    }

    public void deleteByStationOrAddress(Integer station, String address) {
        firestations.removeIf(firestation -> firestation.getStation().equals(station) || firestation.getAddress().equals(address));
    }
}
