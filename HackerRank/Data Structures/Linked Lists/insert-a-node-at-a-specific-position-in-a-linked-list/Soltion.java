/*
  Insert Node at a given position in a linked list 
  head can be NULL 
  First element in the linked list is at position 0
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
// https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list
Node InsertNth(Node head, int data, int position) {
    Node copy_head = head;
    Node newNode = new Node();
    newNode.data = data;
    newNode.next = null;
    
    if (position == 0) {
        newNode.next = head;
        return newNode;
    }
    
    while (head.next != null && position > 1) {
        position--;
        head = head.next;
    }
    
    newNode.next = head.next;
    head.next = newNode;
        
    return copy_head;
}
