/* 
	Given a singly linked list of n nodes,
	find the smallest and largest elements in linked list.
*/

public class Solution {
	
	static class Node {
		int info;
		Node next;

		public Node() {}
		public Node(int info) {this.info = info;}
	}

	static class MinMax {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
	}

	public static MinMax findMinMax(Node head) throws IllegalArgumentException {
		if (head == null)
			throw new IllegalArgumentException();

		MinMax result = new MinMax();
		while (head != null) {
			/* update min and max */
			if (head.info > result.max)
				result.max = head.info;
			if (head.info < result.min)
				result.min = head.info;
			/* advance in the list */
			head = head.next;
		}

		return result;
	}

	public static void print(Node head) {
		while (head != null) {
			System.out.print(head.info + " -> ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		print(head);
		head.next.next.next = new Node(4);
		print(head);
		MinMax minMax = findMinMax(head);
		System.out.println(minMax.min);
		System.out.println(minMax.max);
	}
}