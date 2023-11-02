package anagrams;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ValidAnagrams {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = new String();
		String str2 = new String();
		System.out.println("Enter the two string");
		str1 = sc.next();
		str2 = sc.next();
		boolean check = isAnagram(str1,str2);
		
		if(check)
			System.out.println(str1+" "+str2+" are anagrams");
		else
			System.out.println(str1+" "+str2+" are not anagrams");
		
		
		
	}
	public static boolean isAnagram(String str1, String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		int sum =0;
		Map<Character,Integer> strMap = new HashMap<>();
		
		for(int i=0;i<s1.length;i++) {
			if(strMap.containsKey(s1[i])) {
				strMap.put(s1[i],strMap.get(strMap.get(s1[i])+1));
			}else
				strMap.put(s1[i], 1);
		}
		//System.out.println(strMap);
		for(int i=0;i<s2.length;i++) {
			if(strMap.containsKey(s2[i])) {
				strMap.put(s2[i],strMap.get(s2[i])-1);
				
			}else
				strMap.put(s2[i], 1);
		}
		
		for(Integer m:strMap.values()) {
			sum+=m;
		}
		
		if(sum==0)
			return true;
		
		
		
		
		
		
		return false;
        
    }

}
