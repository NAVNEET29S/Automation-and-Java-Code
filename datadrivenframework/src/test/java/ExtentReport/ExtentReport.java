package ExtentReport;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReport {	
ExtentHtmlReporter extentHtmlReporter;
ExtentReports extentReports;
ExtentTest extentTest;
WebDriver driver;


@org.testng.annotations.BeforeTest
public void BeforeTest()
{
	extentReports = new ExtentReports();
	extentHtmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//extentreport.html");
	extentReports.attachReporter(extentHtmlReporter);
	extentReports.setSystemInfo("OS", "Win10");
	extentReports.setSystemInfo("Machine", "E0249432");
	extentReports.setSystemInfo("Env", "T1/E4");
	extentReports.setSystemInfo("browwser", "Chrome");
}

	
	@Test
	public void test1()
	{
		extentTest=extentReports.createTest("Extent report test1");
		System.out.println("in test1");
		throw new SkipException("Skiiping test1");
	}
	
	@Test
	public void test2()
	{
	   extentTest=extentReports.createTest("Extent report test2");
		System.out.println("in test2");
	}

	@Test
	public void test3()
	{
		extentTest=extentReports.createTest("Extent report test3");
		System.out.println("in test3");
       Assert.assertTrue(false);
	}
	
	
	@org.testng.annotations.AfterMethod
	public void AfterMethod(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE) {
			extentTest.log(Status.FAIL, result.getName());
			//test.fail("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, result.getName());
			//test.pass("Screen Shot : " + test.addScreenCaptureFromPath(screenShot));
		} else if (result.getStatus() == ITestResult.SKIP) {
			extentTest.log(Status.SKIP, result.getName());
		}
		
		
	}
	
	@org.testng.annotations.AfterTest
	public void AfterTest()
	{
		extentReports.flush();
	}
	

}
