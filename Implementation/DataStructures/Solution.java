package DataStructures;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
		// STACK
		Stack<Integer> stack = new Stack<Integer>();
		stack.add(3);
		stack.add(2);
		stack.add(1);
		System.out.println("stack: " + stack);
		System.out.println(stack.firstElement());
		System.out.println(stack.lastElement());
		System.out.println(stack.capacity());
		stack.add(4);
		stack.add(4);
		stack.add(4);
		stack.add(4);
		stack.add(4);
		stack.add(4);
		System.out.println("lastIndex: " + stack.lastIndexOf(4));
		System.out.println("firstIndex:  " + stack.indexOf(5));
		System.out.println("search: " + stack.search(2));
		System.out.println("set: " + stack.set(5, 6));
		stack.add(4);
		stack.add(4);
		System.out.println(stack.capacity() + "   " + stack);
		stack.add(4);
		stack.add(4);
		System.out.println(stack.capacity() + "   " + stack);
		stack.setSize(4);
		System.out.println(stack.capacity() + "   " + stack);
		stack.trimToSize();
		System.out.println(stack.capacity() + "   " + stack);
		System.out.println();
		
		// ArrayList
		ArrayList<Integer> arr = new ArrayList<Integer>();
		arr.add(3);
		arr.add(4);
		ArrayList<Integer> arr_clone = (ArrayList<Integer>) arr.clone();
		arr_clone.add(5);
		System.out.println(arr);
		System.out.println(arr_clone);
		arr.set(0, 6);
		System.out.println(arr);
		System.out.println(arr_clone);
    		System.out.println();
    	
    	// Hashtable
        Hashtable<String, Integer> table = new Hashtable<String, Integer>();
        table.put("a", 0);
        table.put("b", 1);
        table.put("c", 2);
        table.put("d", 3);
        table.put("e", 4);
        System.out.println(table.hashCode());
        System.out.println(table);
        Enumeration<String> keys = table.keys();
        Enumeration<Integer> elements = table.elements();
        System.out.print("keys: ");
        while (keys.hasMoreElements())
        		System.out.print(keys.nextElement() + " ");
        System.out.println();
        
        System.out.print("elements: ");
        while (elements.hasMoreElements())
        		System.out.print(elements.nextElement() + " ");
        System.out.println();
    }
}
