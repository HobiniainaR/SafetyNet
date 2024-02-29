package com.hobiniaina.safetynet.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class medicalRecord {

    private String firstName;
    private String lastName;
    private int birthdate;
    private List<String>medications;
    private List<String> allergies;
}
