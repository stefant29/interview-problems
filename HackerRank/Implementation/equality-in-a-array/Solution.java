import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/equality-in-a-array
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        HashMap<Integer, Integer> digits = new HashMap<Integer, Integer>();
        
        // read input into hashMap and update the elements value of the hashMap 
        //    with the number of appearances in the input
        for(int i = 0; i < n; i++) {
            int currentElement = in.nextInt();
            digits.put(currentElement, 
                       digits.containsKey(currentElement) ? digits.get(currentElement) + 1 : 1);
        }

        // store the maximum value and the key value for the digit 
        //    with the maximum number of appearances
        int max_value = Integer.MIN_VALUE;
        int key_value = Integer.MIN_VALUE;
        for (Iterator iterator = digits.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry pair = (Map.Entry)iterator.next();
            if ((int)pair.getValue() > max_value) {
                // update max value and key
                max_value = (int)pair.getValue();
                key_value = (int)pair.getKey();
            }
        }
        
        // count the digits that are different than the digit with most appearances
        int count = 0;
        for (Iterator iterator = digits.entrySet().iterator(); iterator.hasNext();) {
            Map.Entry pair = (Map.Entry)iterator.next();
            if ((int)pair.getKey() != key_value) {
                count += (int)pair.getValue();
            }
        }
        if (max_value == 1)
            System.out.println(n - 1);
        else
            System.out.println(count);
    }
}