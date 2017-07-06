import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/weighted-uniform-string
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
        HashSet<Integer> uniform_values = new HashSet<Integer>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int count = 0;
            while (i < s.length() && c == s.charAt(i)) {
                count++;
                i++;
            }
            if (count != 0)
                i--;
            int sum = 0;
            for (int j = 0; j < count; j++) {
                sum += (c - 'a' + 1);
                uniform_values.add(sum);
            }
        //    System.out.println("*****  " + uniform_values);
        }
        for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            if (uniform_values.contains(x))
                System.out.println("Yes");
            else 
                System.out.println("No");
        }
    }
}

