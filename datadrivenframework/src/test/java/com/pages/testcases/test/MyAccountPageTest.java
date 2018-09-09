package com.pages.testcases.test;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.util.TakeScreenshot;
import PageObjectModel.LoginPage;
import PageObjectModel.MyAccountPage;
import PageObjectModel.MyPlanPage;
import PageObjectModel.SettingPage;
import PageObjectModel.VoxiHomePage;

public class MyAccountPageTest extends BaseClass{	
	    MyAccountPage accountPage;
		MyAccountPageTest AccountPageTest;
		LoginPage loginPage;
		VoxiHomePage homePage;
		MyPlanPage planPage;
		SettingPage settingPage;
		
		 
			@BeforeMethod
			public void InitiateBrowser() throws InterruptedException
			{
				initialiseProperty();
			    initialiseBrowser();
			    IntialiseExtentReport();
				AccountPageTest = new MyAccountPageTest();
				accountPage = new MyAccountPage();
				homePage = new VoxiHomePage();	
				loginPage=	homePage.clickOnMyAccountLink();
				accountPage = loginPage.login();
				Thread.sleep(8000);
				settingPage = new SettingPage();
				
			}


		@Test(priority =0)
		public void AddMusicPass() throws Throwable
		{
		extentTest = extentReports.createTest("AddMusicPass");
		 accountPage.AddMusicPass();    	
		}
			
		
		@Test(priority =1)
		public void Add1GBBundle() throws Throwable
		{
			extentTest = extentReports.createTest("Add1GBBundle");
			accountPage.Add1GBExtra();
		}
		

		@Test(priority =2)
		public void AddVideoPass() throws Throwable 
		{
			extentTest = extentReports.createTest("AddVideoPass");
			accountPage.AddVideoPass();
		}
		
		
		@Test(priority =3)
	    public void Add100IntMin() throws Throwable 
	    {
			extentTest = extentReports.createTest("Add100IntMin");
			accountPage.Add100IntMin();
	    }
		

		
		@Test(priority=4)
		public void RemoveMusicPass() throws InterruptedException
		{
			extentTest = extentReports.createTest("RemoveMusicPass");
			accountPage.RemoveMusicPass();
		}
		
		
		@Test(priority=5 )
		public void RemoveVideoPass() throws InterruptedException
		{
			extentTest = extentReports.createTest("RemoveVideoPass");
			accountPage.RemoveVideoPass();
		}
		
	
	

	    @AfterMethod
		public void closeBrowser(ITestResult result) throws Exception, Exception
		{if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, result.getName());
			extentTest.fail("Screen Shot of failed test cases :" + extentTest.addScreenCaptureFromPath(TakeScreenshot.Screenshot(result.getName())));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getName());
			extentTest.pass("Screen Shot of passed test case : " + extentTest.addScreenCaptureFromPath(TakeScreenshot.Screenshot(result.getName())));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, result.getTestName());
		}
	    	Thread.sleep(3000);
			settingPage.SignOut();
			driver.close();
			extentReports.flush();
		}
	    
	   
}
