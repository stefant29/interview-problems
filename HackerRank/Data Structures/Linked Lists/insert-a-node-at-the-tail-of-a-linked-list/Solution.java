/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list
Node Insert(Node head,int data) {
    // create the new Node element to be inserted
    Node newList = new Node();
    // set the data
    newList.data = data;

    // if the list is empty, just return the newly created element
    if (head == null)
        return newList;
    
    // make a backup of the head of the list
    Node orig = head;
    // traverse the list and stop at the last element
    while(head.next != null)
        head = head.next;

    // update the list with the new element,
    // at the end of the list
    head.next = newList;
    
    // return the new list
    return orig;
}
