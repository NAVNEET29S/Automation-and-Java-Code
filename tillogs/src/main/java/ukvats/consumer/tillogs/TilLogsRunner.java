package ukvats.consumer.tillogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TilLogsRunner {

	public static void main(String[] args) throws InterruptedException {
		

		Scanner kb = new Scanner(System.in);
		String[] ts = args[0].split("~");
		String day= ts[0];
		System.out.println(day);
		String monthyear = ts[1];
		int hour = Integer.parseInt(ts[2]);
		int startTime = Integer.parseInt(ts[3]);
		int endTime = Integer.parseInt(ts[4]);
		System.out.println("Enter Environment");
		String env = kb.next();
		String envUpper = env.toUpperCase();
		System.out.println("Enter the bus in which you want to find the logs  ex - CB1  or SB1 ");
		String bus = kb.next();
		String bus1=bus.toUpperCase();
		//System.out.println("env value after upperCase transformation : "+ envUpper);
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Browser_Driver\\chromedriver.exe");
		driver= new ChromeDriver();
		
		//driver.manage().window().setPosition(new Point (-2000 ,0));
		driver.get("http://auktltwr.dc-dublin.de:7780/til/fileBrowse.jsp?file=/"+envUpper+"_EMS"+"/"+monthyear+"/"+day+"/"+hour+"."+bus1+"-log");
			//	Thread.sleep(1000);
		
		
		

		/*  Click on the link on the month & Year Link	
			
		    driver.findElement(By.linkText(monthyear+"/")).click();
			
			driver.findElement(By.linkText(day +"/")).click();
		
		driver.findElement(By.linkText(hour+".CB1-log")).click();
		
				Set<String> set = driver.getWindowHandles()	
					driver.switchTo().window(set.toArray()[1].toString());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.MINUTES);
		try {
			Thread.sleep(800000);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Thread.sleep(5000);
		*/
	
		
		WebElement we = driver.findElement(By.xpath("/html/body/pre"));
		String text = we.getText();
		PrintWriter writer = null;
		File file = new File("C:\\Users\\SinghN3\\Desktop\\Logs\\data.log");
		try {
			writer = new PrintWriter(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.print(text);
		writer.flush();
		writer.close();
	    
		
		/*Read the data.log file and Write the file to abc.log by applying the start and end date*/
		
		
		///File file = new File("C:\\Users\\SinghN3\\aaa\\data.xml");
		//File file = new File("C:/Users/SinghN3/Desktop/Logs/data.log");
		BufferedReader br = null;
		try 
		{
			br = new BufferedReader(new FileReader(file));
		} 
		
		catch (FileNotFoundException e) 
		
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//String previousLine = null;
		String currentLine = null;
		//String nextLine = null;
		PrintWriter pw = null;
		try 
		{
			pw = new PrintWriter(new FileWriter("C:\\Users\\SinghN3\\Desktop\\Logs\\abc.log"));
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
		
		
		boolean break_while = false;
		//HashMap<String, List<HashMap<String,TiLLogs>>> allData = new LinkedHashMap<String, List<HashMap<String,TiLLogs>>>();
		List<HashMap<String, TiLLogs>> tilLogsData = new LinkedList<HashMap<String,TiLLogs>>();
		if(br!=null) {
			try {
				while(br.ready()) {
					currentLine = br.readLine();
					System.out.println(currentLine);
					if(currentLine.contains("--------------- Message: ---------------")) {
						HashMap<String, TiLLogs> logs = Utils.readDataFile(br);
						if(logs!=null) {
							tilLogsData.add(logs);
						}
					}
					
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}
			
		}
		
		System.out.println(tilLogsData.toString());
		
		
		
		/*if(br!=null) 
		{
			try {
				while(br.ready()) 
				{
					currentLine = br.readLine();
					if(break_while) 
				  {
						String[] str = null;
						int time = 0;
						if(br.ready())
						
						{
							String line = br.readLine();
							if(line.contains("SystemTimestamp")) 
							{
								str = line.split(" ")[2].replace("T", "").split(":");
								String str1 = str[0]+""+str[1];
								time = Integer.parseInt(str1);
								if(time>=startTime && time<=endTime)
								{
		
									pw.println(line);
								}
							}
						  }
						
				
						
						if(time>=startTime && time<=endTime) 
						{
							while(br.ready()) 
						 {
								String line = br.readLine();
						
								if(line.contains("--------------- Message: ---------------")) 
								{
									pw.println(line);
									break_while = true;
									break;
								}
								
								
								// print all lines
								if(pw!=null) 
								{
									pw.println(line);
								}
							}
						}
						
					}
					
					if(currentLine.contains("--------------- Message: ---------------")) 
					{
						String[] str = null;
						int time = 0;
						if(br.ready()) 
						{
							String line = br.readLine();
							if(line.contains("SystemTimestamp")) 
							{
								str = line.split(" ")[2].replace("T", "").split(":");
								String str1 = str[0]+""+str[1];
								time = Integer.parseInt(str1);
								if(time>=startTime && time<=endTime) 
						        {
									pw.println(line);
								}
								//System.out.println(startTime+"--"+time +"--" +endTime);
							}
						}
						
						if(time>=startTime && time<=endTime) {
							pw.println(currentLine);
							while(br.ready()) {
								String line = br.readLine();
							//	System.out.println("_________________________"+line);
								if(line.contains("--------------- Message: ---------------")) {
									pw.println(line);
									break_while = true;
									break;
								}
								if(pw!=null) {
									pw.println(line);
								}
							}
						}
					}
				}
				pw.flush();
				pw.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		
    }
}