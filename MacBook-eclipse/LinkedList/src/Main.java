
public class Main {

	public static void main(String[] args) {
		Node list1 = new Node(1, new Node(2, new Node(3, new Node(4))));
		Node list2 = new Node(3, new Node(5, new Node(6, new Node(1))));
		
		Node intersect = Methods.getIntersection(list1, list2);
		Node union = Methods.getUnion(list1, list2);
		
		Methods.print(list1);
		Methods.print(list2);

		Methods.print(intersect);
		Methods.print(union);
	}
}
