import java.util.*;

// https://www.hackerrank.com/challenges/minimum-distances
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int A[] = new int[n];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int A_i=0; A_i < n; A_i++){
            A[A_i] = in.nextInt();
            map.put(A[A_i], map.containsKey(A[A_i]) ? map.get(A[A_i]) + 1 : 1);
        }
        
        int min = Integer.MAX_VALUE;
        for (Iterator<Integer> it = map.keySet().iterator(); it.hasNext();) {
            int key = it.next();
            if (map.get(key) >= 2) {
                int crtMin = Integer.MAX_VALUE;
                int minI = Integer.MAX_VALUE;
                for (int i = 0; i < n; i++) 
                    if (A[i] == key) {
                        if (minI == Integer.MAX_VALUE)
                            minI = i;
                        else {
                            crtMin = i-minI;
                            minI = i;
                        }
                    }
                if (crtMin < min)
                    min = crtMin;
            }
        }
        
        if (min == Integer.MAX_VALUE)
            System.out.println("-1");
        else
            System.out.println(min);
        in.close();
    }
}