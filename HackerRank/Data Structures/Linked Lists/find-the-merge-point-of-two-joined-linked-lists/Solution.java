/*
  Find merge point of two linked lists
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists
int FindMergeNode(Node headA, Node headB) {
    // save the head of B
    Node backup_B = headB;
    
    // iterate through list A
    while (headA != null) {
        // restore the head of B
        headB = backup_B;
        // iterate through list B
        while (headB != null) {
            // if both pointers point to the same node, return its data
            if (headA == headB)
                return headA.data;
            
            // advance head of B
            headB = headB.next;
        }
        // advance hdead of A
        headA = headA.next;
    }
    return -1;
}
