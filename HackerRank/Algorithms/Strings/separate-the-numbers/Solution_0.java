import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/separate-the-numbers
public class Solution {
    // 1 0   1 1
    // 0 1   2 3

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        //for(int a0 = 0; a0 < q; a0++){
        for(int a0 = 0; a0 < 1; a0++){
            String s = in.next();
            Boolean notGood = false;
            int first_num = -1;
            if (s.length() <= 1) {
                System.out.println("NO");
                continue;
            }
//            System.out.println(s.length() / 2 + "   " + s.length());
            for (int i = 1; i < s.length() / 2 + 1; i++) { // number of digits to try: 1,2,3
                System.out.println("                                 i: " + i);
                int sum_prev = 0, sum_current = 0;
                for (int r = 0; r < s.length(); r++) {  
                    sum_current = 0;
                    for (int k = 0; k < i; k++) {
                        sum_current += (s.charAt(r+k)-'0') * Math.pow(10,i-k-1);
                    }
                    // un set de numere:
                    System.out.println("sum_current:   " + sum_current + 
                                       "       sum_prev:   " + sum_prev);
                    if (sum_current < sum_prev) { // not good
                        notGood = true;
                        first_num = -1;
                        break;
                    }
                    sum_prev = sum_current;
                    if (first_num == -1)
                        first_num = sum_current;
                    r = r + i - 1;
                }
                if (notGood == false) {
                    System.out.println("break");
                    break;
                }
            }
            if (notGood == false) 
                System.out.println("YES " + first_num);
            else 
                System.out.println("NO");
        }
    }
}
