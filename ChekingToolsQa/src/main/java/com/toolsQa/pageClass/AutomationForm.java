package com.toolsQa.pageClass;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AutomationForm {
  /*
   * here i am going to store all the x-path
   * */
	static WebDriver driver;
	static ExtentTest test;
	static List<WebElement> elements;
	
	@FindBy(id="name_3_firstname")
	WebElement firstName;
	
	@FindBy(id="name_3_lastname")
	WebElement lastName;
	
//	@FindBy(id="sex-0")
//	WebElement male;
//	
//	@FindBy(xpath="//input[@name='profession']")
//	List<WebElement> profession;

	@FindBy(xpath="//input[@type='radio']")
	List<WebElement> maritialStatus;
	
	
	public AutomationForm(WebDriver driver,ExtentTest test){
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	public static List<WebElement> chekingSex(){
		elements=driver.findElements(By.xpath("//input[@name='sex']"));
		return elements;
	}
//	public void chooseprofession(int no){
//		System.out.println(profession.size());
//		for(int i=0;i<profession.size();i++){
//			System.out.println(profession.get(i).getAttribute("value"));
//			if(i==no){
//				profession.get(i).click();
//			}
//		}
//	}
	
	public void marriageStatus(String status){
		for(int i=0;i<maritialStatus.size();i++){
			String actualStatus=maritialStatus.get(i).getAttribute("value");
			if(actualStatus.equals(status)){
				maritialStatus.get(i).click();
			}
		}
	}
	public void fillingUpForm(){
		firstName.sendKeys("suriya");
		test.log(LogStatus.INFO, "entered the firstName");
		lastName.sendKeys("kishoore");
		test.log(LogStatus.INFO, "entered the lastName");
		marriageStatus("married");
		test.log(LogStatus.INFO, "selecting the sex type");
	}
}
