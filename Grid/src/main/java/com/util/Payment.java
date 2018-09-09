package com.util;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import com.baseclass.BaseClass;
import PageObjectModel.*;

public class Payment extends BaseClass
{
	public static void AddCardDetails()
	{
		if(driver.findElement(By.id("confirmCardSchemePanel")).isDisplayed())
		{
			MyAccountPage.cvv.sendKeys("123");
			MyAccountPage.submitBtn.click();

		}
		
		else
			
		{
			MyAccountPage.cardnumberInputText.sendKeys(prop.getProperty("card"));
			Select select = new Select(driver.findElement(By.id("expiryMonth")));
			select.selectByValue("04");
			Select select1 = new Select(driver.findElement(By.id("expiryYear")));
			select1.selectByVisibleText("2019");
			driver.findElement(By.id("csc")).sendKeys("123");
			ScrollPageDown.scrollingToElementofPage(MyAccountPage.submitBtn);
			MyAccountPage.submitBtn.click();
		}
	}

}
