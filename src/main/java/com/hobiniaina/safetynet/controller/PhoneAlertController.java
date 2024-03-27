package com.hobiniaina.safetynet.controller;


import com.hobiniaina.safetynet.service.PhoneAlertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
public class PhoneAlertController {


        private final PhoneAlertService phoneAlertService;

        public PhoneAlertController(PhoneAlertService phoneAlertService) {
            this.phoneAlertService = phoneAlertService;
        }

        @GetMapping("/phoneAlert")
        public ResponseEntity<List<String>> getPhoneNumbersByFirestation(@RequestParam(value = "firestation") Integer station) {
            List<String> phoneNumbers = phoneAlertService.getPhoneNumbersByFirestation(station);
            return new ResponseEntity<>(phoneNumbers, HttpStatus.OK);
        }
    }





