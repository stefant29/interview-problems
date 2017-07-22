import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited
public class Solution {
    
    public static int getEnergyLevel(int[] c, int n, int k, int Energy) {
        // sanity check
        if(c.length == 0 || n == 0 || k == 0)
            return 0;
        
        int current_cloud = 0;
        do {
            // jump to the next cloud
            current_cloud = (current_cloud + k) % n;
            // use energy
            Energy --;
            
            // use more energy if thungercloud
            if (c[current_cloud] == 1)
                Energy -= 2;
            // stop when current cloud is the starting cloud
        } while (current_cloud != 0);
        // return current level of Energy
        return Energy;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int c[] = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        // get the current level of Energy with 100 initial Energy
        int result = getEnergyLevel(c, n, k, 100);
        System.out.println(result);
    }
}
