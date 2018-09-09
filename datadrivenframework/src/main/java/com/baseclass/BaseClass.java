package com.baseclass;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import ExtentReport.ExtentReport;

public class BaseClass {
	public static WebDriver driver;
	public static Properties prop;
    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;
    
    
	
	public void initialiseBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\chromedriver.exe");
		driver = new ChromeDriver();	
		driver.get(prop.getProperty("url"));
         driver.manage().window().maximize();	
		driver.manage().deleteAllCookies();	
		try {
		driver.findElement(By.xpath("//*[text() = 'I agree']//ancestor::button")).click();	
		    }	
		catch(NoSuchElementException e)
		{

			driver.navigate().refresh();
			driver.findElement(By.xpath("//*[text() = 'I agree']//ancestor::button")).click();
		}
	}
	
	public void IntialiseExtentReport()
	{
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//extentreport.html");
		extentReports.attachReporter(extentHtmlReporter);
		extentReports.setSystemInfo("OS", "Win10");
		extentReports.setSystemInfo("Machine", "E0249432");
		extentReports.setSystemInfo("Env", "T1/E4");
		extentReports.setSystemInfo("browwser", "Chrome");
		
	}

	public void initialiseProperty()
	{
		
		try {
			prop = new Properties();
			FileInputStream input = new FileInputStream("C:/Users/SinghN3/eclipse-workspace/datadrivenframework/src/main/java/com/config/cofig.properties");
			
			prop.load(input);
		   } 
		
		catch (IOException e) {
			
			e.printStackTrace();
					
			
		}
		
		
	}

	
	

}
