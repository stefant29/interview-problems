import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/compare-the-triplets
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a0 = in.nextInt();
        int a1 = in.nextInt();
        int a2 = in.nextInt();
        int b0 = in.nextInt();
        int b1 = in.nextInt();
        int b2 = in.nextInt();
        
        int AliceCounter = 0;
        int BobCounter = 0;
        if (a0 > b0)
            ++ AliceCounter;
        else if (a0 < b0)
            ++ BobCounter;
        
        
        if (a1 > b1)
            ++ AliceCounter;
        else if (a1 < b1)
            ++ BobCounter;

            
        if (a2 > b2)
            ++ AliceCounter;
        else if (a2 < b2)
            ++ BobCounter;
        
        System.out.println(AliceCounter + " " + BobCounter);    
    }
}
