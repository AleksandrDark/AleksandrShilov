package com.epam.tc.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = {"src/test/resources/com.epam.tc.hw5/DifferentElementPageCucumber.feature",
    "src/test/resources/com.epam.tc.hw5/VipButton.feature", "src/test/resources/com.epam.tc.hw5/UserTable.feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
