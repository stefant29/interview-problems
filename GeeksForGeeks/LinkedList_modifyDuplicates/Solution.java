import java.util.HashSet;
/* 
Given a linked list that contains some random integers from 1 to n with many duplicates. 
Replace each duplicate element that is present in the linked list 
with the values n+1, n+2, n+3 and so on
(starting from left to right in the given linked list).
*/
public class Solution {
	static class Node {
		int info;
		Node next;
	
		public Node() {}
		public Node(int info) {this.info = info;}
		
		public String toString() {
			return "" + info;
		}
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
	
	public static void print(String s, Node head) {
		System.out.print(s + "  ");
		while (head != null) {
			System.out.print(head.info + " -> ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void replaceDuplicates(Node n) {
		int max = Integer.MIN_VALUE;
		HashSet<Integer> infos = new HashSet<Integer>();
		HashSet<Node> nodes = new HashSet<Node>();
		
		if (n == null)
			return;
		
		/* traverse the list and find the max; 
		 * add all info in a set
		 * add all nodes with info already in the set in another set */
		for (Node aux = n; aux != null; aux = aux.next) {
			if (max < aux.info)
				max = aux.info;
			if (!infos.add(aux.info))
				nodes.add(aux);
		}

		/* modify each node's info from the nodes set to max+1
		 * and increment max
		 */
		for (Node aux = n; aux != null; aux = aux.next)
			if (nodes.contains(aux))
				aux.info = ++max;
	}
	
	public static void main(String[] args) {
		LinkedList head = new LinkedList();
		head.add(new Node(1));
		head.add(new Node(1));
		head.add(new Node(1));
		head.add(new Node(4));
		head.add(new Node(4));
		head.add(new Node(6));
		head.add(new Node(4));
		head.add(new Node(8));
	
		print("bef  : ", head.head);
		replaceDuplicates(head.head);
		print("after: ", head.head);
	}
}
