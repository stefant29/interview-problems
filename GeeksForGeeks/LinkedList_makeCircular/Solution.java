import java.util.HashSet;

/* 
	Given a singly linked list, convert it into a circular linked list. 
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
	}

	public static void simpleToCircular(LinkedList list) throws IllegalArgumentException {
		if (list == null)
			throw new IllegalArgumentException();

		/* find the last element */
		Node aux = list.head;
		while (aux.next != null)
			aux = aux.next;

		/* link the first element after the last element */
		aux.next = list.head;
	}

	public static void print(String s, Node head) {
		System.out.println(s);
		HashSet<Node> set = new HashSet<Node>();
		
		while (head != null ) {
			if (set.add(head) == false) {
				System.out.println("loop detected: break");
				break;
			}
			System.out.print(head.info + " -> ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.add(new Node(1));
		list.add(new Node(2));
		list.add(new Node(3));
		list.add(new Node(4));
	
		print("bef: ", list.head);
		simpleToCircular(list);
		print("after: ", list.head);
	}
}