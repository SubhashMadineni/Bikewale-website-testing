package com.bikewale.websiteTest;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class InputFromExel {
	
	public static String GetUsername()throws Exception{
	
	File src = new File("D:\\Users\\subhash\\Desktop\\MySampleMavenProject\\Resources\\ExelFiles\\User Details.xlsx");
	FileInputStream fis = new FileInputStream(src);
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	XSSFSheet User_Credentails = wb.getSheetAt(0);
	String UserName= User_Credentails.getRow(1).getCell(0).getStringCellValue();
	wb.close();
	return UserName;
	}
	
	public static String GetPassword()throws Exception{
		
		File src = new File("D:\\Users\\subhash\\Desktop\\MySampleMavenProject\\Resources\\ExelFiles\\User Details.xlsx");
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet User_Credentails = wb.getSheetAt(0);
		String Password= User_Credentails.getRow(1).getCell(1).getStringCellValue();
		wb.close();
		return Password;
		}

}
