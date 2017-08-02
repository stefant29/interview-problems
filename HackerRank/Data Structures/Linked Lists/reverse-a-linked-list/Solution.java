/*
  Reverse a linked list and return pointer to the head
  The input list will have at least one element  
  Node is defined as  
  class Node {
     int data;
     Node next;
  }
*/

// https://www.hackerrank.com/challenges/reverse-a-linked-list
Node Reverse(Node head) {
    // keep 2 Node pointers: next, the next node
    Node next = head.next;
    // and prev, the previous node
    Node prev = head;
    
    // set the next of the first node to null
    head.next = null;
    // then move forward, to the next node
    head = next;
    // iterate through the list
    while (head != null) {
        // save the next
        next = head.next;
        // set the current next to the previous node
        head.next = prev;
        // advance the previous node to be the current one
        prev = head;
        // advance the current node to be the next one
        head = next;
    }
    // return the prev node, which is actually the current node
    return prev;
}
