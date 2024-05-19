package com.example.testcases.service;

import com.example.testcases.model.TestCase;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestCaseService {

    public TestCase createTestCase(Map<String, Object> testCaseData) {
        // Assuming all fields are provided and correct type casting
        TestCase testCase = new TestCase();

        testCase.setBatteryPower((Integer) testCaseData.get("battery_power"));
        testCase.setBlue((Integer) testCaseData.get("blue"));
        testCase.setClockSpeed((Double) testCaseData.get("clock_speed"));
        testCase.setDualSim((Integer) testCaseData.get("dual_sim"));
        testCase.setFc((Integer) testCaseData.get("fc"));
        testCase.setFourG((Integer) testCaseData.get("four_g"));
        testCase.setIntMemory((Integer) testCaseData.get("int_memory"));
        testCase.setmDep((Double) testCaseData.get("m_dep"));
        testCase.setMobileWt((Integer) testCaseData.get("mobile_wt"));
        testCase.setnCores((Integer) testCaseData.get("n_cores"));
        testCase.setPc((Integer) testCaseData.get("pc"));
        testCase.setPxHeight((Integer) testCaseData.get("px_height"));
        testCase.setPxWidth((Integer) testCaseData.get("px_width"));
        testCase.setRam((Integer) testCaseData.get("ram"));
        testCase.setScH((Integer) testCaseData.get("sc_h"));
        testCase.setScW((Integer) testCaseData.get("sc_w"));
        testCase.setTalkTime((Integer) testCaseData.get("talk_time"));
        testCase.setThreeG((Integer) testCaseData.get("three_g"));
        testCase.setTouchScreen((Integer) testCaseData.get("touch_screen"));
        testCase.setWifi((Integer) testCaseData.get("wifi"));

        // Save the testCase to database (not shown here)
        // Example: testCaseRepository.save(testCase);

        return testCase;
    }
}
