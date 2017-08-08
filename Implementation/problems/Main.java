package problems;

public class Main {

	public static void main(String[] args) {
		Methods m = new Methods();
		/* ex1: findNonrepeted characters in a string */
		System.out.println("trivial:  total -> " + m.findNonrepeatedTrivial("total"));
		System.out.println("trivial:  total -> " + m.findNonrepeatedTrivial("teeter"));
		System.out.println("bestComplexity:  total -> " + m.findNonrepeated("total"));
		System.out.println("bestComplexity:  total -> " + m.findNonrepeated("teeter"));
		
		
		/* ex2: remove given chars from a string" */
		System.out.println("trivial: Remove aeiou from Battle of the Vowels -> " + m.removeCharsTrivial("Battle of the Vowels", "aeiou"));
		System.out.println("betterComplexity: Remove aeiou from Battle of the Vowels -> " + m.removeChars("Battle of the Vowels", "aeiou"));
	}
}
