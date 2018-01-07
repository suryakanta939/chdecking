package com.toolsqa.checkData;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.toolsQa.commonUtils.ReadExcelData;
import com.toolsQa.commonUtils.WaitForWebPage;

public class ReadData {
	WebDriver driver;
  @Test(dataProvider="readData")
  public void f(String un,String pwd,String email) throws EncryptedDocumentException, InvalidFormatException, IOException {
//       String data=ReadExcelData.getSingleData("surya", "Details", 4, 2);
//       System.out.println(data);
	  if(un==null||pwd==null||email==null){
		  
	  }else{
		  System.out.println(un);
	       System.out.println(pwd);
	       System.out.println(email);
	  }
       
       
	  }
  @DataProvider
  public Object[][] readData() throws EncryptedDocumentException, InvalidFormatException, IOException{
	  File f=new File("TestData");
	  File fs=new File(f,"surya.xlsx");
	  FileInputStream fis=new FileInputStream(fs.getAbsolutePath());
		 Workbook wb= WorkbookFactory.create(fis);
		Sheet sh= wb.getSheet("Details");
		int rn=sh.getLastRowNum();
		System.out.println(rn);
		Object[][] obj=new Object[rn+1][3];
		for(int i=1;i<rn+1;i++){
			Row rw=sh.getRow(i);
			for(int j=0;j<3;j++){
					 String data=rw.getCell(j).getStringCellValue();
					 obj[i][j]=data;
					  
				}
		}
		return obj;
	  }
  }
  


