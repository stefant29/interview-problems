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
	}
	
	public static Node reverseList(Node head, int k) {
		Node prev = null;
		
		if (head == null)
			return null;
		
		/* reverse a list in place */
		while (head != null && k-- > 0) {
			/* save a pointer to the next cell */
			Node next = head.next;
			/* make the next pointer to point to the previous cell */
			head.next = prev;
			/* advance prev and head */
			prev = head;
			head = next;
		}
		/* return the new head of the list == 
		 *  == the last cell in the original list */
		return prev;
	}
	
	public static Node reverseList2(Node head, int k) {
		if (head == null)
			return null;
		
		int counter = k;
		Node start = null;
		Node end = head;
		
		while (head != null) {
			/* keep a pointer to k cells from the current one */
			Node aux = head;
			while (aux != null && counter-- > 0)
				aux = aux.next;
			
			/* reset the counter */
			counter = k;
			
			/* set the start of the new list to the reverse list  
			 * resulted from the first k cells
			 */
			if (start == null)
				start = reverseList(head, k);
			else {
				/* append to the current list the new reversed k cells */
				while (end.next != null)
					end = end.next;
				end.next = reverseList(head, k);
			}
			
			/* advance k cells in the list */
			head = aux;
		}
		
		return start;
	}
	
	public static void print(String s, Node head) {
		System.out.print(s + "  ");
		while (head != null) {
			System.out.print(head.info + " -> ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedList head = new LinkedList();
		head.add(new Node(1));
		head.add(new Node(2));
		head.add(new Node(3));
		head.add(new Node(4));
		head.add(new Node(5));
		head.add(new Node(6));
		head.add(new Node(7));
		head.add(new Node(8));
	
		print("bef  : ", head.head);
		Node n = reverseList2(head.head, 5);
		print("after: ", n);
	}
}
