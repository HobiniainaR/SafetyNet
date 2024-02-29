package com.hobiniaina.safetynet.model;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@lombok.Data
@JsonIgnoreProperties
public class Data {
    private List<Person> persons;
    private List<Firestation> firestations;
    private List<medicalRecord>medicalrecords;

}
