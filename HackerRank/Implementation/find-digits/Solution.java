import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/find-digits
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int n_orig = n;
            int num_of_digits = 0;
            while (n > 0) {
                int digit = n % 10;
                if (digit == 0) {
                    n = n / 10;
                    continue;
                }
                if (n_orig % digit == 0)
                    num_of_digits++;
                n = n / 10;
            }
            System.out.println(num_of_digits);
        }
    }
}
