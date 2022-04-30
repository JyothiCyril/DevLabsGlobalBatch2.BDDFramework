package com.qa.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D:\\DevLabs\\Global- Batch 2\\DevLabsGlobalBatch2.BDDFramework\\src\\test\\java\\com\\qa\\features\\AmazonFeature.feature"},
        glue = {"com.qa.stepdefinitions"},
        plugin = {"json:target/cucumber.json"})
public class TestRunner {
}