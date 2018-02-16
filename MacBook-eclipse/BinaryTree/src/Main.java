
public class Main {
	public static void main(String[] args) {
		Node n6 = new Node(6, null, new Node(8));
		Node n7 = new Node(7, null, new Node(9));
		Node n2 = new Node(2, new Node(4), new Node(5));
		Node n3 = new Node(3, n6, n7);
		Node root = new Node(1, n2, n3);

//		Methods.printVertically(root);
		Methods.printTop(root);
	}
}
