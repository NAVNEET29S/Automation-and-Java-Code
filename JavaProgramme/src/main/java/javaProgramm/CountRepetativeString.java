package javaProgramm;

import java.util.Scanner;

public class CountRepetativeString {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter the String");
		String x = kb.nextLine();
		char arr[] = x.toCharArray();
		int counter=0;
		
		for (int i = 0; i < (arr.length); i++) {
			for (int j = (1+i); j < arr.length; j++) {
				if (arr[i] ==arr[j])
					counter++;
			}
			
			System.out.println("number of "+ "  "+arr[i]+"  in" + "  "+ x + "  is"+ "="+ counter);
			
		}
		
		
		
		
		
		
	}
		 
	}