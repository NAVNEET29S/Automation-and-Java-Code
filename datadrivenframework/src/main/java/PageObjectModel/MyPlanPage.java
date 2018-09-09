package PageObjectModel;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.SkipException;
import com.baseclass.BaseClass;
import com.util.HandleFrame;
import com.util.Payment;
import com.util.ScrollPageDown;

public class MyPlanPage extends BaseClass{
	
		
	@FindBy(xpath = "//*[text() = '6GB']//ancestor::div[3]")
	WebElement dataBundle06GB;
	
	@FindBy(xpath = "//*[text() = '15GB']//ancestor::div[3]")
	WebElement dataBundle15GB;
	
	@FindBy(xpath = "//*[text() = '45GB']//ancestor::div[3]")
	WebElement dataBundle45GB;
	
	@FindBy(xpath = "//span[text()='Change plan']")
	WebElement changePlan;
	
	@FindBy(xpath = "//span[text()='Change plan']//ancestor::button[@class='button-primary--32J2U size-small--3crwC has-chevron--2wUUT standard--2a2JQ shadow--3dzTD m-top t-dark']")
	WebElement confirmChangePlan;

	@FindBy(xpath = "//*[text()='My Plan']")
	WebElement myPlan;

	@FindBy(xpath = "//span[text()='Add plan']")
	WebElement addPlan;
	
	@FindBy(xpath = "//*[text()='Select this plan']")
	WebElement selectThisPlan;
	
	@FindBy(xpath = "//*[text()='Cancel change plan']//ancestor::button[@class='button-primary--32J2U size-small--3crwC has-chevron--2wUUT standard--2a2JQ shadow--3dzTD m-top t-dark']")
	WebElement confirmCancelChangePlan;
	

	@FindBy(xpath = "//*[text()='Cancel stop plan']")
	WebElement cancelStopPlan;
	
	public int counter=0;
	
	public  MyPlanPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	public void changePlan() throws Throwable
	{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	myPlan.click();
	
	
		if(dataBundle06GB.getAttribute("class").equalsIgnoreCase("radio-container--KwPtF selected--1i-a5"))
			{
			System.out.println("in 6GB");
			dataBundle15GB.click();
			if(driver.findElement(By.xpath("//*[@class='button-primary--32J2U size-small--3crwC standard--2a2JQ shadow--3dzTD t-dark']")).isEnabled())
			{
				changePlan.click();
				confirmChangePlan.click();
				Thread.sleep(2000);
			}
			
			else
			{
				dataBundle45GB.click();
				if(driver.findElement(By.xpath("//*[@class='button-primary--32J2U size-small--3crwC standard--2a2JQ shadow--3dzTD t-dark']")).isEnabled())
				{
					changePlan.click();
					confirmChangePlan.click();
					Thread.sleep(2000);
				}
				

			}
			}
				
		else if(dataBundle45GB.getAttribute("class").equalsIgnoreCase("radio-container--KwPtF selected--1i-a5"))
		{
			System.out.println("in 15 gb");
			dataBundle45GB.click();
			
			if(driver.findElement(By.xpath("//*[@class='button-primary--32J2U size-small--3crwC standard--2a2JQ shadow--3dzTD t-dark']")).isEnabled())
			{
				changePlan.click();
				confirmChangePlan.click();
				Thread.sleep(2000);
			}
			
			else
			{
				dataBundle06GB.click();
				if(driver.findElement(By.xpath("//*[@class='button-primary--32J2U size-small--3crwC standard--2a2JQ shadow--3dzTD t-dark']")).isEnabled())
				{
					changePlan.click();
					confirmChangePlan.click();
					Thread.sleep(2000);
				}
				
			}
			
		}
		else if(dataBundle45GB.getAttribute("class").equalsIgnoreCase("radio-container--KwPtF selected--1i-a5"))
		{
			System.out.println("in 45GB");
			dataBundle15GB.click();	
			if(driver.findElement(By.xpath("//*[@class='button-primary--32J2U size-small--3crwC standard--2a2JQ shadow--3dzTD t-dark']")).isEnabled())
			{
				changePlan.click();
				confirmChangePlan.click();
				Thread.sleep(2000);
			}
			
			else
			{
				dataBundle06GB.click();
				if(driver.findElement(By.xpath("//*[@class='button-primary--32J2U size-small--3crwC standard--2a2JQ shadow--3dzTD t-dark']")).isEnabled())
				{
					changePlan.click();
					confirmChangePlan.click();
					Thread.sleep(2000);
				}
				

			}
			counter++;	
		}
		
		
  }

	
	public void BuyNewPlan(String bundle) throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(bundle.equalsIgnoreCase("06GB"))
		{
			dataBundle06GB.click();
			selectThisPlan.click();
			addPlan.click();
			 HandleFrame.SwitchToFrame();
			 Payment.AddCardDetails();	
			
		{
		
		if(bundle.equalsIgnoreCase("15GB"))
		{
			dataBundle15GB.click();
			selectThisPlan.click();
			addPlan.click();
			 HandleFrame.SwitchToFrame();
			 Payment.AddCardDetails();
		}
		if(bundle.equalsIgnoreCase("45GB"))
		{
			 dataBundle45GB.click();
			 selectThisPlan.click();
			 addPlan.click();
			 HandleFrame.SwitchToFrame();
			 Payment.AddCardDetails();	
		}
			
		
	
	
	
		}}
  }
	
 
	
	public void CancelChangePlan() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		myPlan.click();
		ScrollPageDown.fnScroll(300);
		
		try {
		if(cancelStopPlan.isEnabled()) {
			
			throw new SkipException("Cancel Change Plan is not possible on this Customer as Change plan is still pending");
		}}
		
		catch(NoSuchElementException e) {
			{
				driver.findElement(By.xpath("//*[text()='Cancel change plan']")).click();
				confirmCancelChangePlan.click();
				
			}
			
		}
	
		
		
	
		}
     
		
		
	
	

}
