import java.util.*;

// https://www.hackerrank.com/challenges/chocolate-feast
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        int trips = in.nextInt();
        for (int trip = 0; trip < trips; trip++) {
            int n = in.nextInt(); // amount of dollars
            int c = in.nextInt(); // price of a chocolate
            int m = in.nextInt(); // number of wrappers to exchange for 1 chocolate

            int leftOver = n / c;
            int total = n / c;
            
            while(m <= leftOver) {
            	leftOver -= m;
            	total++;
                leftOver++;
            }

            System.out.println(total);
        }
        in.close();
    }
}