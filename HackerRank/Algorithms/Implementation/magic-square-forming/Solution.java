import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/magic-square-forming
public class Solution {
	/* array with all the possible magic squares */
	public static int[][][] allSquares = { 
				{ {4, 9, 2}, {3, 5, 7}, {8, 1, 6} },
				{ {2, 9, 4}, {7, 5, 3}, {6, 1, 8} },
				{ {2, 7, 6}, {9, 5, 1}, {4, 3, 8} },
				{ {4, 3, 8}, {9, 5, 1}, {2, 7, 6} },
				{ {6, 1, 8}, {7, 5, 3}, {2, 9, 4} },
				{ {8, 1, 6}, {3, 5, 7}, {4, 9, 2} },
				{ {8, 3, 4}, {1, 5, 9}, {6, 7, 2} },
				{ {6, 7, 2}, {1, 5, 9}, {8, 3, 4} }
			};
	
    /* 
     * find the smallest cost by comparing the given matrix 
     * with each magic square defined in "allSquares" 
     */
	public static int getMinimumCost(int[][] mat) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < allSquares.length; i++) {
            /* find the cost between mat and the magic square at index i */
			int result = getCost(i, mat, min);
		    /* update the minimum cost */
			if (result < min)
				min = result;
		}
		return min;
	}
	
    /* compare the given matrix with the matrix at index "index" in allSquares */
	public static int getCost(int index, int[][] mat, int crt_min) {
		int count = 0;
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++) {
                /* count the differences between matrixes */
				count += Math.abs(mat[i][j] - allSquares[index][i][j]);
                /*
                 * if the number of differences is greater than 
                 * a given minimum, there is no need to continue 
                 */
				if (count > crt_min)
					return count;
			}
		return count;
	}
	
	public static void main (String[] args) {
		/* use scanner for reading the input */
		Scanner in = new Scanner(System.in);
		int[][] mat = new int[3][3];
		/* read the matrix */
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				mat[i][j] = in.nextInt();
		
		/* find the minimum number of turnings to form a magic square*/
		int result = getMinimumCost(mat);
		System.out.println(result);
		
		/* close scanner */
		in.close();
	}
}