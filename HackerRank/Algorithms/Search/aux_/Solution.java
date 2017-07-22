import java.util.*;

public class Solution {

    // search for two numbers that sum to a given number
    public static void main(String[] args) {
        // read input from STDIN
        Scanner sc = new Scanner(System.in);
        int test_cases = sc.nextInt();
        for (int test = 0; test < test_cases; test++) {
            int money = sc.nextInt();
            int n = sc.nextInt();

            // use a hashset for speed
            HashSet<Integer> prices = new HashSet<Integer>();
            Boolean found = false;
            for (int i = 0; i < n; i++) {
                int price = sc.nextInt();

                // if a solution is found, then stop searching, only read the prices
                if (found)
                	continue;

                if (prices.contains(money-price)) {
                	// print result to STDOUT and mark "found" as true
                    System.out.println(Math.min(price, money-price) + " " + Math.max(price, money-price));
                    found = true;
                }

                // add the current price to the list of prices
                prices.add(price);
            }
        }
        // close scanner
        sc.close();
    }
}
