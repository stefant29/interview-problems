import java.util.*;

// https://www.hackerrank.com/challenges/icecream-parlor
public class Solution {

    public static void main(String[] args) {
        // read input from STDIN
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for (int test = 0; test < test_cases; test++) {
            int money = sc.nextInt();
            int n = sc.nextInt();

            // use a hashset for speed
            int[] prices = new int[n];
            Boolean found = false;
            for (int i = 0; i < n; i++) {
                prices[i] = sc.nextInt();

                // if a solution is found, then stop searching, only read the prices from STDIN
                if (found || prices[i] >= money)
                	continue;

                // search for the remaining price substracted from Money
                int index = getIndexOf(money-prices[i], prices, i);
                if (index != -1) {
                	// print result to STDOUT and mark "found" as true
                    System.out.println((Math.min(index, i)+1) + " " + (Math.max(index, i)+1));
                    found = true;
                }
            }
        }
        // close scanner
        sc.close();
    }


    // return the index of a given price from an array of prices
    // the index must be different than a given "crt" index
	private static int getIndexOf(int price, int[] prices, int crt) {
		for (int i = 0; i < prices.length; i++)
			if (prices[i] == price && crt != i)
				return i;
		return -1;
	}
}
