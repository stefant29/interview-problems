/*
  Get Nth element from the end in a linked list of integers
  Number of elements in the list will always be greater than N.
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
// https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail
int GetNode(Node head,int n) {
    Node aux = null;
    Node start = head;
    int count = 0;

    // if the list is empty, return -1
    if (head == null)
        return -1;
    // iterate through the list through the end
    //    and use two pointers: one to get to the end of the list
    //    and the other at distance "n" from the other.
    //    When the first pointer gets to the end, the second will
    //    represent the n'th element behind him
    while (head != null) {
        // if the distance is reached, advance aux
        if (count == n) {
            // if aux is not initialized, make it the start of the list
            if (aux == null)
                aux = start;
            else
                aux = aux.next;
        } else
            // if distance is not yet covered, increment counter
            count++;
        // move on to the next element in the list
        head = head.next;
    }
    // return the data of the n'th element from the tail of the list
    return aux.data;
}
