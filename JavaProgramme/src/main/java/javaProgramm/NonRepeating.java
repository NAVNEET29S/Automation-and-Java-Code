package javaProgramm;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import java.util.Scanner;
import java.util.Set;

public class NonRepeating {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner kb = new Scanner(System.in);
				
				System.out.println("�nter the String");
				String original = kb.nextLine();
				char arr[] = original.toCharArray();
				Map<Character, Integer> map = new LinkedHashMap<>();
				for(int i=0;i<arr.length;i++) {
					if(map.containsKey(arr[i])) {
						map.put(arr[i], map.get(arr[i])+1);
					} else {
						map.put(arr[i], 0);
					}
				}
				
				System.out.println(map.toString());
				int l=0;
				Set<Entry<Character,Integer>> set = map.entrySet();
				for (Entry<Character, Integer> entry : set) {
					if(entry.getValue()==0) {
						if(l==2) {
							System.out.println(entry.getKey());
						}
						l++;
					}
				}
				
	}

}
