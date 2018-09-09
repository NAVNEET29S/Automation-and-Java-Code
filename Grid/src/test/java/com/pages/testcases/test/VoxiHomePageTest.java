package com.pages.testcases.test;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
import PageObjectModel.MyAccountPage;
import PageObjectModel.PaymentAndCardPage;
import PageObjectModel.VoxiHomePage;


public class VoxiHomePageTest extends BaseClass{
	
	VoxiHomePageTest hPageTest;
	VoxiHomePage hPage;
	PaymentAndCardPage paymentAndCard;
	MyAccountPage myAccount;
	
	@Test
	public void NewAquistionTest() throws Throwable
	{
		hPage.NewAusition();
		paymentAndCard.SetCardbillingAddress();
		driver.findElement(By.xpath("//input[@id='cardholderName']")).sendKeys("Navneet");
		paymentAndCard.AddCard();
		
		
	}
	
	
	@BeforeTest
	public void intilaisation()
	{	  
		
		initialiseBrowser();	
	    initialiseProperty();
		hPage = new VoxiHomePage();
		hPageTest = new VoxiHomePageTest();	
		paymentAndCard=  new PaymentAndCardPage();
		myAccount = new MyAccountPage();
		
		
		
	}
	
	/*@AfterTest
	public void closeBrowser()
	{
	
	driver.quit();
	}
	*/
	 
	

}
