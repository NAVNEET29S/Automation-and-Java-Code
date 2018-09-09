package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class DataProvider {
	WebDriver driver = null;
	
	 @BeforeTest
	  public void beforeTest() throws InterruptedException {
		 System.setProperty("webdriver.chrome.driver" , "C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  Thread.sleep(2000);
		  driver.get("http://www.facebook.com"); 
	  }
	 
  @Test(dataProvider = "returnData")
  public void Test(String n, String s) 
  {	 
	WebElement user = driver.findElement(By.xpath("//input[@type='text']"));
	WebElement pass =  driver.findElement(By.xpath("//input[@type='text']//following::input[1]"));
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
  public Object[][] ReturnDataObject() {
   Object[][] returnData = new Object[2][2];
   returnData[0][0] = "Navneet";
   returnData[0][1] = "singh";
   returnData[1][0] = "Amit";
   returnData[1][1] = "Choudhary";
                      
                       
   return returnData;                       
   
   }
   


 

  @AfterTest
  public void afterTest() {
	 driver.close();
  }

}
