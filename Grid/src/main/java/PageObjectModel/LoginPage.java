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
		
		return new MyAccountPage();
	}
	
	
	public ForgetUserNameAndPasswordPage resetUserAndPassword()
	{
		forgetUserAndPasswordLink.click();
		
		return new ForgetUserNameAndPasswordPage();	
	}
		
}
