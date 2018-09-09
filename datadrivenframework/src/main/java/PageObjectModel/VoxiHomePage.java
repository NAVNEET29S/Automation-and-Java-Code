package PageObjectModel;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.baseclass.BaseClass;
import com.util.ScrollPageDown;
//import com.pages.testcases.test.HomePageTest;

public class VoxiHomePage extends BaseClass{
	

	@FindBy (xpath = "//ul[@class='menu-list--1NR9e' ]//following::span[contains(text() , 'My account')])")
	public WebElement myAccount;
	
	@FindBy (xpath = "//ul[@class='menu-list--1NR9e' ]//following::span[contains(text() , 'Plan')])")
	public WebElement plan;
	
	@FindBy (xpath = "//span[text() = 'I agree']")
	public static WebElement iAgree;
	
	@FindBy (xpath = "//*[text() = '£10.00']")
	public static WebElement data6GB;	
	
	@FindBy (xpath = "//*[contains(text() , '£15.00')]")
	public WebElement data15GB;
	
	@FindBy (xpath = "//*[text() = '£20.00']")
	public WebElement data45GB;
	
	
	@FindBy (xpath = "//*[contains(text() , 'Get this plan')]")
	public  WebElement getThisPlan;
	
	@FindBy (xpath = "//*[contains(text() , 'I need a SIM')]")
	public  WebElement orderFreeSIMButton;
	
	@FindBy (xpath = "//p[contains(text() , 'I have a SIM')]//parent::li")
	public  WebElement i_Have_A_Sim;
	
	@FindBy (xpath = "//input[@id='first-name']")
	public WebElement  firstName;
	
	
	@FindBy (xpath = "//input[@id='last-name']")
	public WebElement  lastName;
	
	@FindBy (id = "dob")
	public WebElement  dob;
	

	@FindBy (id = "username")
	public WebElement  username;
	
	@FindBy (id = "pin")
	public WebElement  pin;
	
	@FindBy (id = "memorableWord")
	public WebElement  memorableWord;
	
	@FindBy (id = "password")
	public WebElement  password;
	
	@FindBy (id = "confirm-password")
	public WebElement  confmPassd;
	
	
	@FindBy (xpath = "//input[@id='email']")
	public WebElement  email;
	
	@FindBy (xpath = "//input[@id='address-intial-postcode']")
	public WebElement  postCode;
	
	@FindBy (xpath = "//*[text() ='Find address']")
	public WebElement  findAddress;
	
	@FindBy (xpath = "//*[text() ='Under 30']")
	public WebElement  under30;
	
	@FindBy (xpath = "//*[text() ='30 and above']")
	public WebElement  above30;		
		
	@FindBy (xpath = "//*[text() = 'Add extra']")
	public WebElement  addExtraMinute;
	
	@FindBy(id = "sim-number")
	public WebElement inputSIMNumber;
	
	@FindBy (xpath = "//*[text() = 'Endless Music Pass']//following::span[text()='Add Pass']")
	public WebElement  addMusicPass;
	
	@FindBy (xpath = "//*[text() = 'Endless Music Pass']//preceding::span[text()='Add Pass']")
	public WebElement  addVideoPass;
	
	@FindBy (xpath = "//*[text() ='Order free SIM']")
	public WebElement  orderFreeSIM;
	
	@FindBy (xpath = "//*[text() ='Continue']//ancestor::button")
	public WebElement  contnueButton;
	
	@FindBy (xpath = "//*[text() ='Get a new number']")
	public WebElement  getNewnumber;
	
	@FindBy (xpath = "//a[@href='/account']//child::span[@class='no-click-focus--24N53']")
	public  WebElement myAccountLoginBtn;
	
	
	
	public VoxiHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	

	public LoginPage clickOnMyAccountLink()
	{
		myAccountLoginBtn.click();
		
		return new LoginPage();
	}
	
	

public void NewAusition() throws InterruptedException
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	ScrollPageDown.fnScroll(800);
	Thread.sleep(2000);
	getThisPlan.click();
	Thread.sleep(2000);
	i_Have_A_Sim.click();
	Thread.sleep(2000);
	inputSIMNumber.sendKeys(prop.getProperty("sim"));
	contnueButton.click();
	ChooseBundle();
	ScrollPageDown.fnScroll(1000);
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Continue']")));
	contnueButton.click();
	String userName = "NavneetAutomation_"+System.currentTimeMillis();
	createVoxiAccount("navneet", "singh", "29/01/1992", "navneet.singh2@vodafone.com", userName, "1357", "vodafone", "Testing@123");
	getNewnumber.click();
	ScrollPageDown.fnScroll(400);
	contnueButton.click();
	ScrollPageDown.fnScroll(400);
	contnueButton.click();
}

public void ChooseBundle() throws InterruptedException

{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Thread.sleep(2000);
	ScrollPageDown.fnScroll(500);
	if(prop.getProperty("dataBundle").equals("6GB"))
		
	{
		data6GB.click();
	}
	else if(prop.getProperty("dataBundle").equals("15GB"))
	{
		data15GB.click();
	}
	
	else
	{	
	data45GB.click();
	}
		
	
}



public void createVoxiAccount(String fn1 , String ln1 ,String dob1 , String email1 , String username1 , String pin1 , String memWord1 , String password1 ) throws InterruptedException		
{
	firstName.sendKeys(fn1);
	lastName.sendKeys(ln1);
	dob.sendKeys(dob1);
	email.sendKeys(email1);
	username.sendKeys(username1);
	ScrollPageDown.fnScroll(400);
	pin.sendKeys(pin1);
	Select select = new Select(driver.findElement(By.className("select--3VOLR")));
	select.selectByIndex(1);
	memorableWord.sendKeys(memWord1);
	password.sendKeys(password1);
	confmPassd.sendKeys(password1);	
	ScrollPageDown.fnScroll(600);
	contnueButton.click();
	
}

public void verifyNumber(String keepMyNumber  , String getANewNumber)
{
	if (keepMyNumber.equalsIgnoreCase("keep My Number"))
	{
		driver.findElement(By.id("input-ac-mobile-number")).sendKeys("keepMyNumber");
	}
	
	if(getANewNumber.equalsIgnoreCase("get new number"))
{
	driver.findElement(By.className("react-tabs__tab react-tabs__tab--selected")).click();
	
}
	
}


public void reviewYourPlanPage()
{
	driver.findElement(By.className("button-primary--32J2U size-normal--2qDK- has-chevron--2wUUT standard--2a2JQ shadow--3dzTD m-bottom t-dark")).click();
}

public void billingAddress()
{
	postCode.sendKeys("CV1 1FD");
	findAddress.click();
	
	Select select = new Select(driver.findElement(By.id("select")));
	select.deselectByIndex(1);
	driver.findElement(By.className("driver.findElement(By.className(\"button-primary--32J2U size-normal--2qDK- has-chevron--2wUUT standard--2a2JQ shadow--3dzTD m-bottom t-dark\"))")).click();
	
}



}
