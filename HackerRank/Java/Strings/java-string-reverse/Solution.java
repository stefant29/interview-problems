import java.util.*;

// https://www.hackerrank.com/challenges/java-string-reverse
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        int len = A.length();
        int i = 0;
        /* compare start with end */
        for (; i < len / 2; i++) 
            if (A.charAt(i) != A.charAt(len-i-1)) 
                break;
        
        /* print response */
        System.out.println(i == len/2 ? "Yes" : "No");
        
        /* close scanner */
        sc.close();
    }
}
