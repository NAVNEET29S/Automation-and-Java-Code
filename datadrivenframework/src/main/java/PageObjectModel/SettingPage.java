package PageObjectModel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.baseclass.BaseClass;

public class SettingPage extends BaseClass
{
	
  @FindBy(xpath = "//a[@href = '/account/settings']/span")
	WebElement settingLink;
	
  @FindBy(xpath = "//button[@class='button-clear--1OfWQ size-normal--2qDK- has-chevron--2wUUT standard--2a2JQ t-light']")
    WebElement singOut;
  
	
  @FindBy(xpath = "//*[text()='Change email']")
	WebElement changeEmailLink ;
  
  @FindBy(xpath = "//input[@class='input-initial--2cI8c' and @id='email']")
	WebElement inputEmail;
  
  @FindBy(xpath = "//input[@class='input-initial--2cI8c' and @id='current-password']")
 	WebElement inputPassword;
  
  @FindBy(xpath = "//*[text()='Save changes']")
 	WebElement saveChnagesBtn;
  
  @FindBy(xpath = "//button[@to='/account/settings/password']")
 	WebElement changePasswordLink;
  
  @FindBy(xpath = "//input[@id='new-password']")
	WebElement newPassword;
  
  @FindBy(xpath = "//input[@id='current-password']")
	WebElement currentPassword;
  
  @FindBy(xpath = "//input[@id='confirm-password']")
	WebElement confirmPassword;
  
  @FindBy(xpath = "//input[@id='memorable-word']")
	WebElement memorableWord;
  
  @FindBy(xpath = "//button[@type = 'submit']")
	WebElement changePasswordBtn;
  
  @FindBy(xpath = "//button[@to='/account']")
 	WebElement returnToMyAccountBtn;
  
  public SettingPage()
  {
	  PageFactory.initElements(driver, this);
  }
  
  
  public void SignOut()
  {
	  settingLink.click();
	  singOut.click();
	  
  }
  
  public void ChangeEmail() throws Throwable
  {
	  settingLink.click();
	  changeEmailLink.click();
	  inputEmail.sendKeys(prop.getProperty("changeEmail"));
	  inputPassword.sendKeys(prop.getProperty("password"));
	  saveChnagesBtn.click();
	  Thread.sleep(4000);
	  returnToMyAccountBtn.click();
  }
  
  public void changePassword() throws Throwable
  {
	  settingLink.click();
	  changePasswordLink.click();
	  currentPassword.sendKeys(prop.getProperty("password"));
	  newPassword.sendKeys("Testing@123");
	  confirmPassword.sendKeys("Testing@123");
	  memorableWord.sendKeys(prop.getProperty("memorableWord"));
	  changePasswordBtn.click();
	  Thread.sleep(2000);
  }

}
