/*
  Print elements of a linked list in reverse order 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse
void ReversePrint(Node head) {
    // for end of the list, just return
    if (head == null)
        return;
    // call for the next node
    ReversePrint(head.next);
    // only after the child nodes finish, print the current data
    System.out.println(head.data);
}
