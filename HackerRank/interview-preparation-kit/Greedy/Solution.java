import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the getMinimumCost function below.
    static int getMinimumCost(int k, int[] c) {
        // k = nr of friends       c = costs       n = number of flowers to be bought
        int n = c.length - 1;
        int minCost = 0;
        int noFlowers = 0;

        // sort prices in ascending order
        Arrays.sort(c);

        while (n >= 0) {
            // use first the most expensive flowers
            // leave the cheap ones for when there are many flowers bought
            // to minimise price computation
            for (int i = n; i >= 0 && i >= n - k + 1; i--) {
                minCost += c[i] * (noFlowers + 1);
            }
            noFlowers++;
            n-=k;
        }

        return minCost;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] c = new int[n];

        String[] cItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int cItem = Integer.parseInt(cItems[i]);
            c[i] = cItem;
        }

        int minimumCost = getMinimumCost(k, c);

        bufferedWriter.write(String.valueOf(minimumCost));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
