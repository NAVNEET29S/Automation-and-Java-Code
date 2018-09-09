package com.baseclass;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;



public class BaseClass {
	public static RemoteWebDriver driver;
	public static Properties prop;
	
	
	public void initialiseBrowser()
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\chromedriver.exe");
		
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		try 
		{
			driver = new RemoteWebDriver(new URL("http://10.38.218.41:4444/wd/hub"),capability);
		}
		catch (MalformedURLException e) 
		{

			e.printStackTrace();
		}
		
		
		//driver = new ChromeDriver();
		
		driver.get("https://fut.digitalx-sit1.svc.vodafoneaws.co.uk/");
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath("//*[text() = 'I agree']//ancestor::button")).click();;
		
				
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
