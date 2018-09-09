package toolsqa;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AutomationPracticeForm {

	public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\SinghN3\\Desktop\\Selinium Jars 3.0\\chromedriver.exe" );
	WebDriver driver = new ChromeDriver();
	driver.get("http://toolsqa.com/automation-practice-form/");
Select select = new Select(driver.findElement(By.id("continents")));
select.selectByVisibleText("Africa");
List<WebElement> options =select.getOptions();

//System.out.println(options);
//String arr = options.toString();

System.out.println("List of all the continent in the drop down are");
for(WebElement arr : options)
{
	String a = arr.getText();
	System.out.println(a); 
}

System.out.println("the selected continent is "+ " = "+select.getFirstSelectedOption().getText());

Select select1 = new Select(driver.findElement(By.id("selenium_commands")));
Boolean a = select1.isMultiple();


if(a.equals(true))
{
	List<WebElement> mOptions = select1.getOptions();
	int size = mOptions.size();
	
	System.out.println("List of values in multiselect are");
	for(int i=0 ; i<size ; i++)
	{
	  String name = mOptions.get(i).getText();
	  System.out.println(name);
	}
	
	select1.selectByVisibleText("Browser Commands");
	select1.selectByVisibleText("Navigation Commands");
	select1.selectByVisibleText("Switch Commands");
	select1.selectByIndex(4);
System.out.println("Total number of selected values are   "+ select1.getAllSelectedOptions().size() + "/n"+ "Selected Values are ") ;

for(WebElement arr : select1.getAllSelectedOptions())
{
	System.out.println(arr.getText());
}


}

}
}
