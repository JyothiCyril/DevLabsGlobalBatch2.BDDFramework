package com.qa.testrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"D:\\DevLabs\\Global- Batch 2\\DevLabsGlobalBatch2.BDDFramework\\src\\test\\java\\com\\qa\\features\\AmazonFeature.feature"},
        glue = {"com.qa.stepdefinitions"},
        plugin = {"json:target/cucumber.json"},
        publish=true)


public class AmazonTestRunner extends AbstractTestNGCucumberTests{
	@Override
	@DataProvider(parallel=true)
    public Object[][] scenarios() {
		return super.scenarios();	}

}
