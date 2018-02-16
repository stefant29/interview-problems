import java.util.HashSet;

public class Methods {

	/**
	 * Union and Intersection of two Linked Lists
	 * https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
	 */
	public static Node getUnion(Node list1, Node list2) {
		Node union = null;
		Node unionStart = null;
		HashSet<Integer> list1_set = new HashSet<Integer>();

		/*
		 * insert all elements from first list into a hashSet. At the same time,
		 * copy all elements from first list into a new list: union
		 */
		for (; list1 != null; list1 = list1.getNext()) {
			list1_set.add(list1.getInfo());
			if (union == null) {
				union = new Node(list1.getInfo());
				unionStart = union;
			} else {
				union.setNext(new Node(list1.getInfo()));
				union = union.getNext();
			}
		}

		/*
		 * for each element in second list, check if the first lists has it. If
		 * not, insert it at the end of the new list: union.
		 */
		for (; list2 != null; list2 = list2.getNext()) {
			if (!list1_set.contains(list2.getInfo())) {
				if (union == null) {
					union = new Node(list2.getInfo());
					unionStart = union;
				} else {
					union.setNext(new Node(list2.getInfo()));
					union = union.getNext();
				}
			}
		}

		return unionStart;
	}

	public static Node getIntersection(Node list1, Node list2) {
		Node intersect = null;
		Node intersectStart = null;
		HashSet<Integer> list1_set = new HashSet<Integer>();
		
		/* insert all elements from list1 into a hashSet */
		for (; list1 != null; list1 = list1.getNext())
			list1_set.add(list1.getInfo());

		/*
		 * look for the same elements in list2 and add them to the new list:
		 * intersect
		 */
		for (; list2 != null; list2 = list2.getNext()) {
			if (list1_set.contains(list2.getInfo())) {
				if (intersect == null) {
					intersect = new Node(list2.getInfo());
					intersectStart = intersect;
				} else {
					intersect.setNext(new Node(list2.getInfo()));
					intersect = intersect.getNext();
				}
			}
		}

		return intersectStart;
	}

	public static void print(Node list) {
		for (; list != null; list = list.getNext())
			System.out.print(list.getInfo() + "->");
		System.out.println();
	}
}
