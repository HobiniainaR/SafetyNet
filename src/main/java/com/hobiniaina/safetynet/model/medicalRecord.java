package com.hobiniaina.safetynet.model;

import lombok.*;


import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class medicalRecord {
    private String firstName;
    private String lastName;
    private String birthdate;
    private List<String> medications;
    private List<String> allergies;

}
