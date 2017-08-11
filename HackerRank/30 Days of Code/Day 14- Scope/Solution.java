import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-scope
class Difference {
  	private int[] elements;
  	public int maximumDifference;

  	// Add your code here
    public Difference(int[] elements) {
        this.elements = elements;
    }

    public void computeDifference() {
        int len = elements.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            if (min > elements[i])
                min = elements[i];
            if (max < elements[i])
                max = elements[i];
        }
        this.maximumDifference = Math.abs(max - min);
    }

} // End of Difference class

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();

        Difference difference = new Difference(a);

        difference.computeDifference();

        System.out.print(difference.maximumDifference);
    }
}

