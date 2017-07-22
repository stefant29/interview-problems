import java.util.*;

// https://www.hackerrank.com/challenges/challenging-palindromes
public class Solution {
	static class Index {
		int start;
		int end;
		char ch;
		
		public Index(int start, int end, char ch) {
			this.start = start;
			this.end = end;
			this.ch = ch;
		}
		
		public String toString() {
			return start + "  " + end;
		}
	}
	
 /*  
    public static String getSubPalindrom(String s, int start, int end) {
        Boolean found = false;
        
        while(!found) {
        	int i = start, j = s.length() - 1, count = 0;
        	
            while (i < j) {
            	if (s.charAt(i) == s.charAt(j)) {
            		i++;
            		j--;
            		count++;
            	} else
            		j--;
            }
            
            if (count > 2) {
            	System.out.println("count: " + count);
            	found = true;
            }
            
            start++;
        }
        
        
        return null;
    }
    */
	
    public static Index getSubPalindrom(String s, int start, int end) {
    	if (start >= end)
    		return null;

        int i = start, j = s.length() - 1;
        System.out.println("s: " + s);
       // LinkedList<Index> ind = new LinkedList<Index>();
        	
        while (i < j) {
        	if (s.charAt(i) == s.charAt(j)) {
        		// i si j are indexes of two chars that are alike
        		return new Index(i,j, s.charAt(i));
        	} else
        		j--;
        }
     
        return null;
    }
        
    static Boolean isOdd = false;

    public static Stack<Character> getSubPalindrom2(String s, int start, int end) {
//    	System.out.println("s: " + s + "   start: " + start + "  end: " + end);
    	if (start > end) {
//    		System.out.println("return NULL");
    		return null;
    	}
    	if (start == end) {
//    		System.out.println("         * added " + s.charAt(start));
    		Stack<Character> aux = new Stack<Character>();
    		aux.push(s.charAt(start));
    		isOdd = true;
    		return aux;
    	}
    	if (start == end - 1) {
    		Stack<Character> aux = new Stack<Character>();
    		if (s.charAt(start) < s.charAt(end))
        		aux.push(s.charAt(start));
    		else
        		aux.push(s.charAt(end));

//    		System.out.println("         * added the smallest: " + s.charAt(start));
    		isOdd = true;
    		return aux;
    		
    	}

        int i = start, j = end;
        Stack<Character> stack = new Stack<Character>();
        	
        while (i < j) {
        	if (s.charAt(i) == s.charAt(j)) {         		// i si j are indexes of two chars that are alike
        		stack.add(s.charAt(i));
//        		System.out.println("  add  " + s.charAt(i) + "   i: " + i + "    j: " + j);
        		Stack<Character> result = getSubPalindrom2(s, i+1, j-1);
        		if (result != null) {
        	        Stack<Character> aux = new Stack<Character>();
        			while (!result.isEmpty())
        				aux.push(result.pop());
        			while (!aux.isEmpty())
        				stack.push(aux.pop());
        		}
        		break;
        	} else
        		j--;
        }
        
//        System.out.println("stack: " + stack);
     
        return stack;
    }
    
    public static String buildString(Stack<Character> stack) {
    	Object[] arr = stack.toArray();
    	StringBuilder sb = new StringBuilder();

    	for (Object i : arr)
    		sb.append(i);
    	
    	int end = arr.length - 1;
    	if (isOdd)
    		end = arr.length - 2;
    	for (int i = end; i >= 0; i--)
    		sb.append(arr[i]);

    	return sb.toString();
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();
        for (int test = 0; test < testCases; test++) {
            String string1 = in.next();
            String string2 = in.next();
            //Index result = getSubPalindrom(string1 + string2, 0, string1.length() + string2.length());
            String s = string1 + string2;
            LinkedList<String> results = new LinkedList<String>();
            for (int i = 0; i < s.length(); i++) {
	            Stack<Character> result = getSubPalindrom2(string1 + string2, i, string1.length() + string2.length()-1);
//	            System.out.println(result + " size: " + result.size());
	            if (result.size() < 2)
	            	continue;
	            results.add(buildString(result));
//	            System.out.println(results.get(i));
//	            System.out.println();
            }
            Collections.sort(results);
            if (results.size() < 1)
            	System.out.println("-1");
            else
            	System.out.println(results.get(0));
        }
        in.close();
    }
}