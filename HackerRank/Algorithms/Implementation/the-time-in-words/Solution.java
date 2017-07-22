import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/the-time-in-words
public class Solution {
    public static String intToString(int number) {
        // store units and 11-20 as string
        String[] numbers = { "zero", "one", "tow", "three", "four", "five", 
                            "six", "seven", "eight", "nine", "ten", "eleven", 
                            "twelve", "thirteen", "fourteen", "fifteen", "sixteen", 
                            "seventeen", "eighteen", "ninetheen", "twenty"};
        // store tens as string
        String[] tens = { "ten", "twenty", "thirty", "fourty", "fifty", "sixty", 
                        "seventy", "eighty", "ninety"};
        
        // if the number is known (part of numbers or tens) return it directly
        if (number < 20)
            return numbers[number];
        //  else, form the number using the string arrays
        else if (number < 60)
            return tens[number / 10-1] + " " + numbers[number % 10];
        
        return "Errr, not a good number!";
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int h = in.nextInt();
        int m = in.nextInt();
        
        // for each case, use a different formula
        if (m == 15)
            System.out.print("quarter past " + intToString(h));
        else if (m == 30)
            System.out.print("half past " + intToString(h));
        else if (m == 45)
            System.out.print("quarter to " + intToString(h+1));
        else if (m == 0)
            System.out.print(intToString(h) + " o' clock");
        else if (m == 1)
            System.out.print(intToString(m) + " minute past " + intToString(h));
        else if (m > 1 && m < 30)
            System.out.print(intToString(m) + " minutes past " + intToString(h));
        else if (m > 30 && m < 59)
            System.out.print(intToString(60 - m) + " minutes to " + intToString(h+1));
        else if (m == 59)
            System.out.print(intToString(60 - m) + " minute to " + intToString(h+1));
    }
}
