import java.util.*;

// https://www.hackerrank.com/challenges/luck-balance
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        ArrayList<Integer> c1 = new ArrayList<Integer>();
        ArrayList<Integer> c2 = new ArrayList<Integer>();
        for (int contest = 0; contest < N; contest++) {
            int L = in.nextInt();
            int T = in.nextInt();
            if (T == 1)
            		c1.add(L);
            else
            		c2.add(L);
        }
        
        c1.sort(new Comparator<Integer>() {
        		public int compare(Integer o1, Integer o2) {
        			return o1 - o2;
        		}
        }.reversed());
        
        int totalLuck = 0;
        for (int i = 0; i < c1.size(); i++)
            if (K-- > 0)
                totalLuck += c1.get(i);
            else
                totalLuck -= c1.get(i);

        for (int i = 0; i < c2.size(); i++)
        		totalLuck += c2.get(i);
        
        System.out.println(totalLuck);
        
        in.close();
    }
}


