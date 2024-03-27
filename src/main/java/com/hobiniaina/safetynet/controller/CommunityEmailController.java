package com.hobiniaina.safetynet.controller;

import com.hobiniaina.safetynet.service.CommunityEmailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommunityEmailController {

    private final CommunityEmailService communityEmailService;

    public CommunityEmailController(CommunityEmailService communityEmailService) {
        this.communityEmailService = communityEmailService;
    }

    @GetMapping("/communityEmail")
    public ResponseEntity<List<String>> getEmailsByCity(@RequestParam(value="city") String city) {
        List<String> emails = communityEmailService.getEmailsByCity(city);
        return new ResponseEntity<>(emails, HttpStatus.OK);
    }
}
