package LinkedLists;

public class MyStack {
	
	Element<Integer> head;
	
	public MyStack() {
		head = null;
	}
	
	public MyStack(int data) {
		head = new Element<Integer>(data);
	}
	
	public Integer getFirst() {
		if (head != null)
			return head.getData();
		return null;
	}
	
	public Boolean push(Integer data) {
		Element<Integer> newElem = new Element<Integer>(data);
		if (head != null)
			newElem.setNext(head);
		head = newElem;
		
		return true;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Element<Integer> aux = head;
		while (aux != null) {
			sb.append(aux.getData() + "-> ");
			aux = aux.getNext();
		}
		return sb.toString();
	}
}
