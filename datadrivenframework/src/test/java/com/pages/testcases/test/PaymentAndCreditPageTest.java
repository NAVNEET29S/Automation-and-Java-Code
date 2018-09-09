package com.pages.testcases.test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.util.TakeScreenshot;
import PageObjectModel.LoginPage;
import PageObjectModel.MyAccountPage;
import PageObjectModel.PaymentAndCardPage;
import PageObjectModel.SettingPage;
import PageObjectModel.VoxiHomePage;

public class PaymentAndCreditPageTest extends BaseClass {
	public PaymentAndCardPage addCard;
	public VoxiHomePage homePage;
	public LoginPage loginPage;
	public MyAccountPage accountPage;
	public SettingPage settingPage;
	public BaseClass baseClass;
	
	@Test
	public void AddNewCardTest() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extentTest=extentReports.createTest("AddNewCardTest");
		addCard.BillingAddressAndCard();	
	}
	
/*	@Test
	public void ChangeCurrentcard()
	{	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extentTest=extentReports.createTest("ChangeCurrentcard");
		addCard.ChangeCardPaymentMethod();
		throw new SkipException("Throwinmg exvepotion");
	}*/

	
	@BeforeMethod
	public void InitiateBrowser()
	{
		initialiseProperty();
     	initialiseBrowser();
		addCard =  new PaymentAndCardPage();
		homePage = new VoxiHomePage();	
		loginPage=	homePage.clickOnMyAccountLink();
		accountPage = loginPage.login();
		settingPage = new SettingPage();	
	}

	@BeforeSuite
	public void ExtentReportInitialisationTest()
	{		IntialiseExtentReport();
		
	}
	
	

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException, Exception
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, result.getName());
			extentTest.fail("Screen Shot of failed test cases :" + extentTest.addScreenCaptureFromPath(TakeScreenshot.Screenshot(result.getName())));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getName());
			extentTest.pass("Screen Shot of passed test case : " + extentTest.addScreenCaptureFromPath(TakeScreenshot.Screenshot(result.getName())));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, result.getTestName());
		}
		settingPage.SignOut();
		driver.close();
		

	}
	
	@AfterTest
	public void FlushReport()
	{
		extentReports.flush();
	}


}
