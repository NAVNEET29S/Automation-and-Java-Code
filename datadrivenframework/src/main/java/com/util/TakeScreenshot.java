package com.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.text.SimpleAttributeSet;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.baseclass.BaseClass;

public class TakeScreenshot extends BaseClass 
{
	
	public static String Screenshot(String testCaseName) throws Exception
	{
		
	 File srcFile =   ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 
	 String destinationPath = System.getProperty("user.dir")+ "/test-output"+"/Screenshot/"+GetDate()+"/"+testCaseName+"_"+GetTime()+".png";
	 
	 File destFile =  new File(destinationPath);
	
	FileUtils.copyFile(srcFile, destFile);
	
	return destinationPath;


     }
	
	
	public static String GetDate()
	{
		SimpleDateFormat dateFormatDate = new SimpleDateFormat("dd-MMM-YYYY");

		Date date = new Date();
	    String y = dateFormatDate.format(date);
	    return y;
	   

}
	
	public static String GetTime()
	{
		SimpleDateFormat dateFormatTime = new SimpleDateFormat("hh-mm-ss");

		Date date = new Date();
	    String x =dateFormatTime.format(date);
	    return x;

	   

}
}


