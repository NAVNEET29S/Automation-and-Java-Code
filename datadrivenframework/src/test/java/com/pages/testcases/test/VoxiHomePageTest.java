package com.pages.testcases.test;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.util.TakeScreenshot;

import PageObjectModel.PaymentAndCardPage;
import PageObjectModel.VoxiHomePage;

public class VoxiHomePageTest extends BaseClass{
	
	VoxiHomePage hPage;
	PaymentAndCardPage paymentAndCard;
	
	@Test
	public void NewAquistionTest() throws Throwable
	{
		extentTest=extentReports.createTest("NewAquistionTest");
		hPage.NewAusition();
		paymentAndCard.SetCardbillingAddress();
		driver.switchTo().frame("js-payment-iframe");
		driver.findElement(By.xpath("//input[@id='cardholderName']")).sendKeys("Navneet");
		paymentAndCard.AddCard();
			
	}
	
	
	@BeforeTest
	public void intilaisation()
	{	  
		initialiseProperty();
		initialiseBrowser();
		IntialiseExtentReport();
		hPage = new VoxiHomePage();	
		paymentAndCard=  new PaymentAndCardPage();				
	}

	
	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException, Exception
	{
		{
			if (result.getStatus() == ITestResult.FAILURE) {
				extentTest.log(Status.FAIL, result.getName());
				extentTest.fail("Faled testcase Screemshot" + extentTest.addScreenCaptureFromPath(TakeScreenshot.Screenshot(result.getName())));
			} else if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(Status.PASS, result.getName());
				extentTest.fail("Faled testcase Screemshot" + extentTest.addScreenCaptureFromPath(TakeScreenshot.Screenshot(result.getName())));
			} else if (result.getStatus() == ITestResult.SKIP) {
				extentTest.log(Status.SKIP, result.getTestName());			
				}
	
	extentReports.flush();
	
	}

	 
	

}
}
