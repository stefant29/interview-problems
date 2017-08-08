package LinkedLists;

public class Methods<T> {
	/* return the m'th-to-lastElement from a given linked list */
	/*
	 * time complexity: O(2n) == O(n), but for big lists, O(2n) is too muchs
	 * space complexity: constant
	 */
	public Element<T> mthElementTrivial(Element<T> head, int m) {
		// naive implementation
		Element<T> aux = head;
		int count = 0;
		while (aux != null) {
			aux = aux.getNext();
			count++;
		}
		aux = head;
		while (count-m > 0 ) {
			aux = aux.getNext();
			count--;
		}
		return aux;
	}
	
	/*
	 * time complexity: O(n) -> best complexity
	 * space complexity: constant
	 */
	public Element<T> mthElement(Element<T> head, int m) {
		Element<T> aux = head;
		while (head != null) {
			if (m < 0)
				aux = aux.getNext();
			else
				m--;
			head = head.getNext();
		}
		return aux;
	}
	
	
	
	
	
	
	/* null or cycle */
	/* 
	 * time complexity: O(n)
	 * space complexity: constant
	 */
	public String nullOrCycle(Element<T> head) {
		Element<T> slow = head;
		Element<T> fast = head.getNext();
		
		while (true) {
			if (fast == null)
				return "Null terminated";
			if (fast == slow || fast.getNext() == slow)
				return "Cycle";
			if (fast.hasNext() && fast.getNext().hasNext()) {
				fast = fast.getNext().getNext();
				slow = slow.getNext();
			} else
				return "Null terminated";
		}
	}
}
