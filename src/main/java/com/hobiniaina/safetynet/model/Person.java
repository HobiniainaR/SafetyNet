package com.hobiniaina.safetynet.model;


import lombok.AllArgsConstructor;
import lombok.Data;




@AllArgsConstructor
@Data

public class  Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private Long zip;
    private Long phone;
    private String email;

}

