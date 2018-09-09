package javaProgramm;

import java.io.IOException;
import java.util.Scanner;

public class StringArray {

	public static void main(String[] args) throws IOException {
		// Write a program to compare the string one by one in the array
		
		Scanner kb = new Scanner(System.in);

		System.out.println("How many string");
	      int x= kb.nextInt();
		
		String arr[] = new String[x];
	
		for (int i = 0; i < arr.length;i++)
		{
			System.out.println("Enter " + (i+1) + " String");
			
//			arr[i] = kb.nextLine();
			arr[i] =kb.next();
			
	    }
		
		
		System.out.println("Enter the sting which need to be searched");
		String search = kb.nextLine();
		int counter=0;
		
		for (int j = 0; j < arr.length; j++) {
			if(search.equalsIgnoreCase(arr[j]))
			{
				System.out.println("String found at"+ " " +(j+1)+ ":Position" );
				counter++;
			}
			
		}
	         
		if(counter == 0)
		
			System.out.println("The String you enetered is not matching");
				
		
		

				

	}

}
