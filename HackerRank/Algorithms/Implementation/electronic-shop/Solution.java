import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/electronics-shop
public class Solution {
    
    //s:  12
    //keyboard: 2 3 4 8 6 5 1   => 1 2 3 4 5 6 8
    //drives:   6 1 5 7 3 2 8   => 8 7 6 5 3 2 1
    
    static int getMoneySpent(int[] keyboards, int[] drives, int s){
        // sanity check
        if (s <= 0 || keyboards.length == 0 || drives.length == 0)
            return -1;

        //1. sort keyboards in increasing order
        Arrays.sort(keyboards);
        //2. sort drives in decreasing order
        Integer[] drives2 = new Integer[drives.length];
        for (int i = 0; i < drives.length; i++)
            drives2[i] = drives[i];
        Arrays.sort(drives2, Collections.reverseOrder());
       
        
        int max_value = -1;
        //3. itterate throught pairs of keyboards and drives to find the biggest sum smaller than s
        for (int keyboard_price : keyboards) {
            for (int drive_price : drives2) {
                int current_sum = keyboard_price + drive_price;
                if (current_sum < s && current_sum > max_value) {
                    max_value = current_sum;
                    break;
                }
                if (current_sum == s)
                    return s;
            }
        }
        
        return max_value;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int n = in.nextInt();
        int m = in.nextInt();
        int[] keyboards = new int[n];
        for(int keyboards_i=0; keyboards_i < n; keyboards_i++){
            keyboards[keyboards_i] = in.nextInt();
        }
        int[] drives = new int[m];
        for(int drives_i=0; drives_i < m; drives_i++){
            drives[drives_i] = in.nextInt();
        }
        //  The maximum amount of money she can spend on a keyboard and USB drive, or -1 if she can't purchase both items
        int moneySpent = getMoneySpent(keyboards, drives, s);
        System.out.println(moneySpent);
    }
}
