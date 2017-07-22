import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/alternating-characters
public class Solution {

    static int alternatingCharacters(String s){
        // count the number of characters that need to be deleted
        int count = 0;
        // iterate through the string characters
        for (int i = 0; i < s.length() - 1;) {
            int old_count = count;
            // look for consecutive duplicates
            while (i < s.length() - 1 && s.charAt(i) == s.charAt(i+1)) {
                i++;
                // count the duplicates
                count++;
            }
            // move to the next character in the string
            if (old_count == count)
                i++;
        }
        // return the number of characters to be deleted
        return count;
    }

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        // read each test case's input
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            // get the result of the computation
            int result = alternatingCharacters(s);
            // print result to STDOUT
            System.out.println(result);
        }
    }
}
