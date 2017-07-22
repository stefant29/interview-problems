import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/the-hurdle-race
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] height = new int[n];
        int max_hurdle_height = -1;
        for(int height_i=0; height_i < n; height_i++){
            height[height_i] = in.nextInt();
            if (max_hurdle_height < height[height_i])
                 max_hurdle_height = height[height_i];
        }
        if (max_hurdle_height - k > 0)
            System.out.println(max_hurdle_height - k);
        else
            System.out.println(0);
    }
}
