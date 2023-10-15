package com.releases.testrunner;

import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;

@RunWith(Cucumber.class)
@CucumberOptions(
		// path to the feature file
		features="src\\main\\resources\\featurefiles\\releasesModule.feature",
	    //path to the stepdefinition files
		glue= {"com\\releases\\stepdefinitionfiles"}, 
		//path of Step definition file
		format= {"pretty","html:reports/html-report","json:reports/json-report/cucumber.json","junit:reports/xml-report/cucumber.xml"},
		//steps should have  implementation while dryrun is true
		dryRun = false,
		monochrome = true,
		strict = true,
		tags = {"@checkReleases"}
		)
//running cucumber using testng 
public class ReleasesTestRunner {

	public  static TestNGCucumberRunner testNgCucumberRunner;

	@BeforeClass(alwaysRun=true)
	public void setup() {
		//glue code to refer the cucumber class
		testNgCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		//running cucumber with testng using feature file
		testNgCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features(){
		//provides feature files for each test case
		return testNgCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun=true)
	public void close() {
		//completes testng run
		testNgCucumberRunner.finish();
	}

}



