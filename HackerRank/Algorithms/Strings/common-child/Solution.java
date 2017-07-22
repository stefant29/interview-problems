import java.util.*;

// https://www.hackerrank.com/challenges/common-child
public class Solution {
	
    public static boolean checkIfExists(String s, String substr) {
    	int i = 0, j = 0;
    	while (i < s.length() && j < substr.length()) {
    		if (s.charAt(i) != substr.charAt(j)) {
    			i++;
    			continue;
    		}
    		i++;
    		j++;
    	}
    	if (j == substr.length())
    		return true;
    	return false;
    }
    
    public static void removeChars(String s, HashSet<Integer> chars) {
    	for (int i = 0; i < s.length(); i++) {
    		if (!chars.contains(i))
    			System.out.print(s.charAt(i));
    	}
    	System.out.println();
    }
    
    public static int getMaxNumberOfSimilar(String s1, String s2) {
    	int count = 0;
    	for (int digits_del = 0; digits_del < s1.length(); digits_del--) {
    		for (int i = 0; i < s1.length(); i++) {
				HashSet<Integer> set = new HashSet<Integer>();
	    		for (int j = 0; j < digits_del; j++) {
	    	    	set.add(i + j);
	    		}
	    		if (checkIfExists(s1, s2))
	    			count++;
    		}
    	}
    	
    	return count;
    }
    public static HashSet<Integer> aux(HashSet<Integer> set, String s, int n) {
    	if (n == 0)
    		return set;
    	
    	for (int i : set)
    		if (set.add(i))
    			break;
    	
    	return aux(set, s, n-1);
    }
    
  //digits_del = 0    // abcd
  //digits_del = 1    // bcd acd abd abc
  //digits_del = 2    // cd  
  //digits_del = 3    // a b b a 
    
    // abcd    &    abdc   => abc
    
    
    
    public static void main(String[] args) {
    	System.out.println(checkIfExists("abcdef", "afc"));
    	String s = "abcd";
    	
    	HashSet<Integer> set = new HashSet<Integer>();
    	set.add(0);
    	set.add(1);
    	set.add(2);
//    	removeChars(s, set);
    	System.out.println(set);
    	//aux(set);
    	System.out.println(set);
   
    }
}