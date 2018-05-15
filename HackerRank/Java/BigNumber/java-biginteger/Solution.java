import java.io.*;
import java.util.*;
import java.math.BigInteger;

// https://www.hackerrank.com/challenges/java-biginteger
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger number1 = new BigInteger(in.nextLine());
        BigInteger number2 = new BigInteger(in.nextLine());
        System.out.println(number1.add(number2));
        System.out.println(number1.multiply(number2));
        in.close();
    }
}