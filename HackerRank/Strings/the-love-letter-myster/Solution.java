import java.util.*;

// https://www.hackerrank.com/challenges/the-love-letter-mystery
public class Solution {

    // count the number of changes needed to transform the string in a palindrome
    static int theLoveLetterMystery(String s) {
        int count = 0;
        // itterate through the string from both start and end
        for (int i = 0; i < s.length() / 2; i++) {
            // find the start and the end of the current loop
            int start = (int)s.charAt(i);
            int end = (int) s.charAt(s.length() - i -  1);
            // add the difference between start and end:
            //    this represents the number of changes needed to tranform the string
            count += Math.abs((start - end));
        }
        // return the counter: the number pf changes
        return count;
    }

    public static void main(String[] args) {
        // use Scanner to read from STDIN
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = theLoveLetterMystery(s);
            // print to STDOUT the solution
            System.out.println(result);
        }
        // close the scanner
        in.close();
    }
}
