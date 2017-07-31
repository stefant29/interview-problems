/*
Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/

// https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list
Node RemoveDuplicates(Node head) {
    Node start = head;
    Node prev = head;
    
    // if list is empty, return null
    if (head == null)
        return head;
    
    // advance head one position
    head = head.next;

    // iterate through the list, to the end
    while (head != null) {
        // if the data from a previous node is equal to the data
        //   contained in the current node, advance the next pointer
        //   of the previous node and advance the current pointer
        //   to the next node
        if (prev.data == head.data) {
            prev.next = head.next;
            head = head.next;
        } else {
            // else, just advance the previous and the current pointers
            prev = head;
            head = head.next;
        }
    }
    return start;
}
