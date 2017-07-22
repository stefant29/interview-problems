import java.util.*;

// https://www.hackerrank.com/challenges/sherlock-and-array
public class Solution {
    
    static int getSum(int[] a, int start, int end) {
        int sum = 0;
        for (int i = start; i < end; i++)
            sum += a[i];
        return sum;
    }

    // trivial solution
    static String solve2(int[] a) {
        for (int i = 1; i < a.length - 1; i++) {
            if (getSum(a, 0, i) == getSum(a, i+1, a.length))
                return "YES";
        }
        return "NO";
    }

    // more efficient solution
    static void solve(int[] a) {
    	if (a.length <= 1) {
        	System.out.println("YES");
        	return;
    	}
    	
    	int startLeft = 0;
    	int endLeft = a.length / 2;
    	int startRight = a.length / 2 + 1;
    	int endRight = a.length;
    			
        int sumLeft = getSum(a, startLeft, endLeft);
        int sumRight = getSum(a, startRight , endRight);
        
		Boolean result = false;
		result = aux2(a, startLeft, endLeft, startRight, endRight, sumLeft, sumRight, 0);
		if (result)
			System.out.println("YES");
		else
			System.out.println("NO");
    }
    
    private static Boolean aux2(int[] a, int startLeft, int endLeft, int startRight, int endRight, int sumLeft, int sumRight, int direction) {
    	// if the two sums are equal, then we found the answer -> return true
    	if (sumLeft == sumRight)
    		return true;
    	// if the left and the right indexes are equal -> return false, we reached the end of the list
    	if (startLeft >= endLeft || startRight >= endRight)
    		return false;
    	
    	if (sumLeft > sumRight) {
    		// if the direction is oposite than the previous one, return false
			if (direction == -1)
				return false;
			// else, move one slot to the left
			return aux2(a, startLeft, endLeft-1, startRight-1, endRight, sumLeft-a[endLeft-1], sumRight+a[endLeft], 1);
    	} else {
    		// if the direction is oposite than the previous one, return false
			if (direction == 1)
				return false;
			// else, move one slot to the right
			return aux2(a, startLeft, endLeft+1, startRight+1, endRight, sumLeft+a[endLeft], sumRight-a[startRight], -1);
    	}
	}

    public static void main(String[] args) {
    	// read input from STDIN
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        // for each test case, read the input
        for(int a0 = 0; a0 < T; a0++){
            int n = in.nextInt();
            int[] a = new int[n];
            for(int a_i=0; a_i < n; a_i++)
                a[a_i] = in.nextInt();
            // solve the problem
        	solve(a);
        }
        // close the scanner
        in.close();
    }
}
