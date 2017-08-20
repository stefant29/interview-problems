import java.util.*;

// https://www.hackerrank.com/challenges/luck-balance
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        /* 
         * use two aditional data structures to store 
         * the luck for the important and unimportant contests 
         */
        ArrayList<Integer> c1 = new ArrayList<Integer>();
        ArrayList<Integer> c2 = new ArrayList<Integer>();
        for (int contest = 0; contest < N; contest++) {
            /* read data for each contest */
            int L = in.nextInt();
            int T = in.nextInt();
            /* 
             * depending on the contest type, add the luck 
             * in one of the two lists
             */
            if (T == 1)
            		c1.add(L);
            else
            		c2.add(L);
        }
        
        /*
         * greedy approach: lose the contests with the biggest luck:
         * sort the contests by luck, then lose the K luckiest contests,
         * to increase the luck as much as possible
         */
        c1.sort(new Comparator<Integer>() {
        		public int compare(Integer o1, Integer o2) {
        			return o1 - o2;
        		}
        }.reversed());
        
        int totalLuck = 0;
        /* important contests: Leena must not lose more than K contests */
        for (int i = 0; i < c1.size(); i++)
            /* Lena looses K contests; add their luck */
            if (K-- > 0)
                totalLuck += c1.get(i);
            /* Lena is forced to win the remaining contests; substract their luck */
            else
                totalLuck -= c1.get(i);
        /* these contest are not important, Lena can lose them; add their luck*/
        for (int i = 0; i < c2.size(); i++)
        		totalLuck += c2.get(i);
        
        /* print total luck */
        System.out.println(totalLuck);
        
        /* close scanner */
        in.close();
    }
}


