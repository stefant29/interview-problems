import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/funny-string
public class Solution {

    static String funnyString(String s){
        // iterate through the string and compute both differnces
        for (int i = 1; i < s.length(); i++) {
            //System.out.println(s.charAt(i) + "   " + s.charAt(i-1) + "         " + s.charAt(s.length() - i - 1) + "   " + s.charAt(s.length() - i) );
            // normal string
            int dif1 = (int)s.charAt(i) - (int)s.charAt(i-1);
            // reverse string
            int dif2 = (int)s.charAt(s.length() - i - 1) - (int)s.charAt(s.length() - i);
           // System.out.println(dif1 + "    " + dif2);

            // if the two difs are different, than return "Not Funny"
            if (Math.abs(dif1) != Math.abs(dif2))
                return "Not Funny";
        }
        // if the two difs are the same, then everything is good
        //    and we reach this return statement: "Funny"
        return "Funny";
    }

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            String result = funnyString(s);
            // write the result to STDOUT
            System.out.println(result);
        }
        // close the scanner
        in.close();
    }
}
