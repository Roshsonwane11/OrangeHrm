package com.hrm.Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features", glue = "com.hrm.steps" 
//, tags = "@today"
)
public class TestRunner extends AbstractTestNGCucumberTests {

}
