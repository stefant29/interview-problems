import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/anagram
public class Solution {

    static int anagaram(String s){
        // sanity check:
        if (s == null || s.length() % 2 != 0)
            return -1;
        
        int count = 0;
        int[] no_of_letters = new int[26];
        // for each letter, increment if it is found in string 1,
        //    and decrement if found in string 2
        for (int i = 0; i < s.length() / 2; i++) {
            no_of_letters[s.charAt(i) - 'a']++;
            no_of_letters[s.charAt(s.length() - i - 1) - 'a']--;
        }
        
        // add to the counter the letters that are in string 1 
        //     and that do not appear in string 2
        for (int i = 0; i < no_of_letters.length; i++)
            if (no_of_letters[i] > 0) 
                count+=no_of_letters[i];

        // return the number of changes needed to make the anagram
        return count;
    }

    public static void main(String[] args) {
        // read the input from STDIN using a scanner
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = anagaram(s);
            // print to STDOUT the number of changes needed to transform
            //    string 1 in string 2
            System.out.println(result);
        }
        // close the scanner
        in.close();
    }
}
