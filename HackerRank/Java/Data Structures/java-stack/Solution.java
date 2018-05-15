import java.util.*;

// https://www.hackerrank.com/challenges/java-stack
class Solution {

    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Stack<Character> stack = new Stack<Character>();

            String s = sc.next();
            int i = 0;
            stack.push(s.charAt(i++));
            while (i < s.length()) {
                if (stack.isEmpty()) {
                	stack.push(s.charAt(i++));
                    continue;
                }
                Character c = stack.peek();

                if (c == '{' && s.charAt(i) == '}' || 
                		c == '[' && s.charAt(i) == ']' || 
                		c == '(' && s.charAt(i) == ')')
                    stack.pop();
                else 
                	stack.push(s.charAt(i));
                
                i++;
            }
            
            if (!stack.isEmpty())
                System.out.println("false");
            else
                System.out.println("true");
        }
        sc.close();
    }
}
