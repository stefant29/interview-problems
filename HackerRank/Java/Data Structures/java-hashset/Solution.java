import java.util.*;

// https://www.hackerrank.com/challenges/java-hashset
public class Solution {

 public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        String [] pair_left = new String[t];
        String [] pair_right = new String[t];
        
        for (int i = 0; i < t; i++) {
            pair_left[i] = in.next();
            pair_right[i] = in.next();
        }
        HashSet<String> set = new HashSet<String>();
        int count = 0;
        for (int i = 0; i < t; i++) {
            if (set.add(pair_left[i]+","+pair_right[i]))
                count++;
            System.out.println(count);
        }
        in.close();
 }
}