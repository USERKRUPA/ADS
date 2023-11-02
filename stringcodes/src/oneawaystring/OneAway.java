package oneawaystring;

import java.util.HashMap;
import java.util.Map;

public class OneAway {

	public static void main(String[] args) {
		String s1 = new String();
		String s2 = new String();
		boolean check = isOneAway("abc","abcd");
		boolean check2 = isOneAway("abcd","abcde");
		boolean check3 = isOneAway("a","a");
		boolean check4 = isOneAway("abc","bcc");
		
		System.out.println("abc ,abcd " +check);
		System.out.println("abcd , abcde "+check2);
		System.out.println("a , a "+check3);
		System.out.println("abc, bcc "+check4);
		

	}

	private static boolean isOneAway(String s1, String s2) {
		int count = 1;
		int sum = 0;
		Map<Character,Integer> strMap = new HashMap<>();
		if(s1.length()>=s2.length()) {
//			System.out.println(s1);
			for(int i=0;i<s1.length();i++) {
				if(strMap.containsKey(s1.charAt(i))) {
					strMap.put(s1.charAt(i), strMap.get(s1.charAt(i))+1);
				}
				else
					strMap.put(s1.charAt(i),1);
			}
//			System.out.println(s2);
//			System.out.println(strMap);
			for(int i=0;i<s2.length();i++) {
				if(strMap.containsKey(s2.charAt(i))) {
					strMap.put(s2.charAt(i), strMap.get(s2.charAt(i))-1);
				}
				else
				{
					strMap.put(s2.charAt(i), 1);
				}
					
				
			}
			for(Integer m:strMap.values()) {
				if(m<0)
					return false;
				sum += m;
			}
			
			if(sum<=1)
				return true;
		}
		else{
			for(int i=0;i<s2.length();i++) {
				if(strMap.containsKey(s2.charAt(i))) {
					strMap.put(s2.charAt(i), strMap.get(s2.charAt(i))+1);
				}
				else
					strMap.put(s2.charAt(i),1);
			}
			
			for(int i=0;i<s1.length();i++) {
				if(strMap.containsKey(s1.charAt(i))) {
					strMap.put(s1.charAt(i), strMap.get(s1.charAt(i))-1);
				}
				else
				{
					strMap.put(s1.charAt(i), 1);
				}
					
				
			}
			for(Integer m:strMap.values()) {
				if(m<0)
					return false;
				sum += m;
			}
//			System.out.println(strMap);
//			System.out.println(sum);
			if(sum<=1)
				return true;
		}
		
		
		return false;
	}

}
