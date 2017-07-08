import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/counting-valleys
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        String steps = in.nextLine();
        
        int height = 0, no_valleys = 0;
        //System.out.println(steps);
        for (int i = 0; i < n; i++) {
            if (steps.charAt(i) == 'U') {
                height ++;
                if (height == 0)
                    no_valleys++;
            }
            else if (steps.charAt(i) == 'D')
                height --;
            else {
                System.out.println("Input not valid!");
                return;
            }
        }
        System.out.println(no_valleys);
    }
}