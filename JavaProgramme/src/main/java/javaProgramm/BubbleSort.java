package javaProgramm;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner (System.in);
		System.out.println("Enter the number of int");
		int n  = kb.nextInt();
		int arr [] =  new int[n];
		for(int i =0 ; i< n ;i++)
		{
			System.out.println("Enter" +"  "+ (i+1) + "   number");
			arr[i] = kb.nextInt();			
		}
		
		System.out.println("Actaul integer");
		
		for (int i = 0; i < arr.length; i++) 
			System.out.println(arr[i]);
		
		int temp;
		for (int i = 0; i < (arr.length-1); i++) {
			for (int j = i+1; j < (arr.length); j++) {
				
				if(arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					
			   }
				
		}
			
		}
		
		System.out.println("Reversed integer");
		for (int j2 = 0; j2 < arr.length; j2++) 
		
		{
			
			System.out.println(arr[j2] );
			
		}

		
		

	}

}
