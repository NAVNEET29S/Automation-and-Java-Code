package com.pages.testcases.test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.baseclass.BaseClass;
import PageObjectModel.LoginPage;
import PageObjectModel.VoxiHomePage;
public class LoginPageTest extends BaseClass {
	
	LoginPage lpage = null ;
	LoginPageTest lPageTest = null;
	VoxiHomePage hPage ;
	
	@Test
	public void loginPageTest()
	{
		
		lpage.login();
		
	}
	
	@BeforeTest
	public void InitiateBrowser()
	{
		lPageTest = new LoginPageTest();
		lPageTest.initialiseBrowser();
		lPageTest.initialiseProperty();	
		hPage = new VoxiHomePage();	
	    lpage=	hPage.clickOnMyAccountLink();
		
	}

	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
