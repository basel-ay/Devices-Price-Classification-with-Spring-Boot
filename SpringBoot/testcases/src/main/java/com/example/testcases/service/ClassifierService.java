package com.example.testcases.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class ClassifierService {

    @Autowired
    private RestTemplate restTemplate;

    private final String flaskUrl = "http://127.0.0.1:5000/predict";

    public String classify(Map<String, Object> input) {
        return restTemplate.postForObject(flaskUrl, input, String.class);
    }
}
