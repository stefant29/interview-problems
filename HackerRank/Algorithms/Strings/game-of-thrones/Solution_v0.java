import java.util.*;

// https://www.hackerrank.com/challenges/game-of-thrones
public class Solution {
	
	static void print(String s, int[] letters) {
		System.out.print(s + "  ");
        for (int i = 0; i < letters.length; i++) {
            System.out.print(letters[i] + ", ");
        }
        System.out.println();
	}
	
	static Boolean aux(int[] letters) {

		Boolean modif = false;
		print("la inceput", letters);
                    
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] <= 1)
                continue;
            for (int j = i + 1; j < letters.length; j++) {
                if (letters[j] <= 1)
                    continue;
                if (letters[i] == letters[j]) {
                    letters[i] = letters[j] = 0;
                    modif = true;
                }
            }
        }
        
		print("dupa egal ", letters);
        
        for (int i = 0; i < letters.length - 1; i++) {
            if (letters[i] == 0)
                continue;
            for (int j = i + 1; j < letters.length; j++) {
            	if (letters[j] <= 1 && letters[i] <= 1)
				    continue;
				if (letters[j] != 0) {
				     int min = Math.min(letters[i], letters[j]);
				     letters[i] -= min;
				     letters[j] -= min;
				     modif = true;
				 }
            }
        }
        
		print("dupa minus", letters);
		
		if (modif)
			return aux(letters);

        return true;
        
	}

    static String gameOfThrones(String s){
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++)
            letters[s.charAt(i) - 'a'] ++;
     
        aux(letters);
        
        print("dupa fct  ", letters);
        
        int count = 0;
        Boolean foundOne = false;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
            	System.out.println("found: " + i + "  " + letters[i]);
            	if (foundOne) {
                    //System.out.println("return NO because count is " + count);
                    return "NO";
                }
                count += letters[i];
                foundOne = true;
            }
        }


    //    System.out.println("count: " + count);
   //     if (count % 2 == 1 || count == 0)
            return "YES";

      //  return "NO";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = gameOfThrones(s);
        System.out.println(result);
        in.close();
    }
}

// a a a b b b b
// b b a a a b b
