package com.pages.testcases.test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
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
	
		@Test(priority=0, enabled = false)
		public void AddMusicPass() throws Throwable
		{
	
		 accountPage.AddMusicPass();    	
		}
			
		
		@Test(priority=1, enabled = false)
		public void Add1GBBundle() throws Throwable
		{
			accountPage.Add1GBExtra();
		}
		

		@Test(priority=3, enabled = false )
		public void AddVideoPass() throws Throwable 
		{
			
			accountPage.AddVideoPass();
		}
		
		
		@Test(priority=4, enabled = false)
	    public void Add100IntMin() throws Throwable 
	    {
			accountPage.Add100IntMin();
	    }
		
		
		
		@Test(priority=5)
		public void RemoveMusicPass() throws InterruptedException
		{
			accountPage.RemoveMusicPass();
		}
		
		
		@Test(priority=6 )
		public void RemoveVideoPass() throws InterruptedException
		{
			accountPage.RemoveVideoPass();
		}
		
		
		@BeforeMethod
		public void InitiateBrowser()
		{

			AccountPageTest = new MyAccountPageTest();
			AccountPageTest.initialiseBrowser();
			AccountPageTest.initialiseProperty();
			accountPage = new MyAccountPage();
			homePage = new VoxiHomePage();	
			loginPage=	homePage.clickOnMyAccountLink();
			accountPage = loginPage.login();
			settingPage = new SettingPage();
			
		}

		

	    @AfterMethod
		public void closeBrowser()
		{
			settingPage.SignOut();
		}
}
