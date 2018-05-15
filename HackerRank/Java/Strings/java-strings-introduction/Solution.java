import java.util.*;

// https://www.hackerrank.com/challenges/java-strings-introduction
public class Solution {

    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);
        String A=sc.next();
        String B=sc.next();
        /* sanity checks */
        if (A == null || B == null) {
        	sc.close();
            return;
        }
        /* print to STDOUT */
        System.out.println(A.length() + B.length());
        System.out.println(A.compareTo(B) > 0 ? "Yes" : "No");
        System.out.println((char) (A.charAt(0)-'a'+'A') + A.substring(1,A.length()) + " " + (char) (B.charAt(0)-'a'+'A') + B.substring(1,B.length()));
        
        /* close scanner */
        sc.close();
    }
}
