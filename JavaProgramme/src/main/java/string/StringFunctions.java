package string;

import java.util.Arrays;

public class StringFunctions {

	public static void main(String[] args) {
			String str1 = "navneet";
		    String str2 = "navneet";
			String str3 = new String("navneet");
			String str4 = new String("Singh");
		String str5 = new String ();
		str5 = "navneet";
     	str1=	str1.concat(str5);
		System.out.println(str1==str2);
		System.out.println(str1==str3);	
			System.out.println(str1==str4);
			System.out.println(str3==str4);
			System.out.println(str1==str5);		
		 
		System.out.println(str1);	
	String[] str6 = new String[3];
	str6[0]="Sachin";
	str6[1]="Dhoni";
	str6[2] = "Sehwag";
	
	System.out.println(str6);
	System.out.println(str6[1]);
			
	char a [] = str2.toCharArray();
	System.out.println("char a [] = str2.toCharArray() ="+a);
	char b [] = {'v','o','d'};
	 char c[] = new char[5];
	 c[0]= 'a';
	 c[1]= 'b';
	 c[2]= 'c';
	 System.out.println(c);
	 System.out.println(c[0]);
			 
	
	String x =Arrays.toString(a);
	x = a.toString();
	System.out.println("Converting array to string"+x);
	
	
	
	
	
	

	}

}
;