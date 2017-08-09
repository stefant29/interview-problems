import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.hackerrank.com/challenges/swap-nodes-algo
public class Solution {
    /* inner class to store a node */
	static class Node {
	    Node left;
	    Node right;
	    int data;
	    
        /* constructors */
	    Node(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	    Node(int data, int left, int right) {
            this.data = data;
            this.left = new Node(left);
            this.right = new Node(right);
	    }
	}
    /* print nodes in order */
	public static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}
    /* wrapper for printing the nodes of a tree in order */
    public static void printInOrder(Node root) {
        inOrder(root);
        System.out.println();
    }
    /* insert the nodes on levelsw which are multiple of K into the queue */
	public static void getNodesOnLevel(Queue<Node> queue, Node root, int level, int K) {
		if (root == null)
			return;
        /* add the node to the queue if its level is multiple of K */
		if (level % K == 0)
			queue.add(root);
        /* advance to the left child */
        getNodesOnLevel(queue, root.left, level+1, K);
        /* advance to the right child */
        getNodesOnLevel(queue, root.right, level+1, K);
	}
    /* swap the children of a given node */
	public static void swap(Node node) {
		if (node == null)
			return;
		Node aux = node.right;
		node.right = node.left;
		node.left = aux;
	}
	public static void main(String[] args) {
        /* read from stdin */
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
        /* create an array with N nodes */
		Node[] nodes = new Node[N];
        /* initialize the array of nodes with values from 1 to N */
		for (int i = 0; i < N; i++) 
			nodes[i] = new Node(i+1);
        /* for each node, link the children */
		for (int i = 0; i < N; i++) {
            /* read children from stdin */
			int left = in.nextInt();
			int right = in.nextInt();
            /* assign left and right if they are different than null == -1 */
			if (left != -1)
				nodes[i].left = nodes[left-1];
			if (right != -1)
				nodes[i].right = nodes[right-1];
		}
		int T = in.nextInt();
        /* for each test case */
		for (int i = 0; i < T; i++ ) {
            /* create a queue to store the nodes on wanted levels */
			Queue<Node> queue = new LinkedList<Node>();
			int K = in.nextInt();
			/* add to the queue all the nodes on level K or multiple of K */
			getNodesOnLevel(queue, nodes[0], 1, K);
            /* swap children of all the nodes in the queue */
			while (!queue.isEmpty())
				swap(queue.poll());
            /* print tree in order after swapping */
			printInOrder(nodes[0]);
		}
        /* close scanner */
		in.close();
	}
}

