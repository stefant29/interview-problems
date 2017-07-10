import java.io.*;
import java.util.*;
import java.math.*;

// https://www.hackerrank.com/challenges/picking-numbers
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

        // store the maximum number of appearances for two consecutive numbers
        int maxSum = Integer.MIN_VALUE;
        // iterate through the hashMap once
        for (Iterator iterator1 = digits.entrySet().iterator(); iterator1.hasNext();) {
            Map.Entry pair1 = (Map.Entry)iterator1.next();
            
            // iterate through the rest of the elements of the hashMap
            for (Iterator iterator2 = digits.entrySet().iterator(); iterator2.hasNext();) {
                Map.Entry pair2 = (Map.Entry)iterator2.next();
                if (pair1 == pair2) {
                    if ((int)pair1.getValue() > maxSum)
                        maxSum = (int)pair1.getValue();
                    continue;
                }
                
                // use only consecutive numbers
                if (Math.abs((int)pair1.getKey() - (int)pair2.getKey()) > 1) 
                    continue;
                
                // compute the current sum and update the maxSum accordingly
                int currentSum = (int)pair1.getValue() + (int)pair2.getValue();
                if (currentSum > maxSum)
                    maxSum = currentSum;
            }
        }
        // print the result
        System.out.println(maxSum);
    }
}

/*
Test Case 6
100
66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66 66

result:
100
*/

/*
Test Case 7
100
4 97 5 97 97 4 97 4 97 97 97 97 4 4 5 5 97 5 97 99 4 97 5 97 97 97 5 5 97 4 5 97 97 5 97 4 97 5 4 4 97 5 5 5 4 97 97 4 97 5 4 4 97 97 97 5 5 97 4 97 97 5 4 97 97 4 97 97 97 5 4 4 97 4 4 97 5 97 97 97 97 4 97 5 97 5 4 97 4 5 97 97 5 97 5 97 5 97 97 97


result:
50
*/
