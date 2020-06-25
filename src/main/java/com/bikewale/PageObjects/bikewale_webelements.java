package com.bikewale.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class bikewale_webelements {
	//All the web elements are present here
	
	private static WebElement element = null;
	
	public static WebElement login_button(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[3]"));
		return element;
	}
	
	public static WebElement LoginEmail(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"txtLoginid\"]"));
		return element;
	}
	
	public static WebElement LoginPassword(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"txtPasswd\"]"));
		return element;
		
	}
	
	public static WebElement Submit_Login_button(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"btnLogin\"]"));
		return element;
		
	}
	
	public static WebElement Select_Menu(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"header\"]/div[1]/span"));
		return element;
		
	}

	public static WebElement Select_New_Bikes(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[2]/a/span[1]"));
		return element;
		//*[@id="nav"]/ul/li[2]/ul/li[6]/a
	}
	
	public static WebElement Select_Upcoming_Bikes(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"nav\"]/ul/li[2]/ul/li[6]/a"));
		return element;
		
	}
	
	public static WebElement Select_All_Brands(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"makeFilter_chosen\"]/a/span"));
		return element;
		
	}
	
	public static WebElement Select_Honda(WebDriver driver) {
		element = driver.findElement(By.xpath("//*[@id=\"makeFilter_chosen\"]/div/ul/li[2]"));
		return element;
		
	}
	
	
	

}
