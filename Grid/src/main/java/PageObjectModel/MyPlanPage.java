package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;
import com.util.HandleFrame;
import com.util.Payment;

public class MyPlanPage extends BaseClass{
	
		
	@FindBy(xpath = "//*[text() = '6GB']//ancestor::div[3]")
	WebElement dataBundle06GB;
	
	@FindBy(xpath = "//*[text() = '15GB']//ancestor::div[3]")
	WebElement dataBundle15GB;
	
	@FindBy(xpath = "//*[text() = '45GB']//ancestor::div[3]")
	WebElement dataBundle45GB;
	
	@FindBy(xpath = "//*[text()='Cancel']//preceding::button[@class='button-primary--32J2U size-small--3crwC has-chevron--2wUUT standard--2a2JQ shadow--3dzTD m-top t-dark']")
	WebElement changePlan;

	@FindBy(xpath = "//*[text()='My Plan']")
	WebElement myPlan;

	@FindBy(xpath = "//span[text()='Add plan']")
	WebElement addPlan;
	
	@FindBy(xpath = "\"//*[text()='Select this plan']")
	WebElement selectThisPlan;
	
	public int counter=0;
	
	public  MyPlanPage()
	{
		PageFactory.initElements(driver, this);
	}
	

	
	public void changePlan()
	{
	
	myPlan.click();
	
	
		if(dataBundle06GB.isSelected()==true)
			{
			System.out.println("in 6GB");
			dataBundle15GB.click();
			changePlan.click();
			}	
		else if (dataBundle15GB.isSelected()==true)
		{
			System.out.println("in 15 gb");
			dataBundle45GB.click();
			changePlan.click();
		}
		else if(dataBundle45GB.isSelected()==true)
		{
			System.out.println("in 45GB");
			dataBundle45GB.click();	
			changePlan.click();
		}
	counter++;		
  }

	
	public void BuyNewPlan(String bundle) throws InterruptedException
	{
		if(bundle.equalsIgnoreCase("06GB"))
		{
			dataBundle06GB.click();
			selectThisPlan.click();
			addPlan.click();
			Thread.sleep(4000);
			 HandleFrame.SwitchToFrame();
			 Payment.AddCardDetails();;	
			
		{
		
		if(bundle.equalsIgnoreCase("15GB"))
		{
			dataBundle15GB.click();
			selectThisPlan.click();
			addPlan.click();
			Thread.sleep(4000);
			 HandleFrame.SwitchToFrame();
			 Payment.AddCardDetails();;	
		}
		if(bundle.equalsIgnoreCase("45GB"))
		{
			 dataBundle45GB.click();
			 selectThisPlan.click();
			 addPlan.click();
			 Thread.sleep(4000);
			 HandleFrame.SwitchToFrame();
			 Payment.AddCardDetails();;	
		}
			
		
	
	
	
}
}
	}}
