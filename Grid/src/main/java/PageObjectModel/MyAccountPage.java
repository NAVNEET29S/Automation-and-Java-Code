package PageObjectModel;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;
import com.util.HandleFrame;
import com.util.Payment;
import com.util.ScrollPageDown;

public class MyAccountPage extends BaseClass{
	
	public int a =10;

	@FindBy(xpath= "//*[text()='Add this extra']//ancestor::button")
	public WebElement addThisExtra;
	

	@FindBy(xpath= "//*[text()='100 International Minutes']//following::div[1]")
	public WebElement addExtra;
	
	
	@FindBy(xpath= "//input[@id='confirmCsc']")
	public static WebElement cvv;
	
	
	@FindBy(xpath= "//input[@id='btnSubmit']")
	public static WebElement submitBtn;
	
	@FindBy(xpath= "//input[@id='btnCancel']")
	public WebElement cancelBtn;
	
	@FindBy(xpath= "//input[@id='cardNumber']")
	public static WebElement cardnumberInputText;
	
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
	
	@FindBy(xpath= "//*[text()='Endless Music Pass']//following::button[@class='desktop-action--32a29 action--kmgo5'][1]")
	public WebElement removeMusicPass;
	
	@FindBy(xpath= "//*[text()='Endless Music Pass']//following::button[@class='desktop-action--32a29 action--kmgo5'][2]")
	public WebElement removeVideoPass;
	
	@FindBy(xpath= "//*[text()='Remove pass']//ancestor::button")
	public WebElement confirmRemoveVideoPass;
	
	@FindBy(xpath= "//*[text()='Remove pass']//ancestor::button")
	public WebElement confirmRemoveMusicPass;
	
	public MyAccountPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Add100IntMin() throws Throwable
	{
		addExtra.click();	
		ScrollPageDown.ScrollDownPageTillEnd();	
		addThisExtra.click();		
        Thread.sleep(2000);     
        HandleFrame.SwitchToFrame();     
        Payment.AddCardDetails();;	
	}
	
	public void AddMusicPass() throws Throwable
	{
		
		Thread.sleep(3000);
		ScrollPageDown.ScrollDownPageTillEnd();
		addMusicPass.click();
		Thread.sleep(1000);
		addThisMusicPass.click();	
		Thread.sleep(2000);	
		HandleFrame.SwitchToFrame();	
		Payment.AddCardDetails();;
		  
	
		
	}
	
	
  public void AddVideoPass() throws Throwable 
  
    {
	  addVideoPass.click();
	  addThisVideoPass.click();
	  Thread.sleep(2000);
	  HandleFrame.SwitchToFrame();
	  Payment.AddCardDetails();;		
	}
	
	
	public void Add1GBExtra() throws Throwable
	{
		Thread.sleep(3000);
		ScrollPageDown.scrollDownPageByPixel(0, 1500);
		add1GbExtra.click();
		if(driver.findElement(By.xpath("//*[@class='spring--3enHX m-vertical-small p-horizontal-small s-medium']//h3")).getText().contains("You've got extra data"))
		{
			System.out.println("You already got 1GB extra, please remove and add again");
		}
		
	    addThisExtra.click();
	    Thread.sleep(1000);
	    HandleFrame.SwitchToFrame();
	    Payment.AddCardDetails();;
	    
	}
	
	public void RemoveVideoPass() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ScrollPageDown.fnScroll(2000);
		removeVideoPass.click();
		confirmRemoveVideoPass.click();
	}
	
	public void RemoveMusicPass() throws InterruptedException
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		ScrollPageDown.fnScroll(2000);
		removeMusicPass.click();
		confirmRemoveMusicPass.click();	
		
    }

	
}
