package com.releases.stepdefinitionfiles;

import org.openqa.selenium.support.PageFactory;

import com.releases.basepage.BasePageClass;
import com.releases.basepage.BasePageUi;
import com.releases.pages.CreateReleasesPage;
import com.releases.pages.HomePage;
import com.releases.pages.ProjectProfilePage;
import com.releases.pages.ReleasesPage;
import com.releases.utilities.CustomReport;
import com.releases.utilities.PropertyFileReader;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class ReleasesModuleSteps extends BasePageClass {
	//object creation for the pages
	public HomePage homepage;
	public CreateReleasesPage addreleasespage;
	public ProjectProfilePage projectprofilepage;
	public ReleasesPage releasespage;
	public BasePageUi basepageui;
	public BasePageClass basepageclass;
    PropertyFileReader propertyreader=new PropertyFileReader(); 
	
	
    //@before runs before each scenario
	@Before
	public void pageSetUp() {
		//creates the test for the extent-report
		logger=report.createTest("Release Module Creation");
        //creation of the custom report object
		customReport=new CustomReport();
		//initializeCustomReport
		customReport.getReportInstance("Releases Module Test Report");
		//reads browser name from property file
		String browserName=propertyreader.getBrowserName();
		//invokes browser
		invokeBrowser(browserName);
		//initializes base page object
	    basepageui = new BasePageUi(driver,logger);
		PageFactory.initElements(driver, basepageui);
		//reads value from the excel data 
		basepageui.getExcelData();
		//opens the website
		homepage=basepageui.openWebsite();
		//verifies login
		homepage.verifyLogin();
		
		
	}
	
	
	@Given("^Navigate to project site$")
	public void navigate_to_project_site() throws InterruptedException  {
		//calling method in homepage and returns the object
		projectprofilepage=homepage.navigateToProject();
		

	}

	@Then("^Select Releases option$")
	public void select_Releases_option()  {
		//calling method in projectprofilepage and returns the object
		releasespage=projectprofilepage.navigateToReleases();
	}

	@Then("^Click add Release$")
	public void click_add_Release()  {
		//calling method in releasespage and returns object to addreleasespage
		addreleasespage=releasespage.clickAddReleases();
	}

	@Then("^Add Release details$")
	public void add_Release_details() throws InterruptedException {
		//calling methods in addreleasespage to enter the details in the form
		addreleasespage.enterName();
		addreleasespage.enterDescription();
		addreleasespage.selectReleaseType();
		addreleasespage.selectPriority();
		addreleasespage.selectTechnology();
		addreleasespage.selectStartDate();
		addreleasespage.selectEndDate();
	}

	
    @And("^Capture Id and navigate back to Releases page$")
    public void capture_Id_and_navigate_back_to_Releases_page()  {
    	//calling addreleasespage method to save and return 
    	releasespage=addreleasespage.saveAndReturn();
    }

    @Then("^create new release$")
    public void create_new_release()  {
    	//calling releasespage method 
    	addreleasespage=releasespage.clickAddReleases();
    }

    @And("^Handle alert for the mandatory fields$")
    public void handle_alert_for_the_mandatory_fields() {
    	//calling method to handle alert
        addreleasespage.handleAlert();
    }

  //@after runs after each scenario
	@After
    public void closeBrowser() {
	  //flushes the report 	
	  report.flush();
	  customReport.flushReport();
	  //quits the driver
	  driver.quit();
  }
}



