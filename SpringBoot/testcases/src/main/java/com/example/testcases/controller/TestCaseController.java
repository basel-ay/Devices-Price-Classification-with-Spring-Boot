package com.example.testcases.controller;

import com.example.testcases.model.TestCase;
import com.example.testcases.service.TestCaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/testcases")
public class TestCaseController {

    @Autowired
    private TestCaseService testCaseService;

    @PostMapping
    public ResponseEntity<TestCase> createTestCase(@Valid @RequestBody Map<String, Object> testCaseData) {
        TestCase testCase = testCaseService.createTestCase(testCaseData);
        return ResponseEntity.ok(testCase);
    }
}
