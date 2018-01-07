package com.toolsQa.reportclass;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;

public class ExtentFactory {
	
	static ExtentReports report;
	public static ExtentReports generateReport(){
		File f=new File("Report");
		File fs=new File(f,"");
		report=new ExtentReports(fs.getAbsolutePath()+"\\checkingQa.html",false);
		return report;
	}

}
