import java.util.*;

// https://www.hackerrank.com/challenges/java-stdin-and-stdout-1
public class Solution {

    public static void main(String[] args) {
        /* use scanner to read lines */
        Scanner scan = new Scanner(System.in);
        
        /* read first number and print it */
        int a = scan.nextInt();
        System.out.println(a);
        
        a = scan.nextInt();
        System.out.println(a);
        
        a = scan.nextInt();
        System.out.println(a);
        
        /* close scanner */
        scan.close();
    }
}
