import java.util.*;

// https://www.hackerrank.com/challenges/big-sorting
public class Solution {

    public static void main(String[] args) {
        /* use scanner to read input from STDIN */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        /* read the big numbers in a string array */
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++)
            unsorted[unsorted_i] = in.next();

        /* sort the array using a custom comparator */
        Arrays.sort(unsorted, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /* compare the length of the strings */
                if (o1.length() == o2.length()) {
                    /* if they are the same, compare lexicographically */
                    return o1.compareTo(o2);
                } else if (o1.length() > o2.length())
                    /* first string's length is bigger, return 1 */
                    return 1;
                else
                    /* first string's length is smaller, return -1 */
                    return -1;
            }
        });
        
        /* print the array */
        print(unsorted);
        
        /* close scanner */
        in.close();
    }
    
    /* print an array of strings */
    public static void print(String[] unsorted) {
        int len = unsorted.length;
        for(int i=0; i < len; i++)
            System.out.println(unsorted[i]);
    }
}
