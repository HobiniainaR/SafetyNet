package com.hobiniaina.safetynet.model;



import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class  Person {

    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String zip;
    private String phone;
    private String email;

}

