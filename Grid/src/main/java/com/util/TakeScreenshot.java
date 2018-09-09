package com.util;

import java.io.File;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.BaseClass;

public class TakeScreenshot extends BaseClass 
{
	
	public static void Screenshot() throws Throwable
	{
		
	 File srcFile =   ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(srcFile, new File("C:/Users/SinghN3/Desktop/AutomationScreenshot/testAddcard"+"_"+ System.currentTimeMillis()+""+ ".png"));
	
		
		

	}

}
