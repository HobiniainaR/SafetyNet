package com.hobiniaina.safetynet.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class ChildAlertDTO {
        private String firstName;
        private String lastName;
        private int age;

        private List<String> householdMembers;
}
