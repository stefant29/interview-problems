package cracking;
import java.util.Stack;

/* Check if stack elements are pairwise consecutive
	Given a stack of integers, write a function pairWiseConsecutive() that checks whether numbers in the stack are pairwise consecutive or not. The pairs can be increasing or decreasing, and if the stack has an odd number of elements, the element at the top is left out of a pair. The function should retain the original stack content.

	Only following standard operations are allowed on stack.

	push(X): Enter a element X on top of stack.
	pop(): Removes top element of the stack.
	empty(): To check if stack is empty.
	Examples:

	Input : stack = [4, 5, -2, -3, 11, 10, 5, 6, 20]
	Output : Yes
	Each of the pairs (4, 5), (-2, -3), (11, 10) and
	(5, 6) consists of consecutive numbers.

	Input : stack = [4, 6, 6, 7, 4, 3]
	Output : No
	(4, 6) are not consecutive.
*/

public class Solution {
	
	public static boolean pairWiseConsecutive(Stack<Integer> stack) throws IllegalArgumentException {
		Stack<Integer> stack_aux = new Stack<Integer>();
		int count_elems = 0;
		boolean result = true;

		if (stack == null)
			throw new IllegalArgumentException();

		while (!stack.isEmpty()) {
			stack_aux.push(stack.pop());
			count_elems++;
		}

		if (count_elems < 2) {
			while (!stack_aux.isEmpty())
				stack.push(stack_aux.pop());
			return true;
		}


		while (!stack_aux.isEmpty()) {
			/* pop first number */
			int n1 = stack_aux.pop();
			stack.push(n1);

			/* if stack contains an odd number of elements, 
				there is no second element to pop */
			if (stack_aux.isEmpty())
				break;

			/* pop second number */
			int n2 = stack_aux.pop();
			stack.push(n2);

			/* check if the two numbers are consecutive */
			if (Math.abs(n1-n2) != 1)
				result = false;
		}

		return result;
	}

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		System.out.println(pairWiseConsecutive(stack));
		stack.push(1);
		System.out.println(pairWiseConsecutive(stack));
		stack.push(3);
		System.out.println(pairWiseConsecutive(stack));
		stack.push(3);
		System.out.println(pairWiseConsecutive(stack));
		stack.push(5);
		System.out.println(stack);
		System.out.println(pairWiseConsecutive(stack));
	}
}