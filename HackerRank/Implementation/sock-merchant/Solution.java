import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/sock-merchant
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        int total_socks = 0;
        HashSet<Integer> socks = new HashSet<Integer>();
        for(int ar_i = 0; ar_i < n; ar_i++){
            int sock = in.nextInt();
            if (!socks.remove(sock)) {
                total_socks++;
                //System.out.println("Added sock: " + sock);
                socks.add(sock);
            }
        }
        System.out.println(total_socks - socks.size());
    }
}
