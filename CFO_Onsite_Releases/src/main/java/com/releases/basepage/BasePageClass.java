package com.releases.basepage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.releases.utilities.CustomReport;
import com.releases.utilities.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePageClass {
	public WebDriver driver;//driver object 
	public ExtentReports report = ExtentReportManager.getReportInstance();//report object to get report instance
	public ExtentTest logger;//logger to log the status in the report
	public static WebDriverWait wait;
    public static CustomReport customReport;//customreport object
   
	/***************************function to invoke browser*******************************/
	public void invokeBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			//WebDriverManager downloads and sets the browser driver binaries 
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");  //Disables all notifications
			options.setAcceptInsecureCerts(true);  //Handles insecure website certification
			options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.ACCEPT); //Handles and accept the unexpected alert
			driver = new ChromeDriver(options);  //Initiallizing the driver with chrome
		}
		else if(browser.equalsIgnoreCase("msedge")){
			//download and set the browser driver binaries 
			WebDriverManager.edgedriver().setup();
			//Initializing the driver with microsoft eddge
		    driver = new EdgeDriver();
		}
		
		driver.manage().window().maximize();  //Maximizes the window
		driver.manage().deleteAllCookies();   //Delete all the cookies
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //Defining Implicit Wait for the driver
	}
	

	
}
