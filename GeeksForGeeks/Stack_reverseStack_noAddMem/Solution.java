package reverse_stack_no_aditional_memory;

/* 
	Reverse a Stack without using recursion and extra space.
	Even the functional Stack is not allowed.
*/

public class Solution {
	
	static class Node {
		int info;
		Node next;
	
		public Node() {}
		public Node(int info) {
			this.info = info;
			next = null;
		}
	}
	
	static class Stack {
		Node head;
	
		public Stack() {}
	
		public void push(int info) {
			Node newNode = new Node(info);
			newNode.next = head;
			head = newNode;
		}
	
		public int pop() throws Exception {
			/* check for empty stack */
			if (head == null)
				throw new Exception("Stack empty");
	
			/* store current info */
			int info = head.info;
			/* advance head */
			head = head.next;
	
			/* return stored info */
			return info;
		}

		public void reverse_stack() {
			/* empty or just one element -> no changes */
			if (isEmpty() || head.next == null)
				return;

			Node crt = head;
			Node prev = null;

			while (crt != null) {
				/* keep the next */
				Node next = crt.next;

				crt.next = prev;

				/* advance */
				prev = crt;
				crt = next;
			}

			/* update head */
			head = prev;
		}
	
		public boolean isEmpty() {
			if (head == null)
				return true;
			return false;
		}
	
		public void print() {
			Node aux = head;
			while (aux != null) {
				System.out.print(aux.info + " -> ");
				aux = aux.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.print();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(7);
		s.print();
		s.reverse_stack();
		s.print();
	}
}