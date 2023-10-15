package com.releases.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;
import com.releases.basepage.BasePageUi;

public class HomePage  extends BasePageUi{

	/**************************constructor******************************/
	public HomePage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	/*************************Locating webelements by using find by annotation***********************/
	@FindBy(xpath="//*[@id=\"navbar\"]/div[3]/div[1]/span")
	WebElement menuIcon;
	
	@FindBy(xpath="//*[@id=\"projectIcon\"]/span")
	WebElement projectIcon;
	
	@FindBy(xpath="//*[@id='projectIcon']/ul/li/a")
	WebElement cfoOnsite;
	
	By projectCodeLabel=By.id("ProjectCodeLABEL");
	
	@FindBy(xpath="//h4[contains(text(),'My Workitems')]")
	WebElement workItems; 

	@FindBy(xpath = "//iframe[@id='contentframe']")
	WebElement frameWindow;
	/***********************function to verify if the user is able to Login***************************/
	public void verifyLogin() {
		//try catch to handle exception
		try {
			//wait for a page to load
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			//Initialize A Wait Object using WebDriverWait Class
			wait  = new WebDriverWait(driver, 300);
			//passing information to the report
			reportInfo("Logging in", "verifyLogin");
			//waits until the element is visible
			wait.until(ExpectedConditions.visibilityOf(workItems));
			//passing pass message to report
			reportPass("Logged in Successfully","verifyLogin");
		} catch (Exception e) {
			//prints throwable
			e.printStackTrace();
			//passing fail message to report
			reportFail("Not Logged in","verifyLogin");
		}
		
	}
	
	/******************************function to navigate to the project menu icon********************************/
	public ProjectProfilePage navigateToProject() {
		//try catch to handle exception
		try {
			//action class to handle mouse events
			Actions action=new Actions(driver);
			//navigates to the icon
			action.moveToElement(menuIcon).build().perform();
			try {
				//waits for the element to be visible
				wait.until(ExpectedConditions.visibilityOf(cfoOnsite));
				//clicking the webelement
				click(cfoOnsite, "clicking CFO_Onsite menu", "Successfully Clicked the CFO_Onsite menu icon");
				} catch (Exception e) {
				click(projectIcon, "clicking the Project/Program icon", "Successfullly clicked the Project/Program icon");
				click(cfoOnsite, "clicking CFO_Onsite menu", "Successfully Clicked the CFO_Onsite menu icon");
			}
            //switch to the frame window
			driver.switchTo().frame(frameWindow);
			//waits until the element is present
			wait.until(ExpectedConditions.presenceOfElementLocated(projectCodeLabel));
			//passing pass message to report
			reportPass("Successfully navigated to Project Profile Page","navigateToProject");	
	} 
		catch (Exception e) {
			//prints throwable
			e.printStackTrace();
			//passing fail message to report
			reportFail("Failed to navigate to the Project Profile Page","navigateToProject");
		}
		ProjectProfilePage projectprofilepage = new ProjectProfilePage(driver,logger);
		//pagefactory to initialize driver
		PageFactory.initElements(driver, projectprofilepage);
		//returns the object of the projectProfilePage class
		return projectprofilepage;
		
	}
	
	
	


}
