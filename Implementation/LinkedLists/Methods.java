package LinkedLists;

public class Methods<T> {

	public Element<T> mthElement(Element<T> head, int m) {
		// naive implementation
		Element<T> aux = head;
		int count = 0;
		while (aux != null) {
			aux = aux.getNext();
			count++;
		}
		aux = head;
		while (count >= 0 ) {
			aux = aux.getNext();
			count--;
		}
		return aux;
	}
	

}
