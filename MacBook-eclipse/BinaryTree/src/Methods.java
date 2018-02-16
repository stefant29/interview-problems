import java.util.ArrayList;
import java.util.HashMap;

public class Methods {
	
	/* Print a Binary Tree in Vertical Order
	 * https://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/  */
	public static void printVertically(Node root) {
		/* construct map of tree, where each vertical line is a key in the map 
		 * and the data is represented by the elements on that level */
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		constructTree(root, 0, map);
		
		/* find the left/right extremes */
		int left = deepestLeft(root.getLeft());
		int right = deepestRight(root.getRight());
		
		/* print the map in order */
		for (int i = left * (-1); i <= right; i++)
			System.out.println(map.get(i));
	}	
	private static int deepestLeft(Node root) {
		if (root == null)
			return 0;
		return 1 + deepestLeft(root.getLeft());
	}
	private static int deepestRight(Node root) {
		if (root == null)
			return 0;
		return 1 + deepestRight(root.getRight());
	}
	private static void constructTree(Node root, int level, HashMap<Integer, ArrayList<Integer>> map) {
		if (root == null)
			return;
		/* if there is already a list in at the key: level, 
		 * then add the value of the current node in the list */
		if (map.get(level) != null)
			map.get(level).add(root.getValue());
		/* if level is not part of the map, put a new ArrayList inside */
		else {
			map.put(level, new ArrayList<>());
			map.get(level).add(root.getValue());
		}
		/* */
		constructTree(root.getLeft(), level-1, map);
		constructTree(root.getRight(), level+1, map);
	}
	
	
	
	
	
	/* Print Nodes in Top View of Binary Tree 
	 * https://www.geeksforgeeks.org/print-nodes-top-view-binary-tree/  */
	public static void printTop(Node root) {
		printLeft(root.getLeft());
		System.out.print(root.getValue());
		printRight(root.getRight());
	}
	private static void printLeft(Node root) {
		if (root == null)
			return;
		printLeft(root.getLeft());
		System.out.print(root.getValue());
	}
	private static void printRight(Node root) {
		if (root == null)
			return;
		System.out.print(root.getValue());		
		printRight(root.getRight());
	}
	
	
	
	
	
	
	public static void printTree(Node root) {
		if (root == null)
			return;
		printTree(root.getLeft());
		System.out.print(root.getValue() + " ");
		printTree(root.getRight());
	}
}
