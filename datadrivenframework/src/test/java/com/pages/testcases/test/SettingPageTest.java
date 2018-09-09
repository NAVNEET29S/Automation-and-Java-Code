package com.pages.testcases.test;
import java.util.concurrent.TimeUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.util.TakeScreenshot;

import PageObjectModel.LoginPage;
import PageObjectModel.MyAccountPage;
import PageObjectModel.PaymentAndCardPage;
import PageObjectModel.SettingPage;
import PageObjectModel.VoxiHomePage;

public class SettingPageTest extends BaseClass {
	public PaymentAndCardPage addCard;
	public VoxiHomePage homePage;
	public LoginPage loginPage;
	public MyAccountPage accountPage;
	public SettingPage settingPage;
	
	@Test
	public void ChangeEmailTest() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		extentTest=extentReports.createTest("ChangeEmailTest");
		settingPage.ChangeEmail();	
	}
	
	@Test
	public void ChangePasswordTest() throws Throwable
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  extentTest=extentReports.createTest("ChangePasswordTest");
	  settingPage.changePassword();	
	}
	
	
	
	@BeforeMethod
	public void InitiateBrowser()
	{
		initialiseProperty();
		initialiseBrowser();
		IntialiseExtentReport();
		homePage = new VoxiHomePage();	
		loginPage=	homePage.clickOnMyAccountLink();
		accountPage = loginPage.login();
		settingPage = new SettingPage();	
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws Exception {
	if (result.getStatus() == ITestResult.FAILURE) {
		extentTest.log(Status.FAIL, result.getName());
		extentTest.fail("Faled testcase Screemshot" + extentTest.addScreenCaptureFromPath(TakeScreenshot.Screenshot(result.getName())));
	} else if (result.getStatus() == ITestResult.SUCCESS) {
		extentTest.log(Status.PASS, result.getName());
		extentTest.fail("Faled testcase Screemshot" + extentTest.addScreenCaptureFromPath(TakeScreenshot.Screenshot(result.getName())));
	} else if (result.getStatus() == ITestResult.SKIP) {
		extentTest.log(Status.SKIP, result.getTestName());			
		}

driver.quit();
extentReports.flush();

}



}
