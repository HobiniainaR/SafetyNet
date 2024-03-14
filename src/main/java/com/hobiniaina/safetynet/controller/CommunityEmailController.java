package com.hobiniaina.safetynet.controller;

import com.hobiniaina.safetynet.repository.CommunityEmailRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/communityEmail")
public class CommunityEmailController {

    private final CommunityEmailRepository communityEmailRepository;

    public CommunityEmailController(CommunityEmailRepository communityEmailRepository) {
        this.communityEmailRepository = communityEmailRepository;
    }

    @GetMapping
    public ResponseEntity<List<String>> getEmailsByCity(@RequestParam String city) {

            List<String> emails = communityEmailRepository.getEmailsByCity(city);
            return new ResponseEntity<>( HttpStatus.OK);

        }
    }

