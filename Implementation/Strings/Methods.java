package Strings;

import javax.xml.soap.Node;

public class Methods {
	/**https://www.geeksforgeeks.org/return-maximum-occurring-character-in-the-input-string/
	 * Write an efficient function to return maximum occurring character 
	 * in the input string e.g., if input string is “test” then function should return ‘t’.
	 */
	public static Character maxOccuringChar(String s) {
		int[] chars = new int[256];
		int maxIndex = -1, maxCount = -1;
		for (int i = 0; i < 256; i++)
			chars[i] = 0;
		
		for (Character c : s.toCharArray())
			chars[c]++;
		
		for (int i = 0; i < 256; i++)
			if (maxCount < chars[i]) {
				maxCount = chars[i];
				maxIndex = i;
			}
		
		return (char) maxIndex;
	}
	
	

	static int diff;
	public static void modifyToPalindrome() {
		/**
		 Input : str = “geeks”  Q = 2
	        query 1: i1 = 3 ,i2 = 0, ch = ‘e’
	        query 2: i1 = 0 ,i2 = 2 , ch = ‘s’
		 */
		diff = 0;
		String str = "geeks";
		for(int k = 0; k < str.length() / 2; k++)
			if (str.charAt(k) != str.charAt(str.length() - k - 1))
				diff++;
		
		str = modifyString(str, 3, 0, 'e');
		str = modifyString(str, 0, 2, 's');
		
		System.out.println("---------");
		
		/**
		Input : str = “jasonamat”  Q = 3
		        query 1: i1 = 3, i2 = 8 ch = ‘j’
		        query 2: i1 = 2, i2 = 6 ch = ‘n’
		        query 3: i1 = 3, i2 = 7 ch = ‘a’
		Output :
		       query 1: “NO”
		       query 2: “NO”
		       query 3: “YES”
       	*/
		diff = 0;
		str = "jasonamat";
		for(int k = 0; k < str.length() / 2; k++)
			if (str.charAt(k) != str.charAt(str.length() - k - 1))
				diff++;
		
		str = modifyString(str, 3, 8, 'j');
		str = modifyString(str, 2, 6, 'n');
		str = modifyString(str, 3, 7, 'a');
	}
	
	public static void modifyDiff(String str, int i, Character ch) {
		if (str.length() % 2 == 1 && i == str.length() / 2 ||
				i > str.length() || i < 0)
			return;
		
		if (str.charAt(i) == str.charAt(str.length() - i - 1) && ch != str.charAt(i))
			diff++;
		
		if (str.charAt(i) != str.charAt(str.length() - i - 1) && ch == str.charAt(str.length() - i - 1))
			diff--;
	}
	
	public static String modifyString(String str, int i, int j, Character ch) {
		StringBuilder sb = new StringBuilder(str);
		modifyDiff(sb.toString(), i, ch);
		sb.setCharAt(i, ch);

		modifyDiff(sb.toString(), j, ch);
		sb.setCharAt(j, ch);
				
		if (diff == 0)
			System.out.println("Palindrome: " + sb.toString());
		else
			System.out.println("NOPE: " + sb.toString());
		
		return sb.toString();
	}
	
	  static long get_no_digits(long i) {
		  long no_digits = 0;
	        while (i > 0) {
	            no_digits++;
	            i /= 10;
	        }
	        return no_digits;
	    }
	    
	    static long get_digits(long _pow, long no_digits, long l, long m) {
	    	long new_n = 0;
	        // remove digits from n until we get to position h
	        while (no_digits-- > m) {
	            if (_pow < 0)
	                return -1;
	            _pow /= 10;
	        }
	        int digits = 0;
	        // construct the new number with h-l digits
	        while (m >= l) {
	            if (_pow < 0)
	                return -1;
	            new_n += _pow % 10 * Math.pow(10, digits++);
	            m--;
	            _pow /= 10;
	        }
	        return new_n;
	    }
	    
	   
}
