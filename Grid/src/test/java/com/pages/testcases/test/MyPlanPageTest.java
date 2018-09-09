package com.pages.testcases.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.BaseClass;

import PageObjectModel.LoginPage;
import PageObjectModel.MyPlanPage;
import PageObjectModel.VoxiHomePage;

public class MyPlanPageTest extends BaseClass{
	MyPlanPage planPage;
	MyPlanPageTest planPageTest;
	LoginPage loginPage;
	VoxiHomePage homePage;
	
	@Test
	public void changePlan() throws InterruptedException
	{ 
     planPage.changePlan();	
     
    try {
		if(planPage.counter==1)   
		{
			planPage.BuyNewPlan("45GB");
   
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    
	}
	
	@BeforeTest
	public void InitiateBrowser()
	{
		planPageTest = new MyPlanPageTest();
		planPageTest.initialiseBrowser();
		planPageTest.initialiseProperty();
		planPage = new MyPlanPage();
		homePage = new VoxiHomePage();	
		loginPage=	homePage.clickOnMyAccountLink();
		loginPage.login();
		
	}

	
	
	@AfterTest
	public void closeBrowser()
	{
		//driver.close();
	}

}
