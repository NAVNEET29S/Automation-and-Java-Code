package com.pages.testcases.test;
import java.util.concurrent.TimeUnit;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.baseclass.BaseClass;
import com.util.TakeScreenshot;
import PageObjectModel.LoginPage;
import PageObjectModel.MyPlanPage;
import PageObjectModel.SettingPage;
import PageObjectModel.VoxiHomePage;

public class MyPlanPageTest extends BaseClass{
	MyPlanPage planPage;
	MyPlanPageTest planPageTest;
	LoginPage loginPage;
	VoxiHomePage homePage;
	SettingPage settingPage;
	
	@BeforeSuite
	public void ExtentReportInitialisationTest()
	{		IntialiseExtentReport();
		
	}	
	
	@BeforeMethod
	public void InitiateBrowser() throws InterruptedException
	{
		planPageTest = new MyPlanPageTest();
		planPageTest.initialiseProperty();
		planPageTest.initialiseBrowser();
		planPage = new MyPlanPage();
		homePage = new VoxiHomePage();	
		loginPage=	homePage.clickOnMyAccountLink();
		loginPage.login();
		settingPage =  new SettingPage();
				
	}
		
	/*@Test(priority=1)
	public void changePlan() throws Throwable
	{

		extentTest=extentReports.createTest("changePlan");
		
     planPage.changePlan();	
     
    try {
		if(planPage.counter==1)   
		{
			planPage.BuyNewPlan("45GB");
   
		}
	} catch (Exception e) {
		
		e.printStackTrace();
	}
    
	}*/
	
	@Test(priority=2)
	public void CancelChangePlanTest() throws InterruptedException
	{
		extentTest=extentReports.createTest("CancelChangePlanTest");
		planPage.CancelChangePlan();
	}

	
	@AfterMethod
	public void closeBrowser(ITestResult result) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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
		extentReports.flush();
		
	}

}
