import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/time-conversion
public class Solution {

    static String timeConversion(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.charAt(8) == 'A') {
            // convert hours from 12-hour to 24 hour
            int hours = Integer.valueOf(s.substring(0,2));
            // if hour is 12, convert to 00
            if (hours == 12)
                sb.append("00");
            // else just append the current number of hours 
            else 
                sb.append(s.substring(0,2));
            // then append the rest: minutes and seconds 
            //    to stringBuilder
            sb.append(s.substring(2,8));
        } else {
            // convert hours from 12-hour to 24 hour
            int hours = Integer.valueOf(s.substring(0,2));
            // if hour is 12, append it to stringBuilder
            if (hours == 12)
                sb.append(hours);
            // else just add 12 to current number of hours
            else
                sb.append(12 + hours);
            // add the rest: minutes and seconds
            sb.append(s.substring(2,8));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // read from STDIN
        Scanner in = new Scanner(System.in);
        String s = in.next();
        // compute the time conversion
        String result = timeConversion(s);
        // print result to STDOUT
        System.out.println(result);
        // close the scanner
        in.close();
    }
}
