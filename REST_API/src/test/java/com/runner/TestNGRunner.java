package com.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = { "src/test/resources/FeatureFiles",  }, glue = {
		"com.stepdefinition" }, plugin = { "pretty" }, dryRun = false )
public class TestNGRunner extends AbstractTestNGCucumberTests {

}
