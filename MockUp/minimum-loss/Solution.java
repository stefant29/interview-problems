import java.util.*;

// https://www.hackerrank.com/challenges/minimum-loss/problem
public class Solution {

	static class House implements Comparable<House>{
		int year;
		int price;
		
		public House(int year, int price) {
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
	}

	public static int getSmallestLoss(int n, int[] prices) {
		int loss = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++)
			for(int j = i + 1; j < n; j++) {
				int crt_loss = prices[j] - prices[i];
				if (crt_loss < 0 && loss > Math.abs(crt_loss))
					loss = Math.abs(crt_loss);
			}

		// return value of loss
		return loss;
	}

	public static int getSmallestLoss2(int n, int[] prices) {
		House[] houses = new House[n];
		for (int i = 0; i < n; i++)
			houses[i] = new House(i, prices[i]);

		// sort the houses
		Arrays.sort(houses);

		int loss = Integer.MAX_VALUE;
		for (int i = 0; i < n-1; i++) {
			int crt_loss = houses[i+1].price - houses[i].price;
			if (loss > crt_loss && houses[i+1].year > houses[i].year)
				loss = crt_loss;
		}

		return loss;
	}

	public static void main(String[] args) {
		
		
	}

}


/*
list of prices for houses for n years
price of house in the ith year is pi

rules: purchase and resell the house at minimum loss
- cannot sell a house before buying it
- house cannot be sold at a price greater or equal than the price purchased -> loss
- house cannot be sold in the same year it was purchased

1. buy the house at moment i (year i)
2. sell the house with smallest loss at moment j (with j > i)

return the samallest loss

6
3 5 1 6 2 7
1 2 3 4 5 6

loss = 2


//i: 0       1      ...    n-2
//j: 1->n   2->n 		  n-1 -> n-1

*/

