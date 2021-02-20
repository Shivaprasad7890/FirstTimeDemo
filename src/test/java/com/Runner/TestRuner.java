package com.Runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/Features", glue = { "com/Stepdefinitions" }, dryRun = false,
plugin="json:target/jsonReports/cucumber-report.json")//tags ="@DeletePlaceTestCase")

public class TestRuner {

}
