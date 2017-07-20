import java.util.*;

// https://www.hackerrank.com/challenges/sherlock-and-array
public class Solution {
    
    static int getSum(int[] a, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++)
            sum += a[i];
        return sum;
    }

    static String solve2(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if (getSum(a, 0, i) == getSum(a, i+1, a.length))
                return "YES";
        }
        return "NO";
    }
    
    
    static void solve(int[] a) {
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < a.length/2; i++) {
            count1 += a[i];
            count2 += a[a.length/2 + i];
        }
        
        Boolean result = false;
        if (count1 > count2)
            result = aux(a, a.length / 2 - 1, -1);
        else
            result = aux(a, a.length/2, 1);
        
        if (result)
        	System.out.println("YES");
        else
        	System.out.println("NO");
    }
    
    static Boolean aux(int[] a, int index, int last_index) {
    	//System.out.println("-----" + index + "-----");
        if (index <= 0 || index >= a.length-1)
            return false;
        
        int sumLeft = getSum(a, 0, index);
        int sumRight = getSum(a, index+1, a.length);
        
        if (sumLeft == 0 || sumRight == 0)
        	return false;

        if (sumLeft == sumRight)
            return true;
        else if (sumLeft > sumRight)
        	if (last_index == 1)
        		return false;
        	else
        		return aux(a, index-1, -1);
        else
        	if (last_index == -1)
        		return false;
        	else
        		return aux(a, index+1, 1);
    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            if (n == 1)
            	System.out.println("YES");
            else
            	solve(a);
        }
        in.close();
    }
}
