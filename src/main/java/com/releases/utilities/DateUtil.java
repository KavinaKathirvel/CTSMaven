package com.releases.utilities;

import java.util.Date;

public class DateUtil {
	/***************function to get the time stamp**************/
	public static String getTimeStamp(){
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}


}
