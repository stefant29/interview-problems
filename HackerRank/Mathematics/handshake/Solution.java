import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/handshake
public class Solution {
    
    // first  director shakes n-1 hands  (n-1 other directors)
    // second director shakes n-2 hands  (n-2 other directors)
    // third  director shakes n-3 hands  (n-3 other directors)
    // ...
    // last   director shakes n-n hands  (n-n other directors)
    // ===Total: (n-1) + (n-2) + (n-3) + ... + 1 + 0 = (n-1) * n / 2
    
    public static int getNoHandshakes(int N) {
        return N * (N-1) / 2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int a0 = 0; a0 < T; a0++){
            int N = in.nextInt();
            int result = getNoHandshakes(N);
            System.out.println(result);
        }
    }
}
