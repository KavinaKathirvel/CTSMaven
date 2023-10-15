package com.releases.basepage;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.releases.pages.HomePage;
import com.releases.utilities.DateUtil;
import com.releases.utilities.PropertyFileReader;
import com.releases.utilities.ReadExcelData;

public class BasePageUi extends BasePageClass {
	/******************Constructor********************/
	public BasePageUi(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	//property reader object to read the properties from property file
	PropertyFileReader propertyreader=new PropertyFileReader();
	//data list from excel sheet
	public static List<Map<String, String>> releasesDatas;
	
	
	/****************** OpenApplication ***********************/

	public HomePage openWebsite() {
		logger.log(Status.INFO, "Opening the WebSite");
		//launch the url of the website
		driver.get(propertyreader.getUrl());
		// wait for a certain measure of time before throwing an exception
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//wait for a page to load
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		logger.log(Status.PASS, "Successfully Opened the MainSpring website");
		HomePage homepage = new HomePage(driver, logger);
		PageFactory.initElements(driver, homepage);
		//returns the homepage object using pagefactory
		return homepage;
	}
	/***********************Reads the excel data*************************/	
	public void getExcelData()  {
		ReadExcelData readExcel = new ReadExcelData();
		try {
			releasesDatas = readExcel.getTestData("ReleasesData.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/****************** Reporting Functions ***********************/
	public void reportFail(String reportString,String methodName) {
		//logs into the extent-report
		logger.log(Status.FAIL, reportString);
		//logs into custom report
		customReport.logFail(reportString, methodName);
		takeScreenShotOnFailure();
		//asserts fail
		Assert.fail(reportString);
	}

	public void reportPass(String reportString,String methodName) {
		//logs into the extent-report
		logger.log(Status.PASS, reportString);
		//logs into custom report
		customReport.logPass(reportString, methodName);
	}
	
	public void reportInfo(String reportString,String methodName) {
		//logs into the extent-report
		logger.log(Status.INFO, reportString);
		//logs into the custom report
		customReport.logInfo(reportString, methodName);
	}

	/****************** Capture Screen Shot on Failure ***********************/
	public void takeScreenShotOnFailure() {
		//takes screenshot
		TakesScreenshot takeScreenShot = (TakesScreenshot) driver;
		//storing screenshot on file
		File sourceFile = takeScreenShot.getScreenshotAs(OutputType.FILE);
		//creating destination
		File destFile = new File(System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");
		try {
			//copying screenshot to destination folder
			FileUtils.copyFile(sourceFile, destFile);
			//adding screenshots on both the reports
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "/ScreenShots/" + DateUtil.getTimeStamp() + ".png");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/************************* to click the webElement **********************/
	public void click(WebElement element, String info, String pass) {
		try {
			reportInfo(info, "click");
			//clicks the webelement
			element.click();
			reportPass(pass, "click");
		} catch (Exception e) {
			reportFail(e.getMessage(),"click");
		}
	}


}
