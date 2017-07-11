import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/cut-the-sticks
public class Solution {

    public static void main(String[] args) {
        // read from STDIN the input
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[] = new int[n];
        int minStick = Integer.MAX_VALUE;
        for(int arr_i=0; arr_i < n; arr_i++){
            arr[arr_i] = in.nextInt();
            // update the value for the min length stick
            if (arr[arr_i] < minStick)
                minStick = arr[arr_i];
        }
        do {
            int numberOfSticksCut = 0;
            int newMinStick = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                // cut the sticks by minStick length
                if (arr[i] != 0) {
                    numberOfSticksCut++;
                    arr[i] -= minStick;
                }
                // compute the next min value 
                if (arr[i] != 0 && arr[i] < newMinStick)
                    newMinStick = arr[i];
            }
            // update global minStick
            minStick = newMinStick;
            // print at STDOUT the result
            System.out.println(numberOfSticksCut);
        } while (minStick != Integer.MAX_VALUE);
        
        in.close();
    }
}
