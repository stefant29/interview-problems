/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
     Node prev;
  }
*/

// https://www.hackerrank.com/challenges/reverse-a-doubly-linked-list
Node Reverse(Node head) {
    // if list is empty, return null
    if (head == null)
        return head;
    
    // keep track of the current node, the next and the previous pointer nodes
    Node crt = head;
    Node next = head.next;
    Node prev = null;
    
    // update the next and previous pointers
    head.next = prev;
    head.prev = next;
    
    // advance the head
    head = next;
    // iterate throught the list
    while (head != null) {
        // save the current head
        crt = head;
        // save the next and previous pointers
        next = head.next;
        prev = head.prev;
        
        // reverse the next and previous pointers
        head.prev = next;
        head.next = prev;
        
        // advance thehead
        head = next;
    }
    // return the last element
    return crt; 
}
