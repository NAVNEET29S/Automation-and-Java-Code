package testng;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class NewTest {
	
	WebDriver driver = null;
  @Test(dataProvider = "ReturnDataObject")
  public void Test(String n, String s) 
  {	 
	WebElement user = driver.findElement(By.xpath("//input[@type='text']"));
	WebElement pass = driver.findElement(By.xpath("//input[@type='text']//following::input[1]"));
	
	user.clear();
	pass.clear();
	user.sendKeys(n);
	pass.sendKeys(s);
	  try {
		Thread.sleep(1000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
  }

  @DataProvider
  public Object[][] ReturnDataObject() {
	   Object returnData[][] = new Object[2][2];
	   returnData[0][0] = "Navneet";
	   returnData[0][1] = "singh";
	   returnData[1][0] = "Amit";
	   returnData[1][1] = "Choudhary";
	                      
	                       
	   return returnData;                       
	   
	   }
  
  @BeforeClass
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver" , "C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  try {
		Thread.sleep(2000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  driver.get("http://www.facebook.com"); 
  }
  
  @AfterClass
  public void afterTest() {
  	  driver.close();
  }
 
}




