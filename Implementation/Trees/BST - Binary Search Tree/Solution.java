
public class BinarySearchTree {

	static class Node {
		Object info;
		Node left, right;
		
		public Node(Object info) {
			this.info = info;
		}
		
		public Node(Object info, Node left, Node right) {
			this.info = info;
			this.left = left;
			this.right = right;
		}
		
		public void add(Object info) {
			if (this.info == null) {
				this.info = info;
				return;
			}
			
			Node aux = this;
			while (true) {
				if ((Integer)aux.info == (Integer)info)
					return;
				else if ((Integer)info > (Integer)aux.info) {
					if (aux.right == null)
						break;
					aux = aux.right;
				} else {
					if (aux.left == null)
						break;
					aux = aux.left;
				}
			}
			if ((Integer)info > (Integer)aux.info) {
				aux.right = new Node(info);
			} else
				aux.left = new Node(info);
		}
		
		public static int noOfNodes(Node root) {
			if (root == null)
				return 0;
			return 1 + noOfNodes(root.left) + noOfNodes(root.right);
		}
		
		public static boolean isLeaf(Node node) {
			if (node == null)
				return false;
			return node.left == null && node.right == null;
		}
		
		public static void preOrder(Node root) {
			if (root == null)
				return;
			System.out.print(root.info + ", ");
			preOrder(root.left);
			preOrder(root.right);
		}
		
		public static void inOrder(Node root) {
			if (root == null)
				return;
			inOrder(root.left);
			System.out.print(root.info + ", ");
			inOrder(root.right);
		}
	
		public static void postOrder(Node root) {
			if (root == null)
				return;
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.info + ", ");
		}

		public static int evenNodes(Node root) {
			int result = 0;
			if (root == null)
				return 0;
			
			if ((Integer)root.info % 2 == 0)
				result = 1;
			return result + evenNodes(root.left) + evenNodes(root.right);
		}

		// 10(7(3,),9(8,4)) 
		public static void printStylish(Node root) {
			if (root == null)
				return;
			
			System.out.print(root.info);
			if (root.left == null && root.right == null)
				return;
			
			System.out.print("(");
			printStylish(root.left);
			System.out.print(",");
			printStylish(root.right);
			System.out.print(")");
		}

		public static int nrLevel(Node root) {
			if (root == null)
				return 0;
			int leftNo = 1 + nrLevel(root.left);
			int rightNo = 1 + nrLevel(root.right);
			return Math.max(leftNo, rightNo);
		}

		public static float average(Node root, int level) {
			if (root == null)
				return 0;

			if (level == 0)
				return (float)root.info;

			return sumNodesLevel(root, level) / noOfElementsLevel(root, level);
		}

		public static int sumNodesLevel(Node root, int level) {
			if (root == null)
				return 0;

			if (level == 0)
				return (Integer)root.info;

			return sumNodesLevel(root.left, level-1) + sumNodesLevel(root.right, level-1);
		}

		public static int noOfElementsLevel(Node root, int level) {
			if (root == null)
				return 0;

			if (level == 0)
				return 1;

			return noOfElementsLevel(root.left, level-1) + noOfElementsLevel(root.right, level-1);
		}
		
		public static boolean search(Node root, int info) {
			if (root == null)
				return false;
			
			if ((Integer)root.info == info)
				return true;
			else if ((Integer)root.info > info)
				return search(root.left, info);
			else
				return search(root.right, info);
		}
		
		public static boolean searchOnLevel(Node root, int info, int level) {
			if (root == null)
				return false;
			
			if (level == 0 && info == (Integer)root.info)
				return true;
			else if ((Integer)root.info > info)
				return searchOnLevel(root.left, info, level-1);
			else
				return searchOnLevel(root.right, info, level-1);
		}
		
		public static int getMax(Node root) {
			if (root == null)
				return Integer.MIN_VALUE;
			if (root.right == null)
				return (Integer)root.info;
			
			while (root.right != null)
				root = root.right;
			return (Integer)root.info;
		}
		
		public static int getMin(Node root) {
			if (root == null)
				return Integer.MAX_VALUE;
			if (root.left == null)
				return (Integer)root.info;
			
			while (root.left != null)
				root = root.left;
			
			return (Integer)root.info;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(10);
		root.add(8);
		root.add(9);
		root.add(6);
		root.add(11);
		root.add(3);
		root.add(1);
		
		System.out.println("\nMax: " + Node.getMax(root));
		System.out.println("Min: " + Node.getMin(root));
		
		System.out.println("noOfNodes: " + Node.noOfNodes(root));
		System.out.println("is leaf? " + Node.isLeaf(root.left.left));
		System.out.println("is leaf? " + Node.isLeaf(root.right));
		System.out.print("preOrder: ");
		Node.preOrder(root);
		System.out.print("\ninOrder: ");
		Node.inOrder(root);
		System.out.print("\npostOrder: ");
		Node.postOrder(root);
		System.out.println("\nnumber of even Nodes: " + Node.evenNodes(root));
		System.out.print("afisare(): ");
		Node.printStylish(root);
		System.out.println("\nnrLevels: " + Node.nrLevel(root));
		System.out.println("average(level1): " + Node.average(root, 1));
		System.out.println("4 exists? " + Node.search(root, 4) + "     11 exists? " + Node.search(root, 11));
		System.out.println("search 9 on level 1: " + Node.searchOnLevel(root, 9, 1));
		System.out.println("search 11 on level 1: " + Node.searchOnLevel(root, 11, 1));
	}
}

