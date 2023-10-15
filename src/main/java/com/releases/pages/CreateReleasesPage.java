package com.releases.pages;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import com.aventstack.extentreports.ExtentTest;
import com.releases.basepage.BasePageUi;

public class CreateReleasesPage extends BasePageUi{
	/****************************Constructor********************************/
	public CreateReleasesPage(WebDriver driver,ExtentTest logger) {
		super(driver,logger);
	}
	/**************************Locating WebElements by using find by annotation**************************/
	@FindBy(xpath="//*[@id=\"_Text_Check_CM_Name\"]")
	WebElement name;
	
	@FindBy(id="releasetype")
	WebElement releaseType;
	
	@FindBy(id="CM_Priority")
	WebElement priority;
	
	@FindBy(id="DN_Technology")
	WebElement technology;
	
	@FindBy(id="cal_STARTDATE")
	WebElement calendarIconStartDate;
	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[1]")
	WebElement monthSelect;

	
	@FindBy(xpath="//*[@id=\"ui-datepicker-div\"]/div[1]/div/select[2]")
	WebElement yearSelect;
	
	@FindAll(@FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr/td/a"))
	List<WebElement> dates;
	
	@FindBy(id="cal_releasedate")
	WebElement calendarIconEndDate;
	
	@FindBy(id="SaveAddNewBtn")
	WebElement saveAndAddNew;
	
	@FindBy(id="SaveBtn")
	WebElement save;
	
	@FindBy(id="DN_Description")
	WebElement description;
	
	@FindBy(id="CancelBtn")
	WebElement returnButton;
	
	@FindBy(id="CM_ItemCode")
	WebElement id;
	
	
	
	/****************************function to enter name in the releases page***************************/
	public void enterName() {
		// try catch block to handle the exception
		try {
		//passing information to the reports	
		reportInfo("Entering the data for name field", "enterName");
		//sends the name data from excel sheet
		name.sendKeys(releasesDatas.get(0).get("Name"));
		//passing pass message to report
		reportPass("Succcessfully entered the name for the releases","enterName");
		}
		catch (Exception e) {
			//prints the throwable 
			e.printStackTrace();
			//passing fail message to report
			reportFail("Not able to enter the name for the releases","enterName");
		}
      }
	/**************************function to enter the description in the releases***************************/
	public void enterDescription() {
		// try catch block to handle the exception
		try {
			//passing information to report
			reportInfo("Entering the description for Releases", "enterDescription");
			//sends the description data from excel sheet
			description.sendKeys(releasesDatas.get(0).get("Description"));
			//passing pass message to report
			reportPass("Succcessfully entered the Description","enterDescription");
			}
		catch (Exception e) {
		  //prints the throwable 	
		  e.printStackTrace();
		  //passing fail message to report
		  reportFail("failed to enter the description","enterDescription");
		  
		}
	}
	/*****************************function to select the release type in the releases page********************************/
	
	public void selectReleaseType() {
		// try catch block to handle the exception
		try {
			//passing information to report
		    reportInfo("Selecting Release type from the dropdown value", "selectReleaseType");
		    //selects the release type by visible text from drop down 
			Select selectReleaseType = new Select(releaseType);
			selectReleaseType.selectByVisibleText(releasesDatas.get(0).get("Release Type"));
			//passing pass message to report
			reportPass("Successfully selected the release type for Releases","selectReleaseType");

		}
		catch (Exception e) {
			//prints the throwable
			e.printStackTrace();
			//passing fail message to report
		    reportFail("Failed to select the release type","selectReleaseType");
		}
		
	}
	/*****************************function to select the priority in the releases page********************************/
	public void selectPriority() {
		// try catch block to handle the exception
		try {
			//passing information to report
		    reportInfo( "Selecting Priority from the dropdown value","selectPriority");
		  //selects the priority by visible text from dropdown 
			Select selectPriority = new Select(priority);
			selectPriority.selectByVisibleText(releasesDatas.get(0).get("Priority"));
			//passing pass message to report
			reportPass("Successfully selected the Priority for the Releases","selectPriority");

		}
		catch (Exception e) {
			//prints the throwable
			e.printStackTrace();
			//passing fail message to report
		    reportFail("Failed to select the Priority from drop down","selectPriority");
		}

	}
	/*****************************function to select the technology in the releases page********************************/
	public void selectTechnology() {
		// try catch block to handle the exception
		try {
			//passing information to report
			reportInfo("Selecting Technology from the dropdown value","selectTechnology");
			//selects the technology by visible text from dropdown 
			Select selectTechnology = new Select(technology);
			selectTechnology.selectByVisibleText(releasesDatas.get(0).get("Technology"));
			//passing pass message to report
			reportPass("Successfully selected the Technology for the Releases","selectTechnology");

		}
		catch (Exception e) {
			//prints the throwable
			e.printStackTrace();
			//passing fail message to report
		    reportFail("Failed to select the Technology from drop down","selectTechnology");
		}
	}
	/*************************function to select the date for start and end of releases***************************/
	public void selectDate(String date) {
		//parses the String argument as a signed decimal integer object
		int day = Integer.parseInt(date.substring(0, 2));

		int month = Integer.parseInt(date.substring(3, 5));

		String year= date.substring(6, 10);
		//selects the year by visible text from drop down
		Select select = new Select(yearSelect);
		select.selectByVisibleText(year);
		//selects the year by index from drop down
		Select selectmonth = new Select(monthSelect);
		selectmonth.selectByIndex(month-1);
        //handling mouse events
		Actions action = new Actions(driver);
		WebElement selectDate=dates.get(day-1);
		action.moveToElement(selectDate).click().perform();
		
	}
	/************************function to select the start date*****************************/
	public void selectStartDate() {
		// try catch block to handle the exception
		try {
			//waits until the calendar icon is clickable
			wait.until(ExpectedConditions.elementToBeClickable(calendarIconStartDate));
			//clicks the calendar icon
			click(calendarIconStartDate, "clicking calendar icon to select start date", "Successfully selected the calendar icon");
			//reads the start date from excel
			String date=releasesDatas.get(0).get("Start Date");
			//passing date to the selectDate method
			selectDate(date);
			//passing pass message to report
			reportPass("Successfully selected the start date for Releases","selectStartDate");

			
		} catch (Exception e) {
			//prints the throwable
			e.printStackTrace();
			//passing fail message to report
			reportFail("Failed to select the Start Date for Releases","selectStartDate");
			
		}
	}
	/************************function to select the end date*****************************/
	public void selectEndDate() {
		try {
			//waits until the calendar icon is clickable
			wait.until(ExpectedConditions.elementToBeClickable(calendarIconEndDate));
			//clicks the calendar icon
			click(calendarIconEndDate, "clicking calendar icon to select End date", "Successfully selected the calendar icon");
			//reads the end date from excel
			String date=releasesDatas.get(0).get("End Date");
			//passing date to the selectDate method
			selectDate(date);
			//passing pass message to report
            reportPass("Successfully selected the End date for Releases","selectEndDate");

			
		} catch (Exception e) {
			//prints the throwable
			e.printStackTrace();
			//passing fail message to report
			reportFail("Failed to select the End Date for Releases","selectEndDate");
		}
	}
	/************************function to  save the details and return to releases page***************************/
	public ReleasesPage saveAndReturn() {
		try {
			//clicks the save button
			click(save,"clicking save button in the Releases Page", "Successfully clicked the save button");
			//passing information to the report
				reportInfo("Checking if the id for the Releases is generated","saveAndReturn");
				System.out.println("*************************************");
				System.out.println("ID for the created Release:");
				//waits until the webElement Id is visible
				wait.until(ExpectedConditions.visibilityOf(id));
				//prints the Id of the created release
				System.out.println(id.getText());
				System.out.println("*************************************");
				//passing pass message to the report
				reportPass("ID generated successfully for the saved Release","saveAndReturn");
				//try catch to handle exception
				try {
					wait.until(ExpectedConditions.elementToBeClickable(returnButton));
				} catch (Exception e) {
					wait.until(ExpectedConditions.elementToBeClickable(returnButton));
				}
				//clicks the return button
				click(returnButton, "clikcing the return button", "Successfully clicked the return button");	
			} 
		catch(Exception e){
            //prints the throwable
			e.printStackTrace();
			//passing fail message to report
			reportFail("Failed to save and return","saveAndReturn");
		}
		ReleasesPage releasespage = new ReleasesPage(driver,logger);
		//pagefactory to initialize driver
		PageFactory.initElements(driver, releasespage);
		//returns the object of the releases page
		return releasespage;
	}

			
		
	/*******************************function to handle alert for the unentered data*******************************/
	
	public void handleAlert() {
		//passing information to reports
		reportInfo("Entering Release details to handle alert","handleAlert");
		//entering details for the releases page
		enterName();
		selectStartDate();
		selectEndDate();
		enterDescription();
		selectReleaseType();
		//clicks the save button
		click(save, "clicking save button in the Releases Page", "Successfully clicked the save button");
		//try catch to handle exception
		try {
			//waits until the alert is present
			wait.until(ExpectedConditions.alertIsPresent());
			//switch to alert
			Alert alert = driver.switchTo().alert();
			//read the alert message
			String alertMessage = alert.getText();
			//accepts the alert
			alert.accept();
			//passing pass message to the report
			reportPass("Handled alert and the alert message was: "+ alertMessage,"handleAlert");
			//prints the alert message into the console
			System.out.println("Handled alert and the alert message was:\n "+ alertMessage);
			System.out.println("*************************************");
		}catch (Exception e) {
			//prints the throwable
			e.printStackTrace();
			//passing fail message to the report
			reportFail(e.getMessage(),"handleAlert");
		}
		
	}
	
	
}