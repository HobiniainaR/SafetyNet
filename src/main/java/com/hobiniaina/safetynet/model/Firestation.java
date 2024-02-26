package com.hobiniaina.safetynet.model;

import lombok.Data;

import java.util.List;

@Data
public class Firestation {
    private Long id;
    private  int station_number;
    private String address;
    private List<Person> residents;
}

