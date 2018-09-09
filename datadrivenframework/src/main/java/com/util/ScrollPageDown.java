package com.util;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import com.baseclass.BaseClass;

public class ScrollPageDown extends BaseClass
{	
	public static void scrollDownPageByPixel(int xCordinate  , int yCordinate)
	{
	
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy('"+xCordinate+"','"+yCordinate+"')");
	}
	
	public static void scrollingToElementofPage(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();",element );
		
	}
	
	public static void ScrollDownPageTillEnd()
	{
		((JavascriptExecutor) driver)
	     .executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public static void fnScroll(int intScrollValue)
    {
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("window.scrollBy(0,'"+intScrollValue+"')");    
    }	
	
}
