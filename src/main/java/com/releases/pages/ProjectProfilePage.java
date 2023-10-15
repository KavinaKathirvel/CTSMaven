package com.releases.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.releases.basepage.BasePageUi;

public class ProjectProfilePage extends BasePageUi{
	/*********************constructor***********************/
	public ProjectProfilePage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
	}
	/**********************locating web elements by using find by annotation*********************/
	@FindBy(id="LOCK_Plan")
	WebElement plan;
	
	@FindBy(id="LOCK_Releases")
	WebElement releases;
	
	@FindBy(xpath = "//span[@id='KEY_BUTTON_Add-btnIconEl']")
	WebElement addButton;
	/***********************function to navigate to the releases page**********************/
	public ReleasesPage navigateToReleases() {
		//try catch to handle exception
		try {
        //action class to handle mouse events
		Actions action=new Actions(driver);
		driver.switchTo().defaultContent();
		//waits until the plan webelement is visible
		wait.until(ExpectedConditions.visibilityOf(plan));
		//navigates to the webelement
		action.moveToElement(plan).build().perform();
		//passing information to the reports
		reportInfo("Navigating to Plans","navigateToReleases");
		//wait for a certain measure of time before throwing an exception
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//clicks the releases option
	    click(releases, "clicking the releases option", "Successfully clicked the releases option");
	    //waits until the add element is clickable
		wait.until(ExpectedConditions.elementToBeClickable(addButton));
		//passing pass message to the report
		reportPass("Successfully navigated to Releases Page","navigateToReleases");
		}
		catch (Exception e) {
			//prints the throwable
			e.printStackTrace();
			//passing fail message to the report
		    reportFail("Navigation failed to releases option","navigateToReleases");
		}
		//creating object for the releasespage
	    ReleasesPage releasespage = new ReleasesPage(driver,logger);
	    //initializes the driver
		PageFactory.initElements(driver, releasespage);
		//returns the object of the ReleasesPage
		return releasespage;
		

	}



}
