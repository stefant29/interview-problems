package reverse_stack;

/* Reverse a stack using recursion
	Write a program to reverse a stack using recursion. 
	You are not allowed to use loop constructs like while, for..etc, 
	and you can only use the following ADT functions on Stack S:
	isEmpty(S)
	push(S)
	pop(S)
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
	
		/* push at bottom */
		public void insertLast(int info) {
			Node aux = head;
			Node newNode = new Node(info);
	
			if (head == null) {
				head = newNode;
				return;
			}
	
			/* go to the end of bottom of the stack */
			while (aux.next != null)
				aux = aux.next;
	
			/* insert the new node at the bottom */
			aux.next = newNode;
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
	
	public static void reverse_stack(Stack s) throws Exception {
		if (s.isEmpty())
			return;
	
		/* pop and store the top element */
		int peek = s.pop();
		/* call the reverse_stack with the rest of the stack */
		reverse_stack(s);
		/* insert the top element at the bottom of the stack */
		s.insertLast(peek);
	}
	
	public static void main(String[] args) {
		Stack s = new Stack();
		s.print();
		s.push(1);
		s.push(2);
		s.push(3);
		s.print();
		try {
			reverse_stack(s);
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
		s.print();
	}
}