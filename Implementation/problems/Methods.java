package problems;

import java.util.HashSet;
import java.util.Hashtable;

public class Methods {
	/*
	 * Find the nonrepeated character in a string
	 * ex: total  -> o
	 * ex: teeter -> r
	 */
	
	/*
	 * trivial solution: 
	 * time complexity: O(n^2) - quadratic
	 * space complexity: O(1) - constant
	 */
	public char findNonrepeatedTrivial(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			boolean found = false;
			for (int j = 0; j < s.length(); j++) {
				if (c == s.charAt(j) && i != j) {
					found = true;
					break;
				}
			}
			if (!found)
				return c;
		}
		return s.charAt(s.length()-1);
	}
	/*
	 * better time complexity: O(n) == two traversals through the string
	 * space complexity: O(26) == constant complexity == the hashtable stores
	 *  the values for each letter in the string
	 */
	public char findNonrepeated(String s) {
		/*
		 * use a hashtable to store each character and how many times
		 *  it appears in the string
		 */
		Hashtable<Character, Integer> characters = new Hashtable<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if (!characters.containsKey(c))
				characters.put(c, 1);
			else
				characters.replace(c, characters.get(c)+1);
		}
		
		/*
		 * go through the string again and search a value of 1 in the hashtable;
		 */
		for (int i = 0; i < s.length(); i++)
			if (characters.get(s.charAt(i)) == 1)
				return s.charAt(i);
		
		return '\0';
	}
	
	
	
	
	
	
	
	
	/*
	 * return a new string, where every character from "remove" 
	 * is deleted in the string s
	 * ex: "Battle of the Vowels" + "aeiou"  ->  "Bttle f th Vwls"
	 */
	/*
	 * time complexity: O(n)
	 * space complexity: O(n)
	 */
	public String removeCharsTrivial(String s, String remove) {
		/*
		 * use a hashset to keep the characters from "remove" for fast lookup
		 */
		HashSet<Character> rem = new HashSet<Character>();
		for (int i = 0; i < remove.length(); i++)
			rem.add(remove.charAt(i));
		
		/*
		 * use a StringBuilder to store all chracters from "s" 
		 * that are different than the characters in "remove"
		 */
		StringBuilder newString = new StringBuilder();
		
		/*
		 * iterate through string "s" and if the character 
		 * isn't part of "remove", add it to "newString"
		 */
		for (int i = 0; i < s.length(); i++) {
			if (!rem.contains(s.charAt(i)))
				newString.append(s.charAt(i));
		}
		
		return newString.toString();
	}
	
	/*
	 * time complexity: O(n)
	 * space complexity: O(n). If the string were already an array of chars, 
	 *   then space complexity would be O(1), constant
	 */
	public String removeChars(String s, String remove) {
		/* use a hashset to keep the characters from "remove" for fast lookup */
		HashSet<Character> rem = new HashSet<Character>();
		for (int i = 0; i < remove.length(); i++)
			rem.add(remove.charAt(i));
		
		/* convert the string into an array to be able to move its elements */
		char[] chars = s.toCharArray();
		/* 
		 * use two indexes for start of the free zone to copy
		 * and end, the current position in the string
		 */
		int start = 0;
		int end = 0;
		while (end < s.length())
			if (!rem.contains(s.charAt(end)))
				chars[start++] = chars[end++];
			else
				end++;
		
		/* 
		 * return a new string composed of the chars, from index 0 to "start",
		 * which is the last copied character in the string
		 */
		return new String(chars, 0, start);
	}
	
	
	
	
	
	
	
}
