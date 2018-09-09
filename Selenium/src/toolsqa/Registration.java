package toolsqa;

import org.testng.annotations.Test;

import testng.AnnotationSequenceChecking;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.*;

public class Registration extends AnnotationSequenceChecking {
;
	  @BeforeTest
	  public void beforeTest() {
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\chromedriver.exe" );
		//  System.setProperty("webdriver.ie.driver","C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\IEDriverServer.exe");
		  driver = new ChromeDriver();
		 // driver = new InternetExplorerDriver();
		  			
	  }
	 
  WebDriver driver;
 
 @Test
  public void Registation() {
	 
	 driver.get("http://demoqa.com/registration/");
	  driver.findElement(By.id("name_3_firstname")).sendKeys("Navneet");
	  driver.findElement(By.id("name_3_lastname")).sendKeys("Singh");
	  driver.findElement(By.xpath("//input[@value ='married']")).click();
	  driver.findElement(By.xpath("//input[@value ='cricket ']")).click();
	    
	  Select select = new Select(driver.findElement(By.id("dropdown_7")));
	  select.selectByValue("India");
	  Select select1 = new Select(driver.findElement(By.id("dd_date_8")));
	  select1.selectByValue("29");
	  Select select2 = new Select(driver.findElement(By.id("mm_date_8")));
	  select2.selectByValue("1");
	  Select select3 = new Select(driver.findElement(By.id("yy_date_8")));
	  select3.selectByValue("1992");
	  
	   
	    }

  @AfterTest
  public void afterTest() {
	 // driver.close();
  }

}
