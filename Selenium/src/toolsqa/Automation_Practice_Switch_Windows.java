package toolsqa;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.Assertion;

public class Automation_Practice_Switch_Windows {


	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.manage().window().maximize();

driver.get("http://toolsqa.com/automation-practice-switch-windows/");

String parentWindow = driver.getWindowHandle();
System.out.println("in the parent window"+ driver.switchTo().window(parentWindow).getCurrentUrl());
driver.findElement(By.id("button1")).click();
driver.findElement(By.xpath("//*[text()='New Message Window']")).click();;
driver.findElement(By.xpath("//* [text()='New Browser Tab']")).click();
//driver.findElement(By.xpath("//button[contains(text() ,'New Browser Tab')]"));
Set<String> childHandle = driver.getWindowHandles();

for(String handle: childHandle)
{
	if(!handle.equals(parentWindow))
	//Thread.sleep(100);
 driver.switchTo().window(handle).close();

}

driver.switchTo().window(parentWindow);

WebDriverWait wait = new WebDriverWait(driver, 5);

wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));



	}

}
