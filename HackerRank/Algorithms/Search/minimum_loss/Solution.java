import java.util.*;

// https://www.hackerrank.com/challenges/minimum-loss/problem
public class Solution {

	// aditional class to store the data for a house
	static class House implements Comparable<House>{
		int year;
		long price;
		
		// constructor with year and price
		public House(int year, long price) {
			this.year = year;
			this.price = price;
		}

		@Override
		public int compareTo(House o) {
			if (this.price > o.price)
				return 1;
			else if (this.price < o.price)
				return -1;
			return 1;
		}

		@Override
		public String toString() {
			return "[year=" + year + ", price=" + price + "]";
		}
	}

	// trivial solution
	public static int getSmallestLoss(int n, int[] prices) {
		int loss = Integer.MAX_VALUE;

		// search the smallest loss by comparing each price
		// with the rest of the prices and compute the loss
		for (int i = 0; i < n - 1; i++)
			for(int j = i + 1; j < n; j++) {
				int crt_loss = prices[j] - prices[i];
				if (crt_loss < 0 && loss > Math.abs(crt_loss))
					loss = Math.abs(crt_loss);
			}

		// return value of loss
		return loss;
	}


	// more efficient implementation
	public static long getSmallestLoss2(int n, long[] prices) {
		// create a list of houses to store the prices and the years
		House[] houses = new House[n];
		for (int i = 0; i < n; i++)
			houses[i] = new House(i, prices[i]);

		// sort the houses
		Arrays.sort(houses);

		// compare the prices of the houses two by two in order to find
		// the smallest loss (smallest difference between two prices)
		long loss = Integer.MAX_VALUE;
		for (int i = 0; i < n-1; i++) {
			// the buying price should be the price of the house with the 
			// smaller year and the selling price - the house with the bigger year
			long buy_price = houses[i].year == Math.min(houses[i].year, houses[i+1].year) ? houses[i].price : houses[i+1].price;
			long sell_price = houses[i].year == Math.max(houses[i].year, houses[i+1].year) ? houses[i].price : houses[i+1].price;

			// compute the loss
			long crt_loss = buy_price - sell_price;

			// not a loss, the selling price is greater than the buying price
			if (crt_loss < 0)
				continue;

			// update the loss
			if (loss > crt_loss)
				loss = crt_loss;
		}

		return loss;
	}

	public static void main(String[] args) {
		// read input from STDIN
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		// reat the list of prices
		long[] prices = new long[n];
		for (int i = 0; i < n; i++)
			prices[i] = in.nextLong();
		// compute the smallest loss
		long loss = getSmallestLoss2(n, prices);
		// print the result to the STDOUT
		System.out.println(loss);
		// close the scanner
		in.close();
	}

}
