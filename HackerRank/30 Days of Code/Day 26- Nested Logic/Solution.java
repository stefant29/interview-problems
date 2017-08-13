import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-nested-logic
public class Solution {

    public static void main(String[] args) {
        /* read input from STDIN usint a scanner */
        Scanner in = new Scanner(System.in);
        /* read the return dates */
        int returnDay = in.nextInt();
        int returnMonth = in.nextInt();
        int returnYear = in.nextInt();
        /* read the return expected dates */
        int day = in.nextInt();
        int month = in.nextInt();
        int year = in.nextInt();
        /* compute the fine */
        int fine = 0;
        if (returnYear < year)
            fine = 0;
        else if (returnYear == year)
            if (returnMonth <= month)
                if (returnDay <= day)
                    fine = 0;
                else
                    fine = 15 * (returnDay - day);
            else
                fine = 500 * (returnMonth - month);
        else
            fine = 10000;
        /* print the fine to STDOUT */
        System.out.println(fine);
        /* close scanner */
        in.close();
    }
}