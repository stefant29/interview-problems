import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/extra-long-factorials
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        BigInteger fact = new BigInteger("1");
        for (int i = n; i > 0; i--)
            fact = fact.multiply(BigInteger.valueOf(i));
        System.out.println(fact);
    }
}
