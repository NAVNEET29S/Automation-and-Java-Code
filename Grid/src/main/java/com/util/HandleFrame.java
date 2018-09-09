package com.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.baseclass.BaseClass;

public class HandleFrame extends BaseClass

{
	
	
	
	public static void SwitchToFrame()
	{ 
		List<WebElement> fcount =driver.findElements(By.tagName("iframe"));
		  for(WebElement x: fcount)
		  {
			  if(x.isDisplayed())
				  driver.switchTo().frame(x);
		  }
		
	}
}
