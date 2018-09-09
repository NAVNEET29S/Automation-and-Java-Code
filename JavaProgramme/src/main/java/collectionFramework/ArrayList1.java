package collectionFramework;

import java.util.*;
public class ArrayList1  
{

	public static void main(String[] args)
	{	 
		    ArrayList<String> name = new ArrayList<String>();
		    name.add("Amir");
		    name.add("Arnie");
		    name.add("Beth");
		    name.add("Lucy");
		    name.add("Amir");
		    
		    //printing all the names in the Set
		    int i1=1;
		    for(String names : name)
		    {
		    	
		     System.out.println("In Enriched For loop"+ "name"+i1+""+names);
		    	i1++;
		    }
		    
		   for (int i = 0; i < name.size(); i++) 
		   
		   {
			String names = name.get(i);
	         System.out.println("IN For normal for loop "+names);
			
		    }
		    
				
	} 
				
			
		    
		
}
		
		                          
			                         
		
		
	
