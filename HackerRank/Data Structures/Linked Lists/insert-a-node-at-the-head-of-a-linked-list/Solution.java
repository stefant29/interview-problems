/*
  Insert Node at the beginning of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
// This is a "method-only" submission. 
// You only need to complete this method. 


// https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list
Node Insert(Node head,int x) {
    Node aux = new Node();
    aux.data = x;
    aux.next = null;
    
    if (head == null)
        return aux;
    
    aux.next = head;
    return aux;
}
