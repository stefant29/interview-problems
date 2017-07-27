package LinkedLists;

public class Main {

	public static void main(String[] args) {
		MyStack stack = new MyStack(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		System.out.println(stack);
		
		LinkedList<Integer> list = new LinkedList<Integer>(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		System.out.println("List: " + list);
		list.removeStart();
		System.out.println("List: " + list);
		Element<Integer> el = list.getElemAt(8);
		if (el != null)
			System.out.println(el.getData());
		else
			System.out.println("el is null");
		list.addAfter(el, 6);
		System.out.println("List: " + list);

	}

}
