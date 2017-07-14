import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/making-anagrams
public class Solution {

    static int makingAnagrams(String s1, String s2){
        // sanity check:
        if (s1 == null || s2 == null)// || s1.length() != s2.length())
            return -1;
        
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
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        String s2 = in.next();
        int result = makingAnagrams(s1, s2);
        System.out.println(result);
    }
}