import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/beautiful-binary-string
public class Solution {

    // compute the minimum number of changes to make the string beautiful
    static int minSteps(int n, String s) {
        int count = 0;
        // iterate through the string
        for (int i = 0; i < n-2; i++)
            // find the "bad" sequence: "010"
            if (s.charAt(i) == '0' && s.charAt(i+1) == '1' && s.charAt(i+2) == '0')
                // if there is a next character:
                if (i + 3 < n) {
                    // if the next character is 1: 0101, change it to 0111,
                    //     to remove two bad sequences with one change of 0->1
                    if (s.charAt(i+3) == '1') {
                        count++;
                        // advance one more position than the normal case
                        i += 3;
                    // else, the next character is 0: 0100, change it to 0000
                    } else {
                        count++;
                        i += 2;
                    }
                } else {
                    // update counter and advance one position
                    count++;
                    i++;
                }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String B = in.next();
        int result = minSteps(n, B);
        System.out.println(result);
        
        // 0 1 0 0 0  -> 0 0 0 0 0
        // 0 1 0 1 0  -> 0 1 1 1 0
    }
}
