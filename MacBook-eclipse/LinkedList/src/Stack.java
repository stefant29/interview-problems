
public class Stack {

	private Node head;
	
	public void Push(int data) {
		head = new Node(data, head);
	}
	
	public int Pop() throws NullPointerException {
		if (head == null)
			throw new NullPointerException();
		int data = head.getInfo();
		head = head.getNext();
		return data;
	}
	
	public void print() {
		if (head == null) {
			System.out.println("Stack emtpy");
			return;
		}
		System.out.print("[");
		for (Node aux = head; aux.hasNext(); aux = aux.getNext()) {
			System.out.print(aux.getInfo() + ", ");
		}
		System.out.println("]");
	}
}