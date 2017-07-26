import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/caesar-cipher-1
public class Solution {
    public static void encrypt(String s, int k) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                // compute the next position by applying the Caesar cipher
                // which rotates the current letter k positions to the right
                // If the position overflows, start from the beginning
                int move = (k + c-'a')%26 + 'a';
                // print the curent letter, after converting it
                System.out.print((char)move);
            } else if (c >= 'A' && c <= 'Z') {
                // same algorithm, but for capital letters
                int move = (k + c-'A')%26 + 'A';
                System.out.print((char)move);
            } else
                // if the crt character is not a letter, just print it
                System.out.print(c);
        }
    }
    
    public static void main(String[] args) {
        // read input from STDIN
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String s = in.next();
        int k = in.nextInt();
        // encrypt the message
        encrypt(s, k);
        //close scanner
        in.close();
    }
}
