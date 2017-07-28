/*
  Delete Node at a given position in a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list
Node Delete(Node head, int position) {
    // for an empty list, return null
    if (head == null)
        return head;
    // if the first element must be deleted
    // return the next element
    if (position == 0)
        return head.next;
    
    // keep copy of the head, to be returned
    Node copy_head = head;
    
    // advance through the list to get to
    //   the a position before the deleted element
    while (head != null && position > 1) {
        position--;
        head = head.next;
    }
    
    // delete the element by changing the previous "next"
    // pointer, to the current next pointer
    head.next = head.next.next;
    
    // return the head of the list
    return copy_head;
}

