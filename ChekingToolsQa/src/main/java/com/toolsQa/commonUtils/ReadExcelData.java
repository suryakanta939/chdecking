package com.toolsQa.commonUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {
	
	public static String getSingleData(String excelFileName,String sheetName,int rowNo,int cellNo) throws EncryptedDocumentException, InvalidFormatException, IOException{
		File f=new File("TestData");
		File fs=new File(f,"\\"+excelFileName+".xlsx");
		System.out.println(fs.getAbsolutePath());
		//"C:\\Users\\surya\\Desktop\\Data.xlsx"
		FileInputStream fis=new FileInputStream(fs.getAbsolutePath());
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row rw=sh.getRow(rowNo);
		String data=rw.getCell(cellNo).getStringCellValue();
		return data;
		
	}
	
	public static Object[][] getAllData(String exceFileName,String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		File f=new File("TestData");
		File fs=new File(f,"\\"+exceFileName+".xlsx");
		FileInputStream fis=new FileInputStream(fs.getAbsolutePath());
		Workbook wb =WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int totalNoOfRow=sh.getLastRowNum();
		Object[][] obj=new Object[totalNoOfRow+1][3];
		for(int i=1;i<=totalNoOfRow+1;i++){
			Row rw=sh.getRow(i);
			for(int j=0;j<3;j++){
				String data=rw.getCell(j).getStringCellValue();
				if(data==null){
					
				}else{
					obj[i][j]=data;
				}
				
			}
		}
		return obj;
	}

}
