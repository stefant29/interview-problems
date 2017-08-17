import java.util.*;

// https://www.hackerrank.com/challenges/acm-icpc-team
public class Solution {
    
    public static int getMax(String[] s, int m) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int len = s.length;
        for (int i = 0; i < len-1; i++)
            for (int j = i+1; j < len; j++) {
            	/* count the total topics known by the two students*/
                int sum = 0;
                /* iterate through the binary string */
                for (int k = 0; k < m; k++)
                	/* and increment if one of the two knows the topic == 1 */
                    if (s[i].charAt(k) == '1' || s[j].charAt(k) == '1')
                        sum++;
                /* add the current sum to the list */
                list.add(sum);
            }

        /* sort the list to easily find the teams with most known topics */
        Collections.sort(list);

        /* count the team with the most known topics*/
        int i = list.size()-1;
        int max = list.get(i--);
        int count = 1;
        while (i >= 0 && list.get(i--) == max)
        	count++;

        /* print the maximum number of topics known */
        System.out.println(max);

        /* return the number of teams with the maximum number of topics knwon */
        return count;
    }

    public static void main(String[] args) {
    	/* read input */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();
        String[] students = new String[N];
        for (int i = 0; i < N; i++)
            students[i] = in.next();

        /* print the result to STDOUT */
        System.out.println(getMax(students, M));

        /* close scanner */
        in.close();
    }
}