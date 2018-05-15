import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/java-loops
class Solution{
    public static void main(String []argh) {
        /* read input from STDIN using scanner */
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            /* read input for each test case */
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            
            for (int k = 1; k <= n; k++) {
                int crtSum = a;
                /* compute partial sum */
                for (int j = 0; j < k; j++)
                    crtSum += Math.pow(2,j) * b;
                /* print partial sum */
                System.out.print(crtSum + " ");
            }
            System.out.println();
        }
        /* close scanner */
        in.close();
    }
}
