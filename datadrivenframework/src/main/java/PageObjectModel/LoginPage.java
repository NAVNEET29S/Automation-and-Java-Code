package PageObjectModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;

public class LoginPage extends BaseClass
{
	@FindBy (id = "lo-input-username")
	public  WebElement userName;
	
	@FindBy (id = "lo-input-password")
	public  WebElement password;
	
	@FindBy (xpath = "//*[@id=\"react-tabs-11\"]/form/button")
	public WebElement signInBtn;
	
	@FindBy (linkText = "Forgotten your username or password?")
	public WebElement forgetUserAndPasswordLink;
	
	@FindBy (xpath = "//*[text()='Create an account']")
	public WebElement createAccountButton;
	
	@FindBy (xpath = "//*[text()='Set up a new account']")
	public WebElement setupNewAccountButton;
	
	@FindBy (xpath = "//input[@type='tel']")
	public WebElement inpuEnterNumber;
	
	@FindBy (xpath = "//*[text()='I’ve forgotten my memorable word']//preceding::button[1]")
	public WebElement nextButton2;
	
	@FindBy (xpath = "//*[text()=\"I don't know my VOXI number\"]//preceding::button[1]")
	public WebElement nextButton1;
	
	@FindBy (xpath = "//*[text()='Next']")
	public WebElement nextButton3;
	
	@FindBy (id = "fu-input-phone-number")
	public  WebElement inputVoxiNumber;
	
	@FindBy (id = "fu-input-memorable-word")
	public  WebElement inputMemWord;
	
	@FindBy (xpath = "//input[@type='password' and @id='password']")
	public  WebElement inputTempPassword;
	
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public MyAccountPage login()
	{
	String username = prop.getProperty("username");
	String password1 = prop.getProperty("password");
		userName.sendKeys(username);
		password.sendKeys(password1);
		signInBtn.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return new MyAccountPage();
	}
	
	
	public void resetUserAndPasswordUsingPin() throws InterruptedException
	{
		forgetUserAndPasswordLink.click();
		inputVoxiNumber.sendKeys(prop.getProperty("msisdn"));
		Thread.sleep(1000);
		nextButton1.click();
		inputMemWord.sendKeys(prop.getProperty("memorableWord"));
		nextButton2.click();
		inputTempPassword.sendKeys(prop.getProperty("email"));
		nextButton3.click();
		
		
		
		
	}
	
	
	public void	 CreateAccount()
	{
		createAccountButton.click();
		setupNewAccountButton.click();
		inpuEnterNumber.sendKeys(prop.getProperty("msisdn"));
		//nextButton.click();	
	}
		
}
