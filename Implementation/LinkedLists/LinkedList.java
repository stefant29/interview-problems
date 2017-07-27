package LinkedLists;

public class LinkedList<T> {
	private Element<T> head;
	
	public LinkedList() {}
	public LinkedList(T elem) {
		head = new Element<>(elem);
	}
	public LinkedList(Element<T> elem) {
		head = elem;
	}
	
	public void add(T data) {
		Element<T> aux = head;
		if (head == null) {
			head = new Element<T>(data);
			return;
		}
		
		while (aux.getNext() != null) {
			aux = aux.getNext();
		}
		aux.setNext(new Element<T>(data));
	}
	
	public void removeStart() {
		if (head == null)
			return;
		if (head.hasNext())
			head = head.getNext();
		else
			head = null;
	}
	
	public Element<T> getElemAt(int index) {
		Element<T> aux = head;
		while (aux.hasNext() && index > 0) {
			aux = aux.getNext();
			index--;
		}
		if (index != 0)
			return null;
		return aux;
	}
	
	public void addAfter(Element<T> elem, T data) {
		if (head == null) {
			head = new Element<T>(data);
			return;
		}
		Element<T> aux = head;
		while (aux.hasNext()) {
			if (aux == elem) {
				Element<T> next = aux.getNext();
				aux.setNext(new Element<T>(data));
				aux.getNext().setNext(next);
				return;
			}
			aux = aux.getNext();
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Element<T> aux = head;
		
		if (head == null)
			return "list EMPTY";
		
		sb.append("[");
		while (aux.hasNext()) {
			sb.append(aux.getData() + "->");
			aux = aux.getNext();
		}
		sb.append(aux.getData() + "]");
		return sb.toString();
	}
	
	public Element<T> getHead() {
		return head;
	}

	public void setHead(Element<T> head) {
		this.head = head;
	}
	
}
