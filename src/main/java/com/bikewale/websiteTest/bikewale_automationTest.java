package com.bikewale.websiteTest;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.bikewale.PageObjects.bikewale_webelements;
 
public class bikewale_automationTest {
	WebDriver driver =null;
	WebElement element = null;

  @Test
  public void SetTheDriver() {

	String url = "https://www.bikewale.com/";
	
	
	//for firefox
	//System.setProperty("webdriver.gecko.driver", "D:\\Users\\subhash\\eclipse-workspace\\seleniumtest\\Drivers\\geckodriver.exe");
	//driver = new FirefoxDriver();
	
	//for edge
	//System.setProperty("webdriver.edge.driver", "D:\\Users\\subhash\\eclipse-workspace\\seleniumtest\\Drivers\\msedgedriver.exe");
	//driver = new EdgeDriver();
	
	
	// for chrome 
	System.setProperty("webdriver.chrome.driver", "D:\\Users\\subhash\\eclipse-workspace\\seleniumtest\\Drivers\\chromedriverV83.exe");
	
	driver = new ChromeDriver();
	
	driver.manage().window().maximize();					//To Maximize the Browser Window
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get(url);							//To Navigate To the browser url
	try {
	Assert.assertTrue(driver.getTitle().contains("New Bikes, New Scooters, Used Bikes, Buy a Bike - BikeWale"),"Page title not matched or Problem in loading url page");
	}catch(Exception e) {
	
		System.out.println("Quiting the Browser Reason: Page Navigation Failed");
		closeBrowser();
		}
	}
  @Test(priority = 1,description = "User Login")
  public void LoginTest() throws Exception {	  
	  
	  bikewale_webelements.login_button(driver).click();
	  
	  Assert.assertTrue(driver.getTitle().contains("User Login - BikeWale"));			//To check weather or not Navigated to Login Web page
	  
	  bikewale_webelements.LoginEmail(driver).sendKeys(InputFromExel.GetUsername());
	  bikewale_webelements.LoginPassword(driver).sendKeys(InputFromExel.GetPassword());
	  bikewale_webelements.Submit_Login_button(driver).click();
	  
	  Assert.assertTrue(driver.getTitle().contains("New Bikes, New Scooters, Used Bikes, Buy a Bike - BikeWale"));			//To check weather or not Navigated to AfterLogin Web page

  }
  @Test(priority = 2 , description = "Fectching the details of Upcoming bikes")
  public void Fetch_Upcoming_Bikes() {
	  
	  bikewale_webelements.Select_Menu(driver).click();
	  
	  bikewale_webelements.Select_New_Bikes(driver).click();
	  
	  bikewale_webelements.Select_Upcoming_Bikes(driver).click();
	  
	  Assert.assertTrue(driver.getTitle().contains("Upcoming Bikes in India | Expected Launches in 2020 - 2021 - BikeWale"));			//To check weather or not Navigated to Upcoming Bikes Page

	  bikewale_webelements.Select_All_Brands(driver).click();
	  
	  bikewale_webelements.Select_Honda(driver).click();
  }
  
  @Test(priority = 4)
	public void StoringData() {
		
		System.out.println("The 5 Bikes names are : ");
		
		//Fetch All the Products Text
		List<WebElement> list_of_products = driver.findElements(By.xpath("//*[@id=\"upcoming-bikes\"]/div[1]/div[1]/div[2]/ul/li[1]/a/div[2]"));
		List<WebElement> list_of_products_price = driver.findElements(By.xpath("//*[@id=\"upcoming-bikes\"]/div[1]/div[1]/div[2]/ul/li[1]/a/div[2]/span[4]"));
		
		//Use of HashMaop to store Products and Their prices(after conversion to Integer)
		String product_name;
		String product_price;
		int int_product_price;
		HashMap<Integer, String> map_final_products = new HashMap<Integer,String>();
		for(int i=0;i<list_of_products.size();i++) {
			product_name = list_of_products.get(i).getText();//Iterate and fetch product name
			product_price = list_of_products_price.get(i).getText();//Iterate and fetch product price
			product_price = product_price.replaceAll("[^0-9]", "");//Replace anything wil space other than numbers
			int_product_price = Integer.parseInt(product_price);//Convert to Integer
			map_final_products.put(int_product_price,product_name);//Add product and price in HashMap
		}
		Reporter.log( map_final_products.toString() + "<br>",true);
	}
  @Test(priority = 3)
  public void closeBrowser() {
	  System.out.println("Closing the Browser");
	  driver.close();
  }
}


