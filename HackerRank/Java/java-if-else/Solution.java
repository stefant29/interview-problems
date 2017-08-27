import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-if-else
public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();            
        String ans = "";
        if(n % 2 == 0 && ((n >= 2 && n <= 5) || n > 20))
          ans = "Not Weird";
        else 
          ans = "Weird";

        System.out.println(ans);
        
        sc.close();
    }
}
