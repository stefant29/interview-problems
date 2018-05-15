import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/java-static-initializer-block
public class Solution {

    public static int B;
    public static int H;

    public static boolean flag = true;

    static {
        /* use scanner to read from input */
        Scanner in = new Scanner(System.in);
        /* keep track of the line number */
        B = in.nextInt();
        H = in.nextInt();
        if (B <= 0 || H <= 0) {
            System.out.println("java.lang.Exception: Breadth and height must be positive");
            flag = false;
        }
        /* close scanner */
        in.close();
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }
        
    }//end of main

}//end of class