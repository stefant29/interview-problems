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
		int min = 0;
	
		public Stack() {}
	
		public void push(int info) {
			Node newNode;
			
			if (head == null || info < min) {
				newNode = new Node(2 * info - min);
				min = info;
			} else {
				newNode = new Node(info);
			}
			newNode.next = head;
			head = newNode;
		}

		public int pop() throws Exception {
			/* check for empty stack */
			if (head == null)
				throw new Exception("Stack empty");
	
			/* store current info */
			int info = head.info;
			int result = info;
			if (info < min) {
				result = min;
				min = 2 * min - info;
			}
			
			/* advance head */
			head = head.next;
	
			/* return stored info */
			return result;
		}
	
		public boolean isEmpty() {
			if (head == null)
				return true;
			return false;
		}
	
		public void print() {
			Node aux = head;
			
			if (aux == null)
				System.out.println("stack empty");
			
			while (aux != null) {
				System.out.print(aux.info + " -> ");
				aux = aux.next;
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		Stack s = new Stack();
		s.push(6);
		System.out.println(s.min);
		s.push(4);
		System.out.println(s.min);
		s.push(8);
		System.out.println(s.min);
		s.push(3);
		System.out.println(s.min);
		s.push(2);
		System.out.println(s.min);
		s.push(1);
		System.out.println(s.min);
		System.out.println("--------------");
		s.print();
		System.out.println("--------------");

		s.pop();
		System.out.println(s.min);
		s.pop();
		System.out.println(s.min);
		s.pop();
		System.out.println(s.min);
		s.pop();
		System.out.println(s.min);
		s.pop();
		System.out.println(s.min);
		s.pop();
		System.out.println(s.min);
		s.print();
	}
}
