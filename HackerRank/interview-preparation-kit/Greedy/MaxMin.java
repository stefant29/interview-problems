import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
        // greedy -> sort array
        Arrays.sort(arr);

        if (arr.length < k) {
            return -1;
        }

        // get minimum unfairness from first possible subarray 0->k-1
        int min = arr[k-1]-arr[0];
        // search for minimum unfairness in 1->k, 2->k+1 ...
        for (int i = 1; i <= arr.length - k; i++) {
            // min unfairness == max (last elem of subarray) - min (first elem of subarray)
            int crtMin = arr[i+k-1] - arr[i];
            // update min
            if (min > crtMin) {
                min = crtMin;
            }
        }
        return min;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
