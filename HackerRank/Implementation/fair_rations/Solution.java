import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/fair-rations
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int B[] = new int[N];
        int odd = 0, count = 0;
        for(int B_i=0; B_i < N; B_i++){
            B[B_i] = in.nextInt()%2;
            if (B[B_i] % 2 == 1)
                ++odd;
        }
        if (odd % 2 == 1)
            System.out.println("NO");
        while (odd > 0) {
            for (int i = 0; i < N; i++) {
                if (B[i] == 1) {
                    B[i] = 0;
                    odd--;
                    if (B[i+1] == 1) {
                        B[i+1] = 0;
                        --odd;
                    }
                    else { 
                        B[i+1] = 1;
                        ++odd;
                    }
                    count+=2;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
