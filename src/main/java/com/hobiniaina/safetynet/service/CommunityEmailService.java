package com.hobiniaina.safetynet.service;


import com.hobiniaina.safetynet.repository.CommunityEmailRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommunityEmailService {
    private final CommunityEmailRepository communityEmailRepository;

    public CommunityEmailService(CommunityEmailRepository communityEmailRepository) {
        this.communityEmailRepository = communityEmailRepository;
    }

    public List<String> getEmailsByCity(String city) {
        return communityEmailRepository.getEmailsByCity(city);
    }
}