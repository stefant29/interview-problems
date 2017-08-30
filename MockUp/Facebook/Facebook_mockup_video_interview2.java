import java.util.*;

// linkedlist -> true/false (palindrome)

class Solution {
  
  /* */
  public static boolean checkPalindrome(LinkedList<Integer> list) throws IllegalArgumentException {
    Stack<Integer> stack = new Stack<Integer>();
    
    if (list == null)
      throw new IllegalArgumentException();
    
    /* iterate through the list and add elements to the stack */
    for (Integer data : list) {
      stack.push(data);
    }
    
    /* compare each element with the elements from the stack */
    for (Integer data : list)
      if (stack.pop() != data)
        return false;
    
    /* the list is a palindrome */
    return true;
  }
  
  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<Integer>();
    list.add(1);
    list.add(2);
    list.add(3);
    list.add(2);
    list.add(1);
    System.out.println(list + "   is palindrome: " + checkPalindrome(list));
    
    
    LinkedList<Integer> list1 = new LinkedList<Integer>();
    list1.add(1);
    list1.add(2);
    list1.add(3);
    list1.add(3);
    list1.add(2);
    list1.add(1);
    System.out.println(list1 + "   is palindrome: " + checkPalindrome(list1));
    
    LinkedList<Integer> list2 = new LinkedList<Integer>();
    list2.add(1);
    list2.add(2);
    list2.add(3);
    list2.add(4);
    list2.add(1);
    System.out.println(list2 + "   is palindrome: " + checkPalindrome(list2));
    
  }
}
