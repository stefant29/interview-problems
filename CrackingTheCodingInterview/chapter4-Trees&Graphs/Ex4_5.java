/* 4.5 Implement a function to check if a binary tree is a binary search tree. */

public class Ex4_5 {

	static class Node {
		Object info;
		Node left, right;

		public Node(Object info) {
			this.info = info;
		}

		public static boolean isBST(Node root) {
			if (root == null)
				return true;

			return isBSTaux(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		}

		private static boolean isBSTaux(Node root, int min, int max) {
			if (root == null)
				return true;

			int info = (Integer)root.info;
			if (min < info && info < max)
				return isBSTaux(root.left, min, (Integer)root.info) && 
					   isBSTaux(root.right, (Integer)root.info, max);
			return false;
		}
		
		public String toString() {
			return info.toString();
		}
	}

	public static void main(String[] args) {
		Node n = new Node(4);
		n.left = new Node(2);
		n.right = new Node(6);

		n.left.left = new Node(1);
		n.left.right = new Node(3);

		n.right.left = new Node(5);
		n.right.right = new Node(7);
		
//		n.right.right.left = new Node(8);
		n.right.right.right = new Node(9);
		
		System.out.println(Node.isBST(n));
	}
}