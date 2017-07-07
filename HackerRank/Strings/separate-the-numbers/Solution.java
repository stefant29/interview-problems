import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/separate-the-numbers
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        long first_num = -1;
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            Boolean found_sequence = false;
            if (s.length() == 1) {
                System.out.println("NO");
                continue;
            }

            for (int no_digits = 1; no_digits < s.length() / 2 + 1; no_digits++) {
                found_sequence = true;
                String result = s.substring(0, no_digits);
                first_num = Long.parseLong(result);
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int i = 0; i < s.length(); i++) {
                    sb.append(String.valueOf(first_num + i));
                    count += String.valueOf(first_num + i).length();
                    if (count == s.length()) {
                        break;
                    }
                    if (count > s.length()) {
                        break;
                    }
                }
                if (s.length() != sb.length()) {
                    found_sequence = false;
                    continue;
                }
                for (int i = 0; i < s.length(); i++) {
                    if (sb.charAt(i) != s.charAt(i)) {
                        found_sequence = false;
                        break;
                    }
                }
                if (found_sequence) { 
                    break;
                } 
            }
          
            if (found_sequence == true) 
                System.out.println("YES " + first_num);
            else 
                System.out.println("NO");
        }
    }
}

/*
10
429496729542949672964294967297
429496729542949672964294967296
429496729542949672964294967287
429496729542949672964294967197
42949672954294967296429496729
4294967295429496729642949672
429496729500000000000000000001
42949672950123456789
4294967295000010020030000456789
4294967295000102003004005


YES 4294967295
NO
NO
NO
NO
NO
NO
NO
NO
NO
*/

/*
6
1
2
33
4445
8889
8910

NO
NO
NO
YES 44
YES 88
YES 8
*/

/*
10
9007199254740992 9007199254740993
45035996273704964503599627370497
22517998136852482251799813685249
11258999068426241125899906842625
562949953421312562949953421313
90071992547409928007199254740993
45035996273704963503599627370497
22517998136852481251799813685249
11258999068426240125899906842625
562949953421312462949953421313


YES 9007199254740992
YES 4503599627370496
YES 2251799813685248
YES 1125899906842624
YES 562949953421312
NO
NO
NO
NO
NO
*/

/*
// VERSION 0
    import java.io.*;
    import java.util.*;
    import java.text.*;
    import java.math.*;
    import java.util.regex.*;

    public class Solution {
        // 1 0   1 1
        // 0 1   2 3

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int q = in.nextInt();
            for(int a0 = 0; a0 < q; a0++){
            //for(int a0 = 0; a0 < 1; a0++){
                String s = in.next();
                //System.out.println("---------------------------------------------------" + s);
                Boolean notGood = false;
                int first_num = -1;
                if (s.length() <= 1) {
                    System.out.println("NO");
                    continue;
                }
                // System.out.println(s.length() / 2 + "   " + s.length());
                for (int i = 1; i < s.length() / 2 + 2; i++) { // number of digits to try: 1,2,3
                    notGood = false;
                    //System.out.println("                                 i: " + i);
                    int sum_prev = 0, sum_current = 0, r = 0;
                    if (i > 1 && s.length() % 2 != 0) { // if the number of digits in s is odd
                        for (int k = 0; k < i - 1; k++) {
                            //System.out.println("-- " + s.charAt(k) + " --");
                            sum_current += (s.charAt(r+k)-'0') * Math.pow(10,i-k-1-1);
                        }
                        //System.out.println("sum_current:   " + sum_current + "   sum_prev:   " + sum_prev);
                        sum_prev = sum_current;
                        //System.out.println("sum_current:   " + sum_current +  "       sum_prev:   " + sum_prev);
                        if (first_num == -1)
                            first_num = sum_current;
                        r = r + i - 1;
                    }
                    for (; r < s.length(); r++) { 
                        //System.out.println("** " + s.charAt(r));
                        if (s.charAt(r) == '0') {
                        // System.out.println("-*-*- 1 not good Set to True     " + "sum_current:   " + sum_current + "       sum_prev:   " + sum_prev);
                            notGood = true;
                            break;
                        }

                        sum_current = 0;
                        for (int k = 0; k < i; k++) {
                            sum_current += (s.charAt(r+k)-'0') * Math.pow(10,i-k-1);
                        }
                        // un set de numere:
                        // System.out.println("sum_current:   " + sum_current + "       sum_prev:   " + sum_prev);
                        if (sum_current != sum_prev + 1) { // not good
                        // System.out.println("2 not good Set to True    " + "sum_current:   " + sum_current +  "       sum_prev:   " + sum_prev);
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
                        //System.out.println("break");
                        break;
                    }
                }
                if (notGood == false) 
                    System.out.println("YES " + first_num);
                else 
                    System.out.println("NO");
                //System.out.println("---------------------------------------------------");            
            }
        }
    }
*/
