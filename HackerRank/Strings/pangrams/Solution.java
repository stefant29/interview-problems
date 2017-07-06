import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/pangrams
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        int sum = 0;
        HashSet<Integer> found_letters = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                found_letters.add((int)s.charAt(i) - 32);
            } else if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                found_letters.add((int)s.charAt(i));
            }
        }
        if (found_letters.size() != 26)
            System.out.println("not pangram");
        else 
            System.out.println("pangram");
    }
}
