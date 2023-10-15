package com.releases.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class CustomReport {
	//object for the BufferedWriter
	public  BufferedWriter writer;
	//defining date and time
	String dateTime=new SimpleDateFormat("MM_dd_yy_HH_mm_ss").format(new GregorianCalendar().getTime());
	/************************report instance*************************/
	public  BufferedWriter getReportInstance(String testName) {
		//file creation
		File file = new File(System.getProperty("user.dir")+"\\reports\\custom-report\\CustomReport.html");
		//try catch to handle exception
		try {
			writer = new BufferedWriter(new FileWriter(file));
			//html to create table with the details
			writer.write("<html>");
			writer.write("<head><style> a{ font-weight: bold; color: white; padding-top:1em; padding-right:1em; padding-left:1em; padding-bottom:1em; text-decoration: none; background-color: #ccc; color:white; position:relative; width: 50%; }  table, td{ border: 1px solid black; width:300px;  position:relative; display: cell; vertical-align: inherit; horizaontal-align:inherit; table-layout:fixed;} td{color:white; padding:1em;} #myimage {  cursor: pointer;transition: 0.3s; width: 300px; height: 100px;}</style></head>");
			writer.write("<body style=\"background-color:white;\"><h1 style=\"background-color:#8e2335; color:white;\"><center>"+testName+"</center></h1>");
			writer.write("<table style=\" table-layout:fixed; width:100px; position:top;\"><tr><td  style=\"background-color:#f2f2f2; color:Black\">Module:</td><td style=\"background-color:#f2f2f2; color:Black\">"+"Releases"+"</td></tr><tr><td style=\"background-color:#f2f2f2; color:Black\">Cohort-code:</td><td style=\"background-color:#f2f2f2; color:Black\">INTQEA21QE035</td></tr><tr><td style=\"background-color:#f2f2f2; color:Black\">Team-Name:</td><td style=\"background-color:#f2f2f2; color:Black\">Wizard</td></tr><tr><td style=\"background-color:#f2f2f2; color:Black\">Team-Number:</td><td style=\"background-color:#f2f2f2; color:Black\">2</td></tr></table>");
			writer.write("<h3 style=\"color:#8e232f\";style=\"text-align:center\">Test Start time: "+dateTime+"</h3>");
			writer.write("<center><table style=\"width:50%; color:white;\"><center><tr style=\"background-color:#8e232f\"><td style=\"text-align:center\">Method Name</td> <td style=\"text-align:center\">Message</td><td style=\"text-align:center\">Status</td></tr><center></table><center>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return writer;
	}
	/*****************function to enter pass values into report**********************/
	public  void logPass(String comments,String methodName) {
		//try catch to handle exception
		try {
			//to write pass statements on report
			writer.write("<center><table style=\"width:50%; color:Black;\"><center><tr><td style=\"background-color:#f2f2f2; color:black;\">"+methodName+"</td><td style=\"background-color:#f2f2f2; color:black;\">"+comments+"</td><td style=\"background-color:#009900; text-align:center\">Pass</td> </tr><center></table></center>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*****************function to enter fail values into report**********************/
	public  void logFail(String comments,String methodName) {
		//try catch to handle exception
		try {
			//to write fail statements on report
			writer.write("<center><table style=\"width:50%; color:Black;\"><center><tr> <td style=\"background-color:#f2f2f2; color:black;\">"+methodName+"</td> <td style=\"background-color:#f2f2f2; color:black;\">"+comments+"</td><td style=\"background-color:#cc0000; text-align:center\">Fail</td></tr><center></table></center>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*****************function to enter information into report**********************/
	public void logInfo(String comments,String methodName) {
		//try catch to handle exception
		try {
			//to write info statements on report
			writer.write("<center><table style=\"width:50%; color:Black;\"><center><tr><td style=\"background-color:#f2f2f2; color:black;\">"+methodName+"</td> <td style=\"background-color:#f2f2f2; color:black;\">"+comments+"</td><td style=\"background-color:#8e8e23; text-align:center\">Info</td> </tr><center></table></center>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*****************function to flush values into report**********************/
	public  void flushReport() {
		//try catch to handle exception
		try {

			writer.write("<p style=\"color:#9ACD32\">-------End of Report------</p></body></html>");
			writer.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
