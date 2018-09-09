package PageObjectModel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.baseclass.BaseClass;
import com.util.HandleFrame;
import com.util.TakeScreenshot;

public class PaymentAndCardPage extends BaseClass {
	
	@FindBy(partialLinkText = "Payment & Credit")
	WebElement paymentAndCreditLink;
	
	@FindBy(xpath = "//button[@class='button-primary--32J2U size-normal--2qDK- has-chevron--2wUUT standard--2a2JQ shadow--3dzTD m-vertical-small w-normal s-small t-dark']")
	WebElement addNewCardBtn;
	
	@FindBy(id = "address-intial-postcode")
	WebElement enterPostCodeTextBox;
	
	@FindBy(xpath = "//button[@class='button-primary--2_74r s-small']")
	WebElement findAddressBtn;
	
	@FindBy(xpath = "//button[text()='Set as current']")
	WebElement setAsCurrent;
	
	public PaymentAndCardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void BillingAddressAndCard() throws Throwable
	{
		paymentAndCreditLink.click();
		TakeScreenshot.Screenshot();
		addNewCardBtn.click();
		TakeScreenshot.Screenshot();
		String text = driver.findElement(By.xpath("//h1[@class='heading--2-S10 m-bottom s-large']")).getText();
		System.out.println(text);
		if(text.equalsIgnoreCase("Add a new card"))
		{
			SetCardbillingAddress();
			Thread.sleep(3000);
			AddCard();
			
		}	
		
		else
			{
			
			AddCard();
			
			}
					
		
	}
	
	public void SetCurrentcard()
	{
		setAsCurrent.click();
	}
	
	public void SetCardbillingAddress() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		enterPostCodeTextBox.sendKeys("RG14 1DT");
		findAddressBtn.click();
		TakeScreenshot.Screenshot();
		Select select = new Select(driver.findElement(By.id("select")));
		select.selectByIndex(5);
		TakeScreenshot.Screenshot();
		driver.findElement(By.xpath("//button[@class='button-primary--32J2U size-normal--2qDK- has-chevron--2wUUT standard--2a2JQ shadow--3dzTD t-dark']")).click();			
		TakeScreenshot.Screenshot();
	}
	
	public void AddCard() 
	{
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		driver.switchTo().frame((driver.findElement(By.id("js-payment-iframe"))));
		MyAccountPage.cardnumberInputText.sendKeys(prop.getProperty("card"));
		Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='expiryMonth']")));
		Select selecYear = new Select(driver.findElement(By.xpath("//select[@id='expiryYear']")));
		selectMonth.selectByValue("05");
		selecYear.selectByValue("2019");
		driver.findElement(By.xpath("//input[@id='csc']")).sendKeys("123");
		try {
			TakeScreenshot.Screenshot();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		MyAccountPage.submitBtn.click();
	}
	


}
