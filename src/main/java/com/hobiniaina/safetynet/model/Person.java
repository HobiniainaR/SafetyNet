package com.hobiniaina.safetynet.model;


import lombok.Data;

import java.util.List;


@Data

public class  Person {
    private Long id;
    private String firstName;
    private String lastName;
    private  int age;
    private String address;
    private String city;
    private Long zip;
    private Long phone;
    private String email;

}

