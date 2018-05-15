import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/java-end-of-file
public class Solution {

    public static void main(String[] args) {
        /* use scanner to read from input */
        Scanner in = new Scanner(System.in);
        /* keep track of the line number */
        int lineNumber = 1;
        while(in.hasNext()) {
            /* 
             * print the line number, read a new line and print it
             * at the same time
             */
            System.out.println(lineNumber++ + " " + in.nextLine());
        }
        /* close scanner */
        in.close();
    }
}