package com.releases.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.aventstack.extentreports.ExtentTest;
import com.releases.basepage.BasePageUi;

public class ReleasesPage  extends BasePageUi{
	/********************constructor********************/
	public ReleasesPage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
	}
	
	/**********************locating web elements by using find by annotation**********************/
	@FindBy(xpath = "//span[@id='KEY_BUTTON_Add-btnIconEl']")
	WebElement addButton;

	@FindBy(xpath = "//iframe[@id='contentframe']")
	WebElement frameWindow;

	
	By nameField = By.cssSelector("#_Text_Check_CM_Name");
    /*********************function to click add releases element**********************/
	public CreateReleasesPage clickAddReleases() {
		//try catch to handle exception
		try {
	   //clicks the add button
		click(addButton, "Clicking the add button to fill the details in the releases page", "Successfully clicked the add button");
		//wait for a page to load
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		//waits and switch to the framewindow
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameWindow));
		//waits until the name field is visible
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
		
	}
		catch (Exception e) {
			//prints the throwable
			e.printStackTrace();
			//passing fail message to the report
			reportFail("Failed to click the add button","clickAddDefect");
			
		}
		//object creation for the CreateReleasesPage 
		CreateReleasesPage addreleasespage = new CreateReleasesPage(driver,logger);
		//initializes driver in the CreateReleasesPage 
		PageFactory.initElements(driver, addreleasespage);
		//returns the CreateReleasesPage object
		return addreleasespage;

}
	
	
	


}
