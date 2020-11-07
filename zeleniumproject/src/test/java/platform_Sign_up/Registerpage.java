package platform_Sign_up;

import org.testng.annotations.Test;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class Registerpage{
	
	public static WebDriver driver;
	
	@BeforeTest
	public void openBrowser(){
		
	  System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
	  driver= new ChromeDriver();
	  driver.get("https://cai.tools.sap/");
	    
	  String title= driver.getTitle();	  
	  System.out.println(title);
	  Assert.assertEquals(title, "Log In And Build Your Bot | SAP Conversational AI");
	  
	  ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Reports/testresults.html");	
      ExtentReports extent = new ExtentReports(); 
      extent.attachReporter(reporter);
	  ExtentTest logger=extent.createTest("Platform Signup");
      logger.log(Status.PASS, "Title verified");
      extent.flush();
      
	}

	@Test
	public void newRegistration() throws Throwable
	{
		
	
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[text()='Sign up']")).click();
		 
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("//div[text()='OK']")).click();
		 
		 Thread.sleep(3000);
		 driver.switchTo().frame("IDS_UI_Window");
		 

		  FileLibrary fil= new FileLibrary();
		 
		  Thread.sleep(1000);
		  String FirstName = fil.getCellData("./Data/testdata.xlsx", "Sheet1", 0, 0);
		  driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys(FirstName);
		  
		  Thread.sleep(1000);
		  String LastName = fil.getCellData("./Data/testdata.xlsx", "Sheet1", 1, 0);
		  driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys(LastName);
		  
		  Thread.sleep(1000);
		  String email = fil.getCellData("./Data/testdata.xlsx", "Sheet1", 2, 0);
		  driver.findElement (By.xpath("//input[@id='mail']")).sendKeys(email);
		  
		  Thread.sleep(1000);
		  String password = fil.getCellData("./Data/testdata.xlsx", "Sheet1", 3, 0);
		  driver.findElement(By.xpath("//input[@id='newPasswordInput']")).sendKeys(password);
		  
		  Thread.sleep(1000);
		  String retypePWD = fil.getCellData("./Data/testdata.xlsx", "Sheet1", 4, 0);
		  driver.findElement (By.xpath("//input[@id='retypeNewPasswordInput']")).sendKeys(retypePWD);
		  
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name='pdAccept']")).click();
		  
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//input[@name='touAccept']")).click();
		  
		  Thread.sleep(1000);
		  driver.findElement(By.xpath("//button[@class='ids-button ids-button--primary']")).click();
		 	 
	}
	
	@AfterTest
    public void  closeBrowser() throws InterruptedException
    {
		Thread.sleep(2000);
		driver.close();
    }
}
