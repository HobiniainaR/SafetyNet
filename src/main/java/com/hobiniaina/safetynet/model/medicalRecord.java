package com.hobiniaina.safetynet.model;

import lombok.Data;

import java.util.List;

@Data
public class medicalRecord {
    private Long id;
    private String firstName;
    private String lastName;
    private int datebirth;
    private List<String>medications;
    private List<String> allergies;
}
