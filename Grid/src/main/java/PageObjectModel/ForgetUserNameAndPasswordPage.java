package PageObjectModel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;

public class ForgetUserNameAndPasswordPage extends BaseClass 
{
	@FindBy (id = "fu-input-phone-number")
	public WebElement inputVoxiNumber;
	
	@FindBy (className = "button-primary--32J2U size-small--3crwC has-chevron--2wUUT standard--2a2JQ shadow--3dzTD m-vertical t-dark")
	public WebElement nextNButtonMemorableWord;
	
	@FindBy (className = "button-primary--32J2U size-normal--2qDK- has-chevron--2wUUT standard--2a2JQ shadow--3dzTD m-vertical-small t-dark")
	public WebElement nextNButtonPin;
			
	@FindBy (id = "fu-input-memorable-word")
	public WebElement inputMemorableWord;	
	
	@FindBy (id = "Pin")
	public WebElement inputPin;	
	
	public ForgetUserNameAndPasswordPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void forget_Username_Password_Using_Memorbaleword()
	{
		inputMemorableWord.sendKeys(prop.getProperty("memorableWord"));
		
		nextNButtonMemorableWord.click();
	}	
	
	public void forget_Username_Password_Using_Pin()
	{
		inputMemorableWord.sendKeys(prop.getProperty("pin"));
		nextNButtonPin.click();
		
	}		

}
