package PageObjectModel;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;

import com.baseclass.BaseClass;
import com.util.HandleFrame;
import com.util.Payment;
import com.util.ScrollPageDown;

public class MyAccountPage extends BaseClass{
		
	@FindBy(xpath= "//input[@id='confirmCsc']")
	public static WebElement cvv;
	
	
	@FindBy(xpath= "//input[@id='btnSubmit']")
	public static WebElement submitBtn;
	
	@FindBy(xpath= "//input[@id='btnCancel']")
	public WebElement cancelBtn;
	
	@FindBy(xpath= "//input[@id='cardNumber']")
	public static WebElement cardnumberInputText;
	

	@FindBy(xpath= "//*[text()='100 International Minutes']//following::div[1]")
	public WebElement add100IntMin;
	
	@FindBy(xpath= "//*[text()='Add this extra']//ancestor::button")
	public WebElement addThis100IntMin;
	
	
	@FindBy(xpath= "//*[text()='Endless Music Pass']//following::div[1]")
	public WebElement addMusicPass;
	

	@FindBy(xpath= "//*[text()='Add this pass']//ancestor::button")
	public WebElement addThisMusicPass;
	

	@FindBy(xpath= "//*[text()='1GB Data Extra']//following::div[1]")
	public WebElement add1GbExtra;
	
	@FindBy(xpath= "//*[text()='Endless Video Pass']//following::div[1]")
	public WebElement addVideoPass;
	
	@FindBy(xpath= "//*[text()='Add this pass']//ancestor::button")
	public WebElement addThisVideoPass;
	
	@FindBy(xpath= "//*[text()='Endless Music Pass']//following::button[@class='desktop-action--32a29 action--kmgo5' and text()='Remove Pass']")
	public WebElement removeMusicPass;
	
	@FindBy(xpath= "//*[text()='Endless Video Pass']//following::button[@class='desktop-action--32a29 action--kmgo5' and text()='Remove Pass']")
	public WebElement removeVideoPass;
	
	@FindBy(xpath= "//button[text()='Remove Extra']")
	public WebElement remove100IntMin;
	
	@FindBy(xpath= "//*[text()='Remove pass']//ancestor::button")
	public WebElement confirmRemoveVideoPass;
	
	@FindBy(xpath= "//*[text()='Remove pass']//ancestor::button")
	public WebElement confirmRemoveMusicPass;
	
	@FindBy(xpath= "//*[text()='Remove pass']")
	public WebElement confirmRemove100IntMin;
	
	@FindBy(xpath= "//*[text()='Endless Music Pass']//following::button[@class='desktop-action--32a29 action--kmgo5' and text()='Cancel Change']")
	public WebElement cancelChangeMusicPass;
	
	@FindBy(xpath= "//*[text()='Endless Video Pass']//following::button[@class='desktop-action--32a29 action--kmgo5' and text()='Cancel Change']")
	public WebElement cancelChangeVideoPass;
	
	@FindBy(xpath= "//*[text()='Endless Music Pass']//preceding::button[@class='desktop-action--32a29 action--kmgo5' and text()='Cancel Change']")
	public WebElement cancelChange100IntMin;
	

	
	
	
	public MyAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Add100IntMin() throws Throwable
	{
		try {
		if(remove100IntMin.isDisplayed())
		{
			throw new SkipException("You can only remove this product on this account ... select a different user");
		}
		}
		
		catch(NoSuchElementException e)
		{
			try {
			if(cancelChange100IntMin.isDisplayed())
			
				throw new SkipException("You can do a cancel change on this account ... select a different user");
			}
			
			catch(NoSuchElementException e1)
			{
				
					add100IntMin.click();	
					ScrollPageDown.fnScroll(500);
					Thread.sleep(2000);
					addThis100IntMin.click();		
			        HandleFrame.SwitchToFrame();     
			        Payment.AddCardDetails();	
				
			}

		}
	}
	
	public void AddMusicPass() throws Throwable
	{
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ScrollPageDown.fnScroll(800);
		try {
		if(removeMusicPass.isDisplayed())
		
			throw new SkipException("Already music pass is Added to the customer. Please remove first then add else take a diferent user");
		}
		
		catch(Exception e) {
			
			try {
		 if(cancelChangeMusicPass.isDisplayed())
		
			throw new SkipException("First cancel channge the plan then remove it");
		}
			
			catch(Exception e1)
			{
		{
		addMusicPass.click();
		addThisMusicPass.click();		
		HandleFrame.SwitchToFrame();	
		}}}
	}
		
	
  public void AddVideoPass() throws InterruptedException   {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		try {
			 if(removeVideoPass.isDisplayed())
			  {
					throw new SkipException("Already Video pass is Added to the customer. Please remove first then add else take a diferent user");

			  }
			}
			
			catch(NoSuchElementException e)
			{
				try {
				if(cancelChangeVideoPass.isDisplayed())
				
					throw new SkipException("first cancel remove video pass then try to add this ");
			        }
				
				catch(NoSuchElementException e1)
				{
					
					   addVideoPass.click();
					  addThisVideoPass.click();
					  Thread.sleep(2000);
					  HandleFrame.SwitchToFrame();
					  Payment.AddCardDetails();
				}

			}
	  
    
    }
  
    
	
	
	public void Add1GBExtra() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ScrollPageDown.scrollDownPageByPixel(0, 1500);
		add1GbExtra.click();
		if(driver.findElement(By.xpath("//*[@class='spring--3enHX m-vertical-small p-horizontal-small s-medium']//h3")).getText().contains("You've got extra data"))
		{
			throw new SkipException("Already 1GB data is Added to the customer. Please remove first then add else take a diferent user");
			
		}
		
		else {
	    addThis100IntMin.click();
	    HandleFrame.SwitchToFrame();
	    Payment.AddCardDetails();
		}
	    
	}
	
	public void RemoveVideoPass() throws InterruptedException
	{
		if(addVideoPass.isDisplayed())
		{
			throw new SkipException("you dont havr 1GB added into yourt account");

		}
		
		else if(cancelChangeVideoPass.isDisplayed())
		{
			throw new SkipException("Cancel change the Video pass first");
		}
		else
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ScrollPageDown.fnScroll(2000);
		removeVideoPass.click();
		}}
	
	public void RemoveMusicPass() throws InterruptedException
	{
		if(addMusicPass.isDisplayed())
		{
			throw new SkipException("you dont havr 1GB added into yourt account");

		}
		else if(cancelChangeMusicPass.isDisplayed())
		{
			throw new SkipException("Cancel change the Music pass first");
		}
		else
		{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ScrollPageDown.fnScroll(2000);
		removeMusicPass.click();
		confirmRemoveMusicPass.click();		
    }}
	
	public void Remove100IntMin() {
		
		if(add100IntMin.isDisplayed())
		{
			throw new SkipException("you need to add 100 int  min first then you can only remove");
			
		}
		
		else if(cancelChange100IntMin.isDisplayed())
		{
			throw new SkipException("");
		}
		remove100IntMin.click();
		confirmRemove100IntMin.click();
	}
	

	
}
