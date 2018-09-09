package javaProgramm;
import java.util.Arrays;
import java.util.Scanner;

public class ReverseString {

	
public static void main(String[] args) {
	
			System.out.println("Enter the String");
			Scanner kb = new Scanner(System.in);
			String actual = kb.nextLine();
			System.out.println(actual);
			char arr[] = actual.toCharArray();
			
			char expected [] = new char[arr.length];
			for (int i =0,j=1; i <(arr.length); i++,j++)
				
			{
				System.out.print(arr[i]);
				expected[i] = arr[(arr.length-j)];
			}
			System.out.println();
			
				
	System.out.println("Suppose to give address of char array" + expected);



	System.out.println("Reversed Strinyg");
	for (int j = 0; j < (expected.length); j++) 
		System.out.print(expected[j]);
	System.out.println();
		
		
	System.out.println(Arrays.toString(expected));



		}

	}


				                
				
				
				
			
			
			
			
			
			



