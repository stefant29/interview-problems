package problems;

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
}
