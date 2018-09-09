package javaProgramm;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		
		System.out.println("�nter the String");
		String original = kb.nextLine();
		
		char arr[] = original.toCharArray();
		
		
		
	int length = arr.length;
	
	
	int j=0;
	while (j<length)
	{
		if(arr[j]==arr[length-1]){
			
		} else {
			System.out.println("String is not Palidrome");
			break;
		}
		
		j++;
		length--;
		
		if(j>length) {
			System.out.println("String is Palidrome");
		}
	}
	
		
	/*if (Arrays.toString(arr1).equals(Arrays.toString(arr)))
	{
		System.out.println("String is Palidrome");
	} else 
		System.out.println("String is not Palidrome");*/
		
		
		
		

	}

}
