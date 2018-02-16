
public class Node {
	private int value;
	private Node left, right;
	
	public Node() {
		setValue(-1);
	}
	
	public Node(int value) {
		this.setValue(value);
	}
	public Node(int value, Node left, Node right) {
		this.setValue(value);
		this.setLeft(left);
		this.setRight(right);
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
}
