package PageObjectModel;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.baseclass.BaseClass;

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
	
	@FindBy(xpath= "//input[@id='btnSubmit']")
	public static WebElement submitBtn;
	

	@FindBy(xpath= "//input[@id='cardNumber']")
	public static WebElement cardnumberInputText;
	
	public PaymentAndCardPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void BillingAddressAndCard() throws Throwable
	{
		paymentAndCreditLink.click();
		addNewCardBtn.click();
		String text = driver.findElement(By.xpath("//h1[@class='heading--2-S10 m-bottom s-large']")).getText();
		System.out.println(text);
		if(text.equalsIgnoreCase("Add a new card"))
		{
			SetCardbillingAddress();
			Thread.sleep(2000);
			AddCard();
			
		}	
		
		else
			{
			
			AddCard();
			
			}
					
		
	}

	
	
	public void ChangeCardPaymentMethod()
	{
		paymentAndCreditLink.click();
		setAsCurrent.click();
	}
	
	public void SetCardbillingAddress() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		enterPostCodeTextBox.sendKeys("RG14 1DT");
		findAddressBtn.click();
		Thread.sleep(2000);
		Select select = new Select(driver.findElement(By.id("select")));
		select.selectByIndex(5);
		driver.findElement(By.xpath("//button[@class='button-primary--32J2U size-normal--2qDK- has-chevron--2wUUT standard--2a2JQ shadow--3dzTD t-dark']")).click();	
	}
	
	public void AddCard() throws Throwable 
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.switchTo().defaultContent();
		driver.switchTo().frame(("js-payment-iframe"));
		cardnumberInputText.sendKeys(prop.getProperty("card2"));
		Select selectMonth = new Select(driver.findElement(By.xpath("//select[@id='expiryMonth']")));
		Select selecYear = new Select(driver.findElement(By.xpath("//select[@id='expiryYear']")));
		selectMonth.selectByValue("05");
		selecYear.selectByValue("2019");
		driver.findElement(By.xpath("//input[@id='csc']")).sendKeys("123");
		submitBtn.click();
		driver.switchTo().frame("js-payment-iframe");
		driver.findElement(By.id("CompanyLogo")).click();
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='spring--3enHX m-vertical-small p-horizontal-small']/p[1]"))));
		Assert.assertEquals("Your order ID is" , driver.findElement(By.xpath("//*[@class='spring--3enHX m-vertical-small p-horizontal-small']/p[1]")).getText());
		
	}
	


}
