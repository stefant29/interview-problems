/*
  Compare two linked lists A and B
  Return 1 if they are identical and 0 if they are not. 
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// https://www.hackerrank.com/challenges/compare-two-linked-lists
int CompareLists(Node headA, Node headB) {
    // This is a "method-only" submission. 
    // You only need to complete this method 
    Node A = headA, B = headB;
    // while both Nodes point to not null elements in the list,
    while (A != null && B != null) {
        // compare the data and return 0 if it is different
        if (A.data != B.data)
            return 0;
        // move to the next elements in each list
        A = A.next;
        B = B.next;
    }
    
    // if one list has not reached the end, return 0
    if (A != null || B != null)
        return 0;
    
    // otherwise, the lists are equal, return 1
    return 1;
}
