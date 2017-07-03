	import java.io.*;
	import java.util.*;
	import java.text.*;
	import java.math.*;
	import java.util.regex.*;
	
//	https://www.hackerrank.com/challenges/kangaroo
	public class Solution {
	
	    static String kangaroo(int x1, int v1, int x2, int v2) {
	        // Complete this function
	    	int step = 0;
	        if (x1 == x2 && v1 == v2)
	            return "YES";
	        else if (x1 < x2) {
	            if (v1 < v2)
	                return "NO";
	            else 
	            	while (true) {
	            		if (x1 + v1 * step == x2 + v2 * step)
	            			return "YES";
	            		else if (x1 + v1 * step > x2 + v2 * step)
	            			return "NO";
	            		step++;
	            	}
	        } else {
	            if (v2 < v1)
	                return "NO";
	            else 
	            	while (true) {
	            		if (x1 + v1 * step == x2 + v2 * step)
	            			return "YES";
	            		else if (x2 + v2 * step > x1 + v1 * step)
	            			return "NO";
	            		step++;
            	}
	        }
	    }
	
	    public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        int x1 = in.nextInt();
	        int v1 = in.nextInt();
	        int x2 = in.nextInt();
	        int v2 = in.nextInt();
	        String result = kangaroo(x1, v1, x2, v2);
	        System.out.println(result);
	    }
	}