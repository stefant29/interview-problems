/*
  Merge two linked lists 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists
Node mergeLists(Node headA, Node headB) {
    Node head = new Node();
    Node copy = head;
    while (headA != null && headB != null) {
        head.next = new Node();
        if (headA.data < headB.data) {
            head.data = headA.data;
            headA = headA.next;
        } else { 
            head.data = headB.data;
            headB = headB.next;
        }
        head = head.next;
    }
    while (headA != null) {
        if (headA.next != null)
            head.next = new Node();
        head.data = headA.data;
        head = head.next;
        headA = headA.next;
    }
     while (headB != null) {
        if (headB.next != null)
            head.next = new Node();
        head.data = headB.data;
        head = head.next;
        headB = headB.next;
    }
    return copy;
}
