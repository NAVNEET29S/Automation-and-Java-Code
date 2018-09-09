package SeleniumRemoteWebDriver.Grid;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumGrid {
 
     RemoteWebDriver driver;
   
	@BeforeMethod
	public void startBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\chromedriver.exe");
		DesiredCapabilities capability = DesiredCapabilities.chrome();
		try 
		{
			driver = new RemoteWebDriver(new URL("http://10.38.218.41:4444/wd/hub"),capability);
		}
		catch (MalformedURLException e) 
		
		{

			e.printStackTrace();
		}
		
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		
	}
	
	@Test
	public void remoteWebDriver()
	{
		driver.get("http://www.gmail.com");
		
		
	}
	
	
}
