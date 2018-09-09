package collectionFramework;
import java.util.*;
import java.util.Map.Entry;

public class HashMap1 {

	public static void main(String[] args) {
		
		HashMap<Integer , String> map = new HashMap<Integer , String>();
		
		map.put(1, "navneet1");
		map.put(2, "navneet2");
		map.put(3, "navneet3");
		map.put(4, "Navneet1");
		
		System.out.println(map.entrySet());
		System.out.println(map.keySet());
		//System.out.println(map.size());	
		
	Set key=	map.keySet();
	
	Set key_value = map.entrySet();
	
	System.out.println(key);
	System.out.println(key_value);
	
	//Iterate over key and value pair
	
 
 for(Map.Entry m: map.entrySet()){  
	 
	 
	 System.out.println(m.getKey()+" "+m.getValue());  
 }
	   
	   
	}
}
