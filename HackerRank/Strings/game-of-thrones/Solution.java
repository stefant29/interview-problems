import java.util.*;

// https://www.hackerrank.com/challenges/game-of-thrones
public class Solution {

    static String gameOfThrones(String s){
        // count the number of apparitions of each letter in the string
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++)
            letters[s.charAt(i) - 'a'] ++;
        
        // if more than one letter has an odd number of apparitions
        //    return "no", because a palindrome cannot be formed
        int count = 0;
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] % 2 == 1) {
                if (count > 0)
                    return "NO";
                count ++;
            }
        }
        return "YES";
    }

    public static void main(String[] args) {
        // read with scanner from STDIN
        Scanner in = new Scanner(System.in);
        String s = in.next();
        // compute if the string can be changed to a palindrome
        String result = gameOfThrones(s);
        // print the result to STDOUT
        System.out.println(result);
        // close scanner
        in.close();
    }
}
