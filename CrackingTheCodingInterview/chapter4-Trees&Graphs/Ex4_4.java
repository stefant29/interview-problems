import java.util.*;

/* Given a binary tree, design an algorithm which creates a linked list of all the nodes at
each depth (e.g., if you have a tree with depth D, you'll have D linked lists).
*/



public class Ex4_4 {

	static class Node {
		Object info;
		Node left, right;

		public Node(Object info) {
			this.info = info;
		}

		public ArrayList<LinkedList<Node>> toList() {

			ArrayList<LinkedList<Node>> list = new ArrayList<LinkedList<Node>>();
			Queue<Node> queue = new LinkedList<Node>();
			int nodesInStack = 1;

			queue.add(this);

			while (!queue.isEmpty()) {
				LinkedList<Node> crtLevel = new LinkedList<Node>();
				int crtAdded = 0;
				for (int i = 0; i < nodesInStack; i++) {
					Node crtNode = queue.poll();
					crtLevel.add(crtNode);
					if (crtNode.left != null) {
						queue.add(crtNode.left);
						crtAdded++;
					}
					if (crtNode.right != null) {
						queue.add(crtNode.right);
						crtAdded++;
					}
				}
				nodesInStack = crtAdded;
				list.add(crtLevel);
			}

			return list;
		}
		
		public String toString() {
			return info.toString();
		}
	}

	public static void main(String[] args) {
		Node n = new Node(1);
		n.left = new Node(2);
		n.right = new Node(3);

		n.left.left = new Node(4);
		n.left.right = new Node(5);

		n.right.left = new Node(6);
		n.right.right = new Node(7);
		
		n.right.right.left = new Node(8);
		n.right.right.right = new Node(9);
		
		System.out.println(n.toList());
	}
}