package problems;

public class Main {

	public static void main(String[] args) {
		Methods m = new Methods();
		/* ex1: findNonrepeted characters in a string */
		System.out.println("trivial:  total -> " + m.findNonrepeatedTrivial("total"));
		System.out.println("trivial:  total -> " + m.findNonrepeatedTrivial("teeter"));
		System.out.println("bestComplexity:  total -> " + m.findNonrepeated("total"));
		System.out.println("bestComplexity:  total -> " + m.findNonrepeated("teeter"));
	}
}
