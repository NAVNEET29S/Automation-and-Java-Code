package string;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseStrng {

public  void ReverseString() {
Scanner kb = new Scanner(System.in);
System.out.println("Enter the name");
String name = kb.next();
char arr[] = new char[name.length()];
arr = name.toCharArray();

//char brr[] = name.toCharArray();
int j= 0;
int k = arr.length-1;
char brr[]= new char[arr.length]  ;
for(int i= k ; i>=0; i--)
{
	brr[j] = arr[i];
	
	j++;
}

String stringArray = brr.toString();

System.out.println(Arrays.toString(brr));
}

}


