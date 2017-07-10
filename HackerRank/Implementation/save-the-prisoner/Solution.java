import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/save-the-prisoner
public class Solution {

    static Long saveThePrisoner(Long n, Long m, Long s) {
        // sanity checks
        if (m == 0 || s == 0 || n == 0)
            return Long.valueOf(0);

        // compute the result: use modulo for sum bigger than n
        Long result = (m + s - 1) % n;
        // if the result is 0, then return the the n-th prisoner
        return (result == 0) ? n : result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            Long n = in.nextLong();
            Long m = in.nextLong();
            Long s = in.nextLong();
            Long result = saveThePrisoner(n, m, s);
            System.out.println(result);
        }
    }
}
