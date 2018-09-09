package com.pages.testcases.test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.util.TakeScreenshot;

import PageObjectModel.LoginPage;
import PageObjectModel.VoxiHomePage;
public class LoginPageTest extends BaseClass {
	
	LoginPage lpage = null ;
	LoginPageTest lPageTest = null;
	VoxiHomePage hPage ;
	
	@Test
	public void resetUserAndPasswordUsingPin() throws InterruptedException
	{
		extentTest = extentReports.createTest("resetUserAndPasswordUsingPin");
		lpage.resetUserAndPasswordUsingPin();
	}
	
	@BeforeMethod
	public void InitiateBrowser()
	{
		initialiseProperty();	
		initialiseBrowser();
		IntialiseExtentReport();
		lPageTest = new LoginPageTest();
		hPage = new VoxiHomePage();	
	    lpage=	hPage.clickOnMyAccountLink();
		
	}

	
	
	@AfterMethod
	public void closeBrowser(ITestResult result) throws Exception
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
		
	driver.close();
	extentReports.flush();
	
	}

}
