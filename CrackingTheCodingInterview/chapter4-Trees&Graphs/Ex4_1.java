
public class Ex4_1 {

	static class Node {
		Object info;
		Node left, right;

		public Node(Object info) {
			this.info = info;
		}

		public int height() {
			return getHeight(this);
		}

		private int getHeight(Node root) {
			if (root == null)
				return 0;
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}

		public boolean balanced() {
			return left.height() == right.height();
		}
	}

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);

		n.left.left = new Node(4);
		n.left.right = new Node(5);

//		n.right.left = new Node(6);
		n.right.right = new Node(7);
		
		n.right.right.right = new Node(8);

		System.out.println("equal? " + n.balanced());
	}


}
