import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/strange-advertising
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        int no_friends = 5 / 2;
        sum += no_friends;
        for (int i = 2; i <= n; i++) {
            no_friends *= 1.5;  //triples the number of friends
                                // then split it in half => * (3/2) = * 1.5
            sum += no_friends;
        }
        System.out.println(sum);
    }
}