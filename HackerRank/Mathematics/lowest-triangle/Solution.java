import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/lowest-triangle
public class Solution {

    static int lowestTriangle(int base, int area) {
        // compute the minimum height for the given area and base
        int height = (int)Math.ceil(2.0 * area / base);
        return height;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int base = in.nextInt();
        int area = in.nextInt();
        int height = lowestTriangle(base, area);
        System.out.println(height);
    }
}
