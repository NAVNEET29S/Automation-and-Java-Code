package com.pages.testcases.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

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
	public void ChangeEmailTest()
	{
		settingPage.ChangeEmail();	
	}
	
	@Test
	public void ChangePasswordTest()
	{
	  settingPage.changePassword();	
	}
	
	
	
	@BeforeMethod
	public void InitiateBrowser()
	{
		
		initialiseBrowser();
		initialiseProperty();
		homePage = new VoxiHomePage();	
		loginPage=	homePage.clickOnMyAccountLink();
		accountPage = loginPage.login();
		settingPage = new SettingPage();
		
	}

	

	@AfterMethod
	public void closeBrowser()
	{
		settingPage.SignOut();
		driver.close();
	}


	


}
