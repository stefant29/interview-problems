package Strings;

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
}
