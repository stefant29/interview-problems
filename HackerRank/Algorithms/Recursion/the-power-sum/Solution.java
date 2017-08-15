import java.util.*;

// https://www.hackerrank.com/challenges/the-power-sum
public class Solution {
	
    // return the nth root of a given number
	private static double nthRoot(int value, int n) {
		return Math.pow(value, 1.0 / n);
	}
	
    public static void main(String[] args) {
        // read input from STDIN
    	Scanner in = new Scanner(System.in);
    	int value = in.nextInt();
    	int pow = in.nextInt();
        int nthRoot = (int) Math.floor(nthRoot(value, pow));
    	int result = getNoSum(0, nthRoot, value, 0, pow);
        // write result to STDOUT
    	System.out.println(result);
        // close scanner
        in.close();
    }
    
    
    public static int getNoSum(int crt_sum, int nthRoot, int value, int crt_i, int pow) {
        // extreme cases:
        // if the sum is equal to the given value, return 1
    	if (crt_sum == value)
    		return 1;
        // if the crt_i is greater than nth root or the sum is bigger than the given value, return 0
    	if (crt_i >= nthRoot || crt_sum + (int)Math.pow(crt_i, pow) > value)
    		return 0;
    	
        // count the number of good combinations
    	int count = 0;
        // for all numbers until nth root
    	for (int i = crt_i + 1; i <= nthRoot; i++)
        	count += getNoSum(crt_sum + (int)Math.pow(i, pow), nthRoot, value, i, pow);
    	
    	return count;
    }
}