import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-binary-numbers
public class Solution {

    public static void main(String[] args) {
        /* read from stdin */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int remainder = -1;
        /* use a Queue to store the binary representation of the given number */
        Queue<Integer> binaryNumber = new LinkedList<Integer>();
        while (n > 0) {
            remainder = n % 2;
            n /= 2;
            binaryNumber.add(remainder);
        }
        /* keep a streak of numbers of 1 in the binary representation */
        int streak = 0;
        int max = -1;

        while (!binaryNumber.isEmpty()) {
            if (binaryNumber.poll() == 1)
                streak++;
            else
                streak = 0;
            if (max < streak)
                max = streak;
        }
        System.out.println(max);
    }
}

