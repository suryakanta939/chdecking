package com.toolsqa.checkData;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.toolsQa.baseclass.InvokeBrowser;
import com.toolsQa.commonUtils.WaitForWebPage;
import com.toolsQa.pageClass.AutomationForm;
import com.toolsQa.reportclass.ExtentFactory;
import com.toolsQa.screenShot.ScreenShot;

public class Opening {
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;
  @Test
  public void toolsQa() {
	  report=ExtentFactory.generateReport();
	  test=report.startTest("checking newly");
	  driver=InvokeBrowser.openBrowser("firefox");
	  test.log(LogStatus.INFO, "Browser is opened");
	  driver.get("http://demoqa.com/registration/");
	  test.log(LogStatus.INFO, "entered the url");
	  driver.manage().window().maximize();
	  WaitForWebPage.implyCityWait(driver, 10);
	  AutomationForm af=new AutomationForm(driver, test);
	  af.fillingUpForm();
	  
  }
  @AfterMethod
  public void executingAfter(ITestResult result) throws IOException{
	  if(result.getStatus()==result.SUCCESS){
		  test.log(LogStatus.PASS, "test case got pass");
	  }else if(result.getStatus()==result.SKIP){
		  test.log(LogStatus.SKIP, "test case got skipped");
	  }
	  else if(result.getStatus()==result.FAILURE){
		  String imagepath=ScreenShot.takeScreenShot(driver, result.getName());
		  test.log(LogStatus.FAIL,test.addScreenCapture(imagepath),"test case got fail");
		  
	  }
  }
  @AfterClass
  public void tearDown(){
	  test.assignAuthor("suriyakishoore");
	  report.endTest(test);
	  report.flush();
  }
}
