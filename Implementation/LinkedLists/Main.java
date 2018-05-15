package LinkedLists;

public class Main {

	static class Node {
		 int data;
	     Node next;
	     Node prev;
		@Override
		public String toString() {
			return "Node [data=" + data + ", next=" + next + ", prev=" + prev + "]";
		}
	     
	     public void printNode() {
	    	 	Node aux = this;
	    	 	while (aux != null) {
	    	 		System.out.print(aux.data + "->");
	    	 		aux = aux.next;
	    	 	}
	    	 	System.out.println();
	     }
	  }

static Node SortedInsert(Node head,int data) {
    Node start = head;
    
    if (head == null) {
        start = new Node();
        start.data = data;
        start.next = null;
        start.prev = null;
    }
    
    while (head != null) {
    //	System.out.println("data; " + head.data);	
        if (head.data > data) {
        		//System.out.println(head.data + " este mai mare decat" + data);
            Node insert = new Node();
            insert.data = data;
            insert.prev = head.prev;
            insert.next = head;
            
            head.prev.next = insert;
            head.prev = insert;
            break;
        }
        
		if (head.next == null) {
			Node insert = new Node();
	        insert.data = data;
	        insert.prev = head;
	        insert.next = null;
	        head.next = insert;
	        break;
		}
		
        head = head.next;
    }
    while (start.prev != null) {
        start = start.prev;
    }
    
    return start;
}
	public static void main(String[] args) {
		MyStack stack = new MyStack(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack);
		
		LinkedList<Integer> list = new LinkedList<Integer>(0);
		Element<Integer> e1 = new Element<Integer>(1);
		list.add(e1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("List: " + list);
		list.pop();
		System.out.println("List: " + list);
		Element<Integer> el = list.getElemAt(8);
		if (el != null)
			System.out.println(el.getData());
		else
			System.out.println("el is null");
		list.addAfter(el, 6);
		System.out.println("List: " + list);

		
		
		System.out.println();
		Node head = SortedInsert(null, 2);
		head.printNode();
		head = SortedInsert(head, 5);
		head.printNode();
		head = SortedInsert(head, 4);
		head.printNode();
		
		Methods<Integer> m = new Methods<Integer>();
		System.out.println("===" + list + "===");
		System.out.println("trivial: list: " + list + "  with 2' element -> " + m.mthElement(list.getHead(), 2).getData());
		System.out.println("best complexity: list: " + list + " with 2' element -> " + m.mthElement(list.getHead(), 0).getData());
		System.out.println("best complexity: list: " + list + " with 0' element -> " + m.mthElement(list.getHead(), 0).getData());
		System.out.println(m.nullOrCycle(list.getHead()));
		Element<Integer> last = m.mthElement(list.getHead(), 0);
		System.out.println("last: " + last.getData());
		last.setNext(e1);
		System.out.println(m.nullOrCycle(list.getHead()));
	}

}
