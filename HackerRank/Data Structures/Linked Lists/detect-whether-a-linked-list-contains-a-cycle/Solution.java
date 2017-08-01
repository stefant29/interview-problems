/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

// https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle
boolean hasCycle(Node head) {
    // if the list is empty, it does not contain any cycles, so return false
    if (head == null)
        return false;
    
    // use two pointers, a slow one and a fast one:
    //   the fast one advances two nodes at a time; it will reach the end first
    //   the slow one advances normally, one node at a time
    Node fast = head.next;
    Node slow = head;
    
    // while the fast pointer reaches null, or it has no next node
    while (fast != null || fast.next == null) {
        // if the fast pointer reaches the slow pointer or its next node,
        //    then there is a cycle
        if (fast == slow || fast.next == slow)
            return true;

        // advance the fast and slow pointers with two, respectivly one node
        fast = fast.next.next;
        slow = slow.next;        
    }
    
    // return false since there is a null pointer
    return false;
}
