/* 5. Print out the pairs of a number and the nearest greater number to its right in an array. 
Example: given [1,2,5,1,2,6], print out (1,2), (2,5), (5,6), (2,6)

[6]
crt = null

[6]
crt = 2
peek = 6 => (2, 6)
[2, 6]

[2, 6]
crt = 1
peek = 2 => (1, 2)
[1, 2, 6]

[1, 2, 6]
crt = 5
peek = 1 -> pull 1, pull 2 (while peek element < 5)
peek = 6 => (5, 6)


[5, 6]
(2, 5)

[1, 5, 6]
(1, 2)
*/

import java.util.Stack;

class Solution {
  
  public static void findPairs(int[] arr) {
    Stack<Integer> stack = new Stack<Integer>();
    int peekElement = -1;
    int index = -1;
    
    /*sanity check*/
    if (arr == null || arr.length < 2)
      return;
    
    index = arr.length - 1;
    stack.push(arr[index--]);
    
    while ( index >= 0 ) {
      int crtElement = arr[index--];
      while (!stack.isEmpty() && crtElement > stack.peek())
        stack.pop();
      if (!stack.isEmpty())
        System.out.println("(" + crtElement + ", " + stack.peek() + ")");
      stack.push(crtElement);
    }
  }
    
  public static void main(String[] args) {
    int[] arr = {1,2,5,1,2,6};
    findPairs(arr);
  }
}
