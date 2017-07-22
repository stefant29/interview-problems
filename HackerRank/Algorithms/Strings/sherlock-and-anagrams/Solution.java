import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/sherlock-and-anagrams
public class Solution {

    static Boolean anagram(String s1, String s2){
        // sanity check:
        if (s1 == null || s2 == null)// || s1.length() != s2.length())
            return false;
        
        int count = 0;
        int[] no_of_letters = new int[26];
        // for each letter, increment if it is found in string 1,
        //    and decrement if found in string 2
        for (int i = 0; i < s1.length(); i++)
            no_of_letters[s1.charAt(i) - 'a']++;
        for (int i = 0; i < s2.length(); i++)
            no_of_letters[s2.charAt(i) - 'a']--;
        
        // add to the counter the letters that are in string 1 
        //     and that do not appear in string 2
        for (int i = 0; i < no_of_letters.length; i++)
            count += Math.abs(no_of_letters[i]);

        // return the number of changes needed to make the anagram
        return count == 0;
    }
    
    public static LinkedList<String> getSubstrings(String s) {
        // split the string in substrings
    	LinkedList<String> substrings = new LinkedList<String>();

		for(int c = 0 ; c < s.length() ; c++ )
			for(int i = 1 ; i <= s.length() - c ; i++)
				substrings.add(s.substring(c, c + i));
    	
        return substrings;
    }
    
    public static int getNumberOfAnagrams(LinkedList<String> substrings) {
    	int count = 0;
    	
        // go through the substrings and check if any two substrings are anagrams of each other
        for (String st_crt : substrings)
            for (String st : substrings)
            	if (st_crt != st && st_crt.length() == st.length() && anagram(st_crt, st)) 
            		count++;

    	return count / 2;
    }

    public static void main(String[] args) {
    	// read from STDIN
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	in.nextLine();
    	for (int test = 0; test < n; test++) {
    		String s = in.nextLine();
            // get a list of substrings
    		LinkedList<String> substrings = getSubstrings(s);
            // compute the number of anagrams
    		int result = getNumberOfAnagrams(substrings);
            System.out.println(result);
    	}
        // close scanner
    	in.close();
    }
}