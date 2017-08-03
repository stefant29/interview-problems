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


// https://www.hackerrank.com/challenges/insert-a-node-into-a-sorted-doubly-linked-list
Node SortedInsert(Node head,int data) {
    // save the start of the list
    Node start = head;
    
    // if the list is empty, create a new node and place the data inside
    if (head == null) {
        start = new Node();
        start.data = data;
        start.next = null;
        start.prev = null;
    }
    
    // iterate through the list
    while (head != null) {
        // find the data to insert
        if (head.data > data) {
            // create a new node and place the data inside
            Node insert = new Node();
            insert.data = data;
            insert.prev = head.prev;
            insert.next = head;
            
            // link previous node and curent node to the newly created one
            head.prev.next = insert;
            head.prev = insert;
            break;
        }
        
        // if the end of the list is reached, insert the data at the end of the list
		if (head.next == null) {
			Node insert = new Node();
	        insert.data = data;
	        insert.prev = head;
	        insert.next = null;
	        head.next = insert;
	        break;
		}
		// advance in the list
        head = head.next;
    }
    
    // if the element is inserted before the first element move backwords
    while (start.prev != null)
        start = start.prev;
    
    // return the real start of the list
    return start;
}
