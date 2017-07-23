import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/game-with-cells
public class Solution {

    // add padding to matrix to form a matrix of dime multiple of 2
    public static int getNextMultiple(int i) {
        if (i%2 == 1)
            return i/2+1;
        return i/2;
    }
    
    // print the number of supply drops needed
    public static void printNoSupplyDrops(int n, int m) {
        System.out.println(getNextMultiple(n) * getNextMultiple(m));
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        printNoSupplyDrops(n,m);
    }
}
