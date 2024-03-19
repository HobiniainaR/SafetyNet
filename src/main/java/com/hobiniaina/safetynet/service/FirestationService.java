package com.hobiniaina.safetynet.service;

import com.hobiniaina.safetynet.model.Firestation;
import com.hobiniaina.safetynet.repository.FirestationRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service

public class FirestationService {

        private final FirestationRepository firestationRepository;


        public FirestationService(FirestationRepository firestationRepository) {
                this.firestationRepository = firestationRepository;
        }

        public List<Firestation> getAllFirestations() {
                return firestationRepository.getAllFirestations();
        }

        public void addFirestation(Firestation firestation) {
                firestationRepository.save(firestation);
        }

        public void updateFirestation(Firestation updatedFirestation) {
                firestationRepository.update(updatedFirestation);
        }

        public void deleteFirestation(Integer station, String address) {
                firestationRepository.deleteByStationOrAddress(station, address);
        }

        public List<String> getAddressesOfFirestation(Integer station){
                return this.firestationRepository.getAddressesByFirestation(station);
        }



}
