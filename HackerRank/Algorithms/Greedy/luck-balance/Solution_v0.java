import java.util.*;

// https://www.hackerrank.com/challenges/luck-balance
public class Solution {

    /* aditional class which stores a contest */
    static class Contest {
        private int luck;
        private boolean important;
        
        /* constructor */
        public Contest(int luck, boolean important) {
            this.luck = luck;
            this.important = important;
        }
        
        /* getter for luck */
        public int getLuck() {
        	return luck;
        }        
    }
    
    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();
        /* 
         * use two aditional data structures to store 
         * the important and unimportant contests
         */
        ArrayList<Contest> c1 = new ArrayList<Contest>();
        ArrayList<Contest> c2 = new ArrayList<Contest>();
        for (int contest = 0; contest < N; contest++) {
            /* read data for each contest */
            int L = in.nextInt();
            int T = in.nextInt();
            /* add the input into a new Contest */
            if (T == 1)
                c1.add(new Contest(L, true));
            else
                c2.add(new Contest(L, false));
        }
        
        /*
         * greedy approach: lose the contests with the biggest luck:
         * sort the contests by luck, then lose the K luckiest contests,
         * to increase the luck as much as possible
         */
        c1.sort(Comparator.comparing(Contest::getLuck).reversed());
        
        int totalLuck = 0;
        /* important contests: Leena must not lose more than K contests */
        for (int i = 0; i < c1.size(); i++) {
            /* Lena looses K contests; add their luck */
            if (K > 0) {
                totalLuck += c1.get(i).getLuck();
                K--;
            /* Lena is forced to win the remaining contests; substract their luck */
            } else
                totalLuck -= c1.get(i).getLuck();
        }
        /* these contest are not important, Lena can lose them; add their luck*/
        for (int i = 0; i < c2.size(); i++)
        		totalLuck += c2.get(i).getLuck();
        
        /* print total luck */
        System.out.println(totalLuck);
        
        /* close scanner */
        in.close();
    }
}