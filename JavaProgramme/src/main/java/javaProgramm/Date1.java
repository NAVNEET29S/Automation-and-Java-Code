package javaProgramm;

import java.text.SimpleDateFormat;
import java.util.Date;

 public class Date1 {	
	public static void main(String[]args)
	{
	SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy  hh:mm:ss");
    Date date = new Date();
	System.out.println(date);	
	System.out.println(format.format(date));
	
	}
	
	

}