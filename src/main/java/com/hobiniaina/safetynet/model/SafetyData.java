package com.hobiniaina.safetynet.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;



import java.io.File;
import java.io.IOException;
import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class SafetyData {

    private List<Person> persons;
    private List<Firestation> firestations;
    private List<medicalRecord> medicalrecords;

    public static SafetyData readFromJsonFile(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(filePath), SafetyData.class);
    }


}
