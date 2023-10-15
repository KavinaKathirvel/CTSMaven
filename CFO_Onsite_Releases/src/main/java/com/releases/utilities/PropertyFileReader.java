package com.releases.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileReader {
public static Properties prop;
	
	/*********************************to read the properties file*******************************/
	public PropertyFileReader()
	{
		//try catch to handle exception
	try{
	if(prop==null){
		prop = new Properties();
		FileInputStream file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
			prop.load(file);
		}}
	catch (Exception e) {
			e.printStackTrace();
		}
	}

	/************************function to return the browser name from the properties file*******************************/

	public String getBrowserName() 
	{
		return prop.getProperty("BROWSER");
	}
	/************************function to return the application url from the properties file*******************************/
	public String getUrl() 
	{
		return prop.getProperty("URL");
	}
		
	



}
