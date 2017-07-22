import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/repeated-string
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        long n = in.nextLong();
        int count_a = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a')
                count_a++;
        }
        long total = (n / (s.length())) * count_a;
        for (int i = 0; i < n % s.length(); i++) {
            if (s.charAt(i) == 'a')
                total++;
        }
        System.out.println(total);
    }
}
