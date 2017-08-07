import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in  = new Scanner(System.in);
        int tests = in.nextInt();
        for (int test = 0; test < tests; test++) {
            int A = in.nextInt();
            int B = in.nextInt();
            int rootA = (int)Math.sqrt(A);
            int rootB = (int)Math.sqrt(B);
            if (rootA==rootB && rootA*rootA == A) {
                System.out.println("1");
                continue;
            }
            int result = rootB-rootA;
            if (result == 0) {
                if (rootA*rootA == A)
                    result++;
                if (rootB*rootB == B)
                    result++;
            }
            System.out.println(result);
        }
    }
}