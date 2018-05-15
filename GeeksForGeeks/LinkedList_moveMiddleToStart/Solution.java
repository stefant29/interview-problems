/* 
Given a singly linked list, find middle of the linked list
 and set middle node of the linked list at beginning of the linked list.
*/

public class Solution {

	static class Node {
		int info;
		Node next;
	
		public Node() {}
		public Node(int info) {this.info = info;}
	}
	
	static class LinkedList {
		Node head;
	
		public void add(Node n) {
			Node aux = head;
	
			if (aux == null) {
				head = n;
				return;
			}
	
			while (aux.next != null)
				aux = aux.next;
	
			aux.next = n;
		}
	
		public void moveMiddleToStart() {
			Node middle = head;
			Node prev = null;
			Node fast = head;
	
			/* for 0, 1, 2 elements, do nothing */
			if (head == null || head.next == null || head.next.next == null)
				return;
	
			/* find middle */
			while (fast.next != null && fast.next.next != null) {
				fast = fast.next.next;
				prev = middle;
				middle = middle.next;
			}
	
			/* link the middle at the start of the linkedlist */
			prev.next = middle.next;
			middle.next = head;
			head = middle;
		}
	}
	
	
	public static void print(String s, Node head) {
		System.out.println(s);
		while (head != null) {
			System.out.print(head.info + " -> ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedList head = new LinkedList();
		head.moveMiddleToStart();
		print("", head.head);
		head.add(new Node(1));
		head.moveMiddleToStart();
		print("", head.head);
		head.add(new Node(2));
		head.moveMiddleToStart();
		print("", head.head);
		head.add(new Node(3));
		print("bef: ", head.head);
		head.moveMiddleToStart();
		print("after: ", head.head);
		
		System.out.println();
		
		LinkedList head2 = new LinkedList();
		head2.add(new Node(1));
		head2.add(new Node(2));
		head2.add(new Node(3));
		head2.add(new Node(4));
		head2.add(new Node(5));
		head2.add(new Node(6));
		head2.add(new Node(7));
		head2.add(new Node(8));
	
		print("bef: ", head2.head);
		head2.moveMiddleToStart();
		print("after: ", head2.head);
		
		
	}
}