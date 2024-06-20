package com.nexsystech.interview.helper.service.impl;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NLPService {
    @Value("${NlpApiUrl}")
    private String apiUrl;

    public String getAnswer(String question) {
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.postForObject(this.apiUrl, question, String.class);
        return response;
    }
}
