import java.util.*;

// https://www.hackerrank.com/challenges/append-and-delete
public class Solution {
    
    /*
     * find the number of equal characters 
     * in the two strings, starting from index 0
     */
    public static int getNoCharsEqual(String s, String t) {
        int len = Math.min(s.length(), t.length());
        
        for (int i = 0; i < len; i++)
            /* return the index where the strings differ */
            if (s.charAt(i) != t.charAt(i))
                return i;

        return 0;
    }

    public static void main(String[] args) {
        /* read input from STDIN using a scanner */
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String t = in.next();
        int k = in.nextInt();
        
        /* get the number of equal characters in the two words */
        int noOfEqualChars = getNoCharsEqual(s, t);
        /* compute the remaining number of characters in each word */
        int remainderS = t.length() - noOfEqualChars;
        int remainderT = s.length() - noOfEqualChars;
        int remainder = remainderS + remainderT;
        /* one word can be removed entirely and the other can be inserted */
        if (s.length() + t.length() < k)
            System.out.println("Yes");
        /* deleting and inserting takes exactely k steps */
        else if (remainder == 0)
            System.out.println("Yes");
        /* the remainder is smaller than k */
        else if (remainder <= k && (k-remainder) % 2 == 0) {
            System.out.println("Yes");
        } else
            System.out.println("No");
        
        /* close scanner */
        in.close();
    }
}
