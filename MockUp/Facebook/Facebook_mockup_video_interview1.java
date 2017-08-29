/* given two arrays of integers and a maximum value, write a method to find the number
 * of unique pairs that sum up to a value smaller than the given maximum
 */
// 2 arrays of integers
// [1, -2, 3, -2]   (sort) => [-2, -2, 1, 3]    // O(NlogN)
// [3, -5, 1, 7]    (sort) => [7, 3, 1, -5]
// 4

import java.util.*;

public class Solution {

  public static int getNoPairs(int[] arr1, int[] arr2, int max) {
    int noOfPairs = 0;

    /* sanity checks */ 
    if (arr1 == null || arr2 == null)
      return 0;
    if (arr1.length < 1 || arr2.length < 1)
      return 0;

    /* sort the arrays */
    Arrays.sort(arr1);
    Arrays.sort(arr2);
     
    /* use two indexes to iterate through the two lists */
    int i = 0;
    int j = arr2.length - 1;
     
    /* iterate through the first list:
     *   first list is sorted: the elements will be smaller at start 
     */
    for (; i < arr1.length; i++) {
      /* 
       * iterate through the second list from the end:
       *   the first elements (from end) will be bigger:
       *   match the small element from first list with the big element
       *   from second list to maximize the number of pairs smaller than max
       */
      for (; j >= 0; j--) {
        /*
         * if sum is smaller than max, increment number of pairs 
         *   and move to the next element: decrease the index j 
         */
        if (arr1[i] + arr2[j] < max) {
          noOfPairs++;
          j--;
          /* a pair was found, break the current loop */
          break;
        }
      }
  }
   
  return noOfPairs;
 }
  
  public static void main(String[] args) {
    /* try some examples */
    int[] arr1 = {1, -2, 3, -2};
    int[] arr2 = {};

    int[] arr3 = null;
    int[] arr4 = {3, -5, 1, 7};

    int[] arr5 = {1, -2, 3, -2};
    int[] arr6 = {3, -5, 1, 7};

    int max = 4;
    System.out.println("result 1&2: " + getNoPairs(arr1, arr2, max));
    System.out.println("result 3&4: " + getNoPairs(arr3, arr4, max));
    System.out.println("result 5&6: " + getNoPairs(arr5, arr6, max));
  }
}