package Strings;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {
	
    static class Pair implements Comparable<Pair>{
   	int first, second;
   	public Pair(int first, int second) { this.first = first; this.second = second;}
		@Override
		public String toString() {return "["+first + ", " + second+"]";}

		@Override
		public int compareTo(Pair arg1) {
			if (first > arg1.first)
				return 1;
			else if (first == arg1.first) {
				if (second > arg1.second)
					return 1;
				else if (second < arg1.second)
					return -1;
				else
					return 0;
			} else
				return -1;
		}
		
		
		@Override
		public boolean equals(Object p) {
			return ((Pair) p).first == first && ((Pair) p).second == second;
		}
		
		@Override
		public int hashCode() {
			return first * 100 + second * 10;
		}
	}
    
    static class Pair3 implements Comparable<Pair>{
   	int first, second, third;
   	public Pair3(int first, int second, int third) { this.first = first; this.second = second; this.third = third;}
		@Override
		public String toString() {return "[" + first + ", " + second + ", " + third + "]";}

		@Override
		public int compareTo(Pair arg1) {
			// TODO: uses only 1 and 2
			if (first > arg1.first)
				return 1;
			else if (first == arg1.first) {
				if (second > arg1.second)
					return 1;
				else if (second < arg1.second)
					return -1;
				else
					return 0;
			} else
				return -1;
		}
		
		@Override
		public boolean equals(Object p) {
			return ((Pair3) p).first == first && ((Pair3) p).second == second && ((Pair3) p).third == third;
		}
		
		@Override
		public int hashCode() {
			return first * 1000 + second * 100 + third * 10;
		}
	}
    
	private static class Node<T extends Comparable<?>> {
	    Node<T> left, right, random;
	    T data;

	    public Node(T data) {
	        this.data = data;
	    }

		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private static class BTreePrinter {

	    public static <T extends Comparable<?>> void printNode(Node<T> root) {
	        int maxLevel = BTreePrinter.maxLevel(root);

	        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
	    }

	    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
	        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
	            return;

	        int floor = maxLevel - level;
	        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
	        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
	        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

	        BTreePrinter.printWhitespaces(firstSpaces);

	        List<Node<T>> newNodes = new ArrayList<Node<T>>();
	        for (Node<T> node : nodes) {
	            if (node != null) {
	                System.out.print(node.data);
//	                System.out.print(node.random.data);
	                newNodes.add(node.left);
	                newNodes.add(node.right);
	            } else {
	                newNodes.add(null);
	                newNodes.add(null);
	                System.out.print(" ");
	            }

	            BTreePrinter.printWhitespaces(betweenSpaces);
	        }
	        System.out.println("");

	        for (int i = 1; i <= endgeLines; i++) {
	            for (int j = 0; j < nodes.size(); j++) {
	                BTreePrinter.printWhitespaces(firstSpaces - i);
	                if (nodes.get(j) == null) {
	                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
	                    continue;
	                }

	                if (nodes.get(j).left != null)
	                    System.out.print("/");
	                else
	                    BTreePrinter.printWhitespaces(1);

	                BTreePrinter.printWhitespaces(i + i - 1);

	                if (nodes.get(j).right != null)
	                    System.out.print("\\");
	                else
	                    BTreePrinter.printWhitespaces(1);

	                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
	            }

	            System.out.println("");
	        }

	        printNodeInternal(newNodes, level + 1, maxLevel);
	    }

	    private static void printWhitespaces(int count) {
	        for (int i = 0; i < count; i++)
	            System.out.print(" ");
	    }

	    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
	        if (node == null)
	            return 0;

	        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
	    }

	    private static <T> boolean isAllElementsNull(List<T> list) {
	        for (Object object : list) {
	            if (object != null)
	                return false;
	        }

	        return true;
	    }

	}
	
	private static class TreeNode {
	    // data members
	    private int key;
	    private TreeNode left;
	    private TreeNode right;
	  
	    // Accessor methods
	    public int key()        { return key; }
	    public TreeNode left()  { return left; }
	    public TreeNode right() { return right; }
	  
	    // Constructor
	    public TreeNode(int key)
	   { this.key = key; left = null; right = null; }
	  
	    // Methods to set left and right subtrees
	    public void setLeft(TreeNode left)   { this.left = left; }
	    public void setRight(TreeNode right) { this.right = right; }
	}
	
	private static class RandomHash {
		/*
		RandomHash ds = new RandomHash();
        ds.add(10);
        ds.add(20);
        ds.add(30);
        ds.add(40);
        System.out.println(ds.search(30));
        ds.remove(20);
        ds.add(50);
        System.out.println(ds.search(50));
        System.out.println(ds.getRandom());
		 */
		HashMap<Integer, Integer> map;
		ArrayList<Integer> list;
		
		public RandomHash() {
			map = new HashMap<Integer, Integer>();
			list = new ArrayList<Integer>();
		}
		
		void add(int value) {
			if (map.containsKey(value))
				return;
			
			list.add(value);
			map.put(value, list.size() - 1);
		}
		
		boolean remove(int value) {
			if (!map.containsKey(value))
				return false;
			
			// swap element "value" with the last element, 
			// for constant time removal
			int index = map.get(value);
			list.set(index, list.get(list.size() - 1));
			list.remove(list.size() - 1);
			
			// update hash map
			map.put(value, index);
			
			return true;
		}
		
		int search(int value) {
			if (map.containsKey(value))
				return map.get(value);
			return -1;
		}
		
		int getRandom() {
			return list.get(new Random().nextInt(list.size()));
		}
	}
	
	public static int solution(int[] A) {
		// HashMap used to store the number of appearances of a number
		// in the array
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		long pair_count = 0;

		// Store the number of appearances for each number
		for (int i : A)
			if (map.containsKey(i))
				map.replace(i, map.get(i) + 1);
			else
				map.put(i, 1);

		// For each different number in the array (all keys in the map)
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			// Get the number of appearances in the array
			long no_appearances = entry.getValue();

			// Compute the number of pairs only if there are more than
			// two appearances for the current number
			if (no_appearances > 1)
				// The number of different pairs is indicated by the formula:
				// (N-1) * N / 2
				pair_count += no_appearances * (no_appearances - 1) / 2;
		}

		// if the total number of identical pairs of indices
		// is greater than 1,000,000,000, return 1,000,000,000.
		if (pair_count > 1000000000)
			return 1000000000;
		// else, return the number of identical pairs of indices
		return (int) pair_count;
	}

	public static int solution2(String S) {
		String[] operations = S.split(" ");
		Stack<Long> stack = new Stack<Long>();
		Long number1, number2;

		for (String op : operations) {
			Long number = null;
			try {
				number = Long.valueOf(op);
			} catch (NumberFormatException ex) {
				// operation is not a number, continue
			}

			// if a number was received, push it to the stack
			if (number != null) {
				stack.push(number);
				continue;
			}

			// all other operations require at least one element in the stack
			if (stack.isEmpty())
				return -1;

			switch (op) {
			case "POP":
				// remove the element from the stack
				stack.pop();
				break;
			case "DUP":
				// duplicate the peek element
				stack.push(stack.peek());
				break;
			default:
				// operations + and - require at least two elements in the stack
				// get the top element
				number1 = stack.pop();
				if (stack.isEmpty())
					return -1;
				// get the second element
				number2 = stack.pop();

				// for operation +: sum the numbers
				if (op.equals("+"))
					stack.push(number1 + number2);
				// for operation -: substract the numbers
				else if (op.equals("-"))
					stack.push(number1 - number2);
				// for operations now known, return -1
				else {
					System.err.println("Operation not defined");
					return -1;
				}
				break;
			}
		}

		// if there is no element at the end of the execution, return -1
		if (stack.isEmpty())
			return -1;
		// return the top element from the stack
		return stack.peek().intValue();
	}

	public static int solution3(int a, int b) {
		int old = 1, curr = 1;

		HashSet<Integer> history = new HashSet<Integer>();

		if (a % b == 0)
			return 0;

		while (!history.contains(curr)) {
			history.add(old);
			curr = (a * old) % b;
			old = curr;
			if (curr == 0) {

				break;
			}
		}

		int max = 0;
		for (int v : history)
			if (v > max)
				max = v;

		return max;

	}

	static int binarySearch(int[] arr, int value) {
		int start = 0, end = arr.length - 1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (arr[mid] == value)
				return 0;
			else if (arr[mid] > value)
				end = mid - 1;
			else
				start = mid + 1;
		}
		return Math.min(Math.abs(arr[start - 1] - value), Math.abs(arr[start] - value));
	}

	public static void printArr(int[] a) {
		for (int i : a)
			System.out.print(i + ", ");
		System.out.println();
	}
	
	public static void printArr(int[] a, String s) {
		System.out.print("[");
		for (int i : a)
			System.out.print(i + ", ");
		System.out.println("]" + s);
	}

	public static void selectionSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			// swap(arr, i, findMinIndex(arr, i));
			
			// change in place
			move(arr, i, findMinIndex(arr, i));
		}
	}
	public static int findMinIndex(int[] arr, int index) {
		int minIndex = index;
		int minValue = arr[minIndex];
		for (int i = index + 1; i < arr.length; i++) {
			if (arr[i] < minValue) {
				minIndex = i;
				minValue = arr[i];
			}
		}
		return minIndex;
	}
	public static void swap(int[] arr, int i1, int i2) {
		if (i2 > i1) {
			int temp = arr[i1];
			arr[i1] = arr[i2];
			arr[i2] = temp;
		}
	}
	public static void move(int[] arr, int i1, int i2) {
		int temp = arr[i2];
		System.arraycopy(arr, i1, arr, i1+1, i2 - i1);
		arr[i1] = temp;
	}
	public static void insertionSort(int[] arr) {
		for (int which = 1; which < arr.length; which++) {
			int value = arr[which];
			for (int i = 0; i < which; i++) {
				if (arr[i] > value) {
					System.arraycopy(arr, i, arr, i+1, which - i);
					arr[i] = value;
					break;
				}
			}
		}
	}
	
	public static void quicksort(int[] arr, int lo, int hi) {
		int i = lo, j = hi, aux = 0, center = lo + (hi - lo) / 2;
		
		while (i <= j) {
			while (arr[i] < arr[center])
				i++;
			while (arr[j] > arr[center])
				j--;
			
			if (i <= j) {
				aux = arr[i];
				arr[i] = arr[j];
				arr[j] = aux;
				i++;
				j--;
			}
		}
		
		if (j > lo)
			quicksort(arr, lo, j);
		if (i < hi)
			quicksort(arr, i, hi);
	}
	
    public static boolean checkPalindrome(String s, int start, int end) {
        for (int i = start; i < start + (end+1-start) / 2; i++) {
            if (s.charAt(i) != s.charAt(end - (i - start)))
                return false;
        }
        return true;
    }
    
    static int palindromeIndex(String s) {
        int lo = 0, hi = s.length() - 1;
        
        if (checkPalindrome(s, 0, s.length()-1))
            return -1;
        
        while (lo <= hi) {
        	if (s.charAt(lo) == s.charAt(hi)) {
                lo++;
                hi--;
			} else {
				if (checkPalindrome(s, lo + 1, hi))
					return lo;
				else if (checkPalindrome(s, lo, hi - 1))
					return hi;
				else
					return -1;
			}
        }
        
		return -1;
    }

	public static int palindromeIndex2(String s) {
		// Complete this function
		int index = -1;
		int start = 0, end = s.length() - 1;

		// check the beginning with the end of the array
		while (start < end) {
			// if the characters differs, we found the issue
			if (s.charAt(start) != s.charAt(end)) {
				// if there are some more characters, look at the next ones
				if (s.charAt(start) == s.charAt(end - 1)) {
					if (start + 1 <= end - 2)
						if (s.charAt(start + 1) != s.charAt(end - 2))
							return start;

					return end;
				}
				if (s.charAt(end) == s.charAt(start + 1)) {
					if (end - 1 >= start + 2)
						if (s.charAt(end - 1) != s.charAt(start + 2))
							return end;

					return start;
				}
			}
			start++;
			end--;
		}

		return index;
	}
	
	// Complete the super_reduced_string function below.
	static String super_reduced_string(String s) {
		StringBuilder sb = new StringBuilder();
		boolean operation = true;

		while (operation) {
			sb = new StringBuilder();
			operation = false;
			
			for (int i = 0; i < s.length(); i++)
				if (i+1 < s.length() && s.charAt(i) == s.charAt(i+1)) {
					i++;
					operation = true;
				} else
					sb.append(s.charAt(i));
			
			
			s = sb.toString();
		}

		if (sb.toString().length() == 0)
			return "Empty String";
		return sb.toString();
	}
	
    static String isValid(String s) {
        int[] occurrences = new int[26];
        int min = Integer.MAX_VALUE, count = 0;
        
        for (int i = 0; i < s.length(); i++)
            occurrences[s.charAt(i) - 'a']++;
        
        for (int i = 0; i < 26; i++) {
            if (min > occurrences[i])
                min = occurrences[i];
        }
        for (int i = 0; i < 26; i++) {
            if (occurrences[i] - min > 1)
                return "NO";
            else if (occurrences[i] - min == 1)
                count++;
            if (count != 1)
                return "NO";
        }

        return "YES";
    }
    
    public static String createString(String s, Character c1, Character c2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c1)
                if (sb.length() > 0 && sb.charAt(sb.length()-1) != c2)
                    return null;
                else
                    sb.append(s.charAt(i));
            else if (s.charAt(i) == c2) {
                if (sb.length() > 0 && sb.charAt(sb.length()-1) != c1)
                    return null;
                else
                    sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
    
    // Complete the twoCharaters function below.
    static int twoCharaters(String s) {
        ArrayList<Character> chars = new ArrayList<Character>();
        int max = 0;
        
        for (Character c : s.toCharArray())
            if (!chars.contains(c))
                chars.add(c);
        
        for (int i = 0; i < chars.size() - 1; i++)
            for (int j = i+1; j < chars.size(); j++) {
                String str = createString(s, chars.get(i), chars.get(j));
                int crtMax = 0;
                if (str != null)
                    crtMax = str.length();
                if (crtMax > max)
                    max = crtMax;
            }
        
        return max;
    }
    
    static int anagram(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int i, count = 0;
        
        if (s.length() % 2 != 0)
            return -1;
        
        for (i = 0; i < s.length() / 2; i++)
            if (map.containsKey(s.charAt(i)))
                map.replace(s.charAt(i), map.get(s.charAt(i))+1);
            else
                map.put(s.charAt(i), 1);
        
        for (; i < s.length(); i++)
            if (map.containsKey(s.charAt(i)))
                map.replace(s.charAt(i), map.get(s.charAt(i))-1);
            else
                map.put(s.charAt(i), -1);
        
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0)
                count += entry.getValue();
        }
        
        return count;
    }
    
    static String caesarCipher(String s, int k) {
        char[] arr = s.toCharArray();
        
        // for (char ch : arr)
        //     if (Character.isLetter(ch))
        //         ch += k%26;
        
        for (int i = 0; i < arr.length; i++)
            if (Character.isLetter(arr[i]))
                if (Character.isUpperCase(arr[i])) {
                    arr[i] += k % 26;
                    if (arr[i] > 'Z')
                        arr[i] -= 26;
                } else if (Character.isLowerCase(arr[i])) {
                    arr[i] += k % 26;
                    if (arr[i] > 'z')
                        arr[i] -= 26;
                }
                
                
        return String.valueOf(arr);
    }
    static int theLoveLetterMystery(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length() / 2; i++) {
            count += Math.abs(s.charAt(i) - s.charAt(s.length() - i - 1));
        }
            
        return count;
    }
    
    public static boolean checkDuplicatesK(int[] arr, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i = 0; i < arr.length; i++) {
    		if (map.containsKey(arr[i]) && i - map.get(arr[i]) <= k)
				return true;
    		else
    			map.put(arr[i], i);
    	}
    	
    	return false;
    }
    
    public static int[] convertReduced(int[] arr) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i = 0; i < arr.length; i++)
    		map.put(arr[i], i);
    	
    	Arrays.sort(arr);
    	
    	int[] result = new int[arr.length];
    	for (int i = 0; i < arr.length; i++)
    		result[i] = map.get(arr[i]);
    	
    	return result;
    }
    
    public static Character maxOcc(String s) {
    	Character maxCh = null;
    	int maxOcc = -1;
    	int[] occurrences = new int[256];
    	
    	for (char c : s.toCharArray()) {
    		occurrences[c]++;
    		if (maxOcc < occurrences[c]) {
    			maxOcc = occurrences[c];
    			maxCh = c;
    		}
    	}
    	
    	return maxCh;
    }
    
    public static String getKey(String s) {
    	int[] occurrences = new int[26];
    	StringBuilder sb = new StringBuilder();
    	
    	for (char c : s.toCharArray())
    		occurrences[c-'a']++;
    	
    	for (int i = 0; i < 26; i++)
    		if (occurrences[i] != 0)
    			sb.append((char)('a' + i));
    	
    	return sb.toString();
    }
    
    // https://geeksforgeeks.org/print-words-together-set-characters/
    public static void wordsSameLetters(String[] words) {
    	HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();
    	
    	for (int i = 0; i < words.length; i++) {
    		String key = getKey(words[i]);
    		ArrayList<Integer> list;
    		if (map.containsKey(key))
    			list = map.get(key);
    		else
    			list = new ArrayList<Integer>();
    		list.add(i);
    		map.put(key, list);
    	}
    	
    	for (Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
    		ArrayList<Integer> list = entry.getValue();
    		for (int i : list)
    			System.out.print(words[i] + ", ");
    		System.out.println();
    	}
    }
    
    // https://geeksforgeeks.org/second-repeated-word-sequence/
    public static String secondMostRepetedStr(String[] words) {
    	HashMap<String, Integer> map = new HashMap<String, Integer>();
    	int mostCount = 0;
    	int secondCount = 0;
    	
    	for (String s : words) {
    		if (map.containsKey(s))
    			map.replace(s, map.get(s)+1);
    		else
    			map.put(s, 1);    		
    		
    		if (mostCount < map.get(s)) {
    			secondCount = mostCount;
    			mostCount = map.get(s);
    		} else if (secondCount < map.get(s)) {
    			secondCount = map.get(s);
    		}
     	}
    	for (Map.Entry<String, Integer> entry : map.entrySet())
    		if (entry.getValue() == secondCount)
    			return entry.getKey();
    	
    	return null;
    }
    
    // https://geeksforgeeks.org/smallest-element-repeated-exactly-k-times-not-limited-small-range/
    public static int repeatedKTimes(int[] arr, int k) {
    	TreeSet<Integer> treeSet = new TreeSet<Integer>();
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i : arr)
    		if (map.containsKey(i))
    			map.replace(i,  map.get(i) + 1);
    		else
    			map.put(i, 1);
    	
    	for (Map.Entry<Integer, Integer> entry : map.entrySet())
    		if (entry.getValue() == k)
    			treeSet.add(entry.getKey());

    	return treeSet.iterator().next();
    }
    
    // https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
    public static void findTopKOccurrences(int[] arr, int k) {
    	HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
    	
    	for (int i : arr)
    		if (occurrences.containsKey(i))
    			occurrences.replace(i, occurrences.get(i)+1);
    		else
    			occurrences.put(i, 1);
    	
    	Pair[] occSorted = new Pair[occurrences.size()];
    	int i = 0;
    	for (Map.Entry<Integer,Integer> entry : occurrences.entrySet())
    		occSorted[i++] = new Pair(entry.getKey(), entry.getValue());
    	
    	Arrays.sort(occSorted, new Comparator<Pair>() {
    		@Override
    		public int compare(Pair p1, Pair p2) {
    			if (p1.second < p2.second)
    				return 1;
    			else if (p1.second > p2.second)
    				return -1;
    			else {
    				if (p1.first < p2.first)
    					return 1;
    				else if (p1.first > p2.first)
    					return -1;
    				return 0;
    			}
    		}
		});
    	
    	for (i = 0; i < k; i++)
    		System.out.print(occSorted[i].first + " ");
    	System.out.println();
    }
    
    // https://www.geeksforgeeks.org/find-first-repeating-element-array-integers/
    public static int firstRepeating(int[] arr) {
    	HashSet<Integer> set = new HashSet<Integer>();
    	int smallestIndex = Integer.MAX_VALUE;
    	
    	for (int i = arr.length - 1; i >= 0; i--)
    		if (set.contains(arr[i]))
    			smallestIndex = i;
    		else
    			set.add(arr[i]);
    	
    	return arr[smallestIndex];
    }
    
    // https://geeksforgeeks.org/k-th-distinct-or-non-repeating-element-in-an-array/
    public static int KthNonRepeating(int[] arr, int k) {
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	for (int i : arr)
			if (map.containsKey(i))
				map.replace(i, map.get(i)+1);
			else
				map.put(i, 1);
		
		for (int i : arr)
			if (map.get(i) == 1)
				if (k == 1)
					return i;
				else
					k--;

		return -1;
	}
    
    // https://www.geeksforgeeks.org/pairs-of-positive-negative-values-in-an-array/
    public static void findPosNeg(int[] arr) {
    	HashSet<Integer> set = new HashSet<>();
    	for (int i : arr)
			set.add(i);
    	
    	for (int i : arr)
    		if (set.contains(i * (-1))) {
    			System.out.print(i*(-1)+ " " + i + " ");
    			set.remove(i);
    			set.remove(i*(-1));
    		}
    	System.out.println();
    }
    
    // https://geeksforgeeks.org/find-itinerary-from-a-given-list-of-tickets/
    public static void ticketItinerary(HashMap<String, String> dataSet) {
    	HashSet<String> dest = new HashSet<String>();
    	for (Map.Entry<String, String> entry : dataSet.entrySet())
    		dest.add(entry.getValue());
    	
    	String start = null;
    	for (Map.Entry<String, String> entry : dataSet.entrySet())
    		if (!dest.contains(entry.getKey())) {
    			start = entry.getKey();
    			break;
    		}
    	
    	while (dataSet.containsKey(start)) {
    		System.out.print(start + "->" + dataSet.get(start) + ",  ");
    		start = dataSet.get(start);
    	}
    	System.out.println();
    }
    
    // https://geeksforgeeks.org/find-number-of-employees-under-every-manager/
    public static void noEmployees(HashMap<String, String> dataSet) {
    	HashMap<String, Integer> noEmpl = new HashMap<String, Integer>();
    	HashMap<String, ArrayList<String>> dataSetInv = new HashMap<String, ArrayList<String>>();
    	int maxEmpl = 0;
    	
    	for (Map.Entry<String, String> entry : dataSet.entrySet()) {
    		ArrayList<String> list;
    		if (dataSetInv.containsKey(entry.getValue()))
    			list = dataSetInv.get(entry.getValue());
    		else
    			list = new ArrayList<String>();
    		list.add(entry.getKey());
    		dataSetInv.put(entry.getValue(), list);
    		
    		if (list.size() > maxEmpl)
    			maxEmpl = list.size();
    	}
    	
    	for (int sizeEmpl = 0; sizeEmpl <= maxEmpl; sizeEmpl++) {
	    	for (String employee : dataSet.keySet()) {
	    		if (!dataSetInv.containsKey(employee))
	    			noEmpl.put(employee, 0);
	    		else if (dataSetInv.get(employee).size() == sizeEmpl) {
	    			int sum = 0;
	    			for (String s : dataSetInv.get(employee))
	    				if (noEmpl.containsKey(s))
	    					sum += noEmpl.get(s) + 1;
	    			noEmpl.put(employee, sum);
	    		}
	    	}
    	}
    	
    	System.out.println(noEmpl);
    }
    
    // https://geeksforgeeks.org/check-if-an-array-can-be-divided-into-pairs-whose-sum-is-divisible-by-k/
    public static boolean subsetsSumDivisibleK(int[] arr, int k) {
    	/*
		System.out.println(subsetsSumDivisibleK(new int[] {9, 7, 5, 3}, 6));
		System.out.println(subsetsSumDivisibleK(new int[] {92, 75, 65, 48, 45, 35}, 10));
		System.out.println(subsetsSumDivisibleK(new int[] {91, 74, 66, 48}, 10));
    	 */
    	HashMap<Integer, Integer> remainders = new HashMap<Integer, Integer>();
    	
    	if (arr.length % 2 == 1)
    		return false;
    	
    	// count occurrences of remainders when dividing i by k
    	for (int i : arr) {
    		int remainder = i % k;
    		if (remainders.containsKey(remainder))
    			remainders.replace(remainder, remainders.get(remainder)+1);
    		else
    			remainders.put(remainder, 1);
    	}
    	
    	// for each element, check if its remainder has a correspondent
    	for (int i : arr) {
    		int remainder = i % k;
    		
    		// two halves
    		if (remainder * 2 == k) {
    			// -> an even number of "halves"
    			if (remainders.get(remainder) % 2 == 1)
    				return false;
    		// remainder is 0
    		} else if (remainder == 0) {
    			// even number of remainders 0 
    			if (remainders.get(remainder) % 2 == 1)
    				return false;
    		}else {
    			// remainder should have a correspondent
    			if (remainders.get(remainder) != remainders.get(k - remainder))
    				return false;
			}
    	}
    	
    	// all good
    	return true;
    }
    
    // https://geeksforgeeks.org/count-divisible-pairs-array/
    public static int countDivisiblePairs(int[] arr) {
    	/*
	    	System.out.println(countDivisiblePairs(new int[] {1, 2, 3} ));
			System.out.println(countDivisiblePairs(new int[] {2, 3, 5, 7} ));
		*/
    	int count = 0;
    	
    	Arrays.sort(arr);
    	
    	for (int i = arr.length - 1; i >= 0; i--)
    		for (int j = 0; j < i; j++)
    			if (arr[i] % arr[j] == 0)
    				count++;
    	
    	return count;
    }

    // https://www.geeksforgeeks.org/longest-subarray-sum-divisible-k/
    public static void longestSubarraySumK(int[] arr, int k) {
		/*
    	longestSubarraySumK(new int[] {2, 7, 6, 1, 4, 5}, 3);
		longestSubarraySumK(new int[] {3, 3, 6, 3, 3, 3}, 3);
		longestSubarraySumK(new int[] {3, 1, 6, 3, 3, 3}, 3);
		*/
    	int totalSum = 0;
    	HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for (int i : arr)
    		totalSum += i;
    	
    	int copySum = totalSum;
    	for (int i = 0; i < arr.length; i++) {
    		totalSum = copySum;
    		for (int j = arr.length - 1; j > 0; j--) {
	    		if (totalSum % k == 0) {
	    			map.put(i, j);
	    			break;
	    		} else
	    			totalSum -= arr[j];
    		}
    		copySum -= arr[i];
    	}
    	
    	// print result
    	int max = 0;
    	int minIndex = 0, maxIndex = 0;
    	for (Map.Entry<Integer, Integer> entry : map.entrySet())
    		if (max < entry.getValue() - entry.getKey()) {
    			max = entry.getValue() - entry.getKey();
    			minIndex = entry.getKey();
    			maxIndex = entry.getValue();
    		}
    	for (int i = minIndex; i <= maxIndex; i++)
    		System.out.print(arr[i] + "  ");
    	System.out.println();
    	
    }
	public static int longestSubarraySumK2(int arr[], int n, int k) {
		/*
 		int[] arr = new int[] {2, 7, 6, 1, 4, 5};
		int n = arr.length;
		int k = 3;
		System.out.println(longestSubarraySumK2(arr, n, k));
		 */
		// unodered map 'um' implemented as hash table
		HashMap<Integer, Integer> um = new HashMap<Integer, Integer>();

		// 'mod_arr[i]' stores (sum[0..i] % k)
		int mod_arr[] = new int[n];
		int max = 0;
		int curr_sum = 0;

		// traverse arr[] and build up the array 'mod_arr[]'
		for (int i = 0; i < n; i++) {
			curr_sum += arr[i];

			// as the sum can be negative taking modulo twice
			mod_arr[i] = ((curr_sum % k) + k) % k;
		}

		for (int i = 0; i < n; i++) {
			// if true then sum(0..i) is divisible by k
			if (mod_arr[i] == 0) {
				// update 'max'
				max = i + 1;
			}

			// if value 'mod_arr[i]' not present in 'um' then store it 
			// in 'um' with index of its first occurrence
			else if (um.containsKey(mod_arr[i]) == false)
				um.put(mod_arr[i], i);
			// if true, then update 'max'
			else if (max < (i - um.get(mod_arr[i])))
				max = i - um.get(mod_arr[i]);
		}

		// required length of longest subarray with sum divisible by 'k'
		return max;
	}

	// https://www.geeksforgeeks.org/subarray-no-pair-sum-divisible-k/
	public static int subArrayNoPairSumDivK(int[] arr, int k) {
		int result = 0;
		
		for (int i = 0; i < arr.length; i++) {
			HashSet<Integer> rests = new HashSet<Integer>();
			rests.add(arr[i] % k);
			int j = i+1;
			for (; j < arr.length; j++) {
				int crtRest = arr[j] % k;
				if (crtRest == 0 && rests.contains(0))
					break;
				else if (rests.contains(k - crtRest))
					break;
				else
					rests.add(crtRest);
			}

			int crtResult = j - i;
			if (crtResult > result)
				result = crtResult;
		}
		
		return result;
	}
	public static int subArrayNoPairSumDivK2(int[] arr, int k) {
		/*
		System.out.println(subArrayNoPairSumDivK2(new int[] {3,7,1,9,2}, 3));
		System.out.println(subArrayNoPairSumDivK2(new int[] {2, 4, 4, 3}, 4));
		 */
		int maxCount = 0;
		// keep track of rests whithin a window
		HashSet<Integer> window_rests = new HashSet<Integer>();
		window_rests.add(arr[0] % k);
		int start_window = 0;
		
		for (int end_window = 1; end_window < arr.length; end_window++) {
			// crt element rest
			int crtRest = arr[end_window] % k;
			// check in the current window for elements that might 
			// sum to a number divisible by k
			for (int j = start_window; j < end_window; j++) {
				// if rest is 0, there must not be another 0 rest
				if (crtRest == 0 && window_rests.contains(0) ||
						// a matching rest must not be found
						window_rests.contains(k - crtRest)) {
					if (end_window - start_window > maxCount)
						maxCount = end_window - start_window;
					// if there is a matching rest, advance the window
					window_rests.remove(arr[start_window] % k);
					start_window++;
					break;
				} else
					// element is good -> add it to the window
					window_rests.add(crtRest);
			}
		}
		
		return maxCount;
	}
	
	// https://www.geeksforgeeks.org/find-four-elements-a-b-c-and-d-in-an-array-such-that-ab-cd/
	public static void find4Pairs(int[] arr) {
		/*
		find4Pairs(new int[] {3, 4, 7, 1, 2, 9, 8});
		 */
		int count = 0;

		HashMap<Integer, Pair> sums = new HashMap<Integer, Pair>();
		for (int i = 0; i < arr.length-1;  i++) {
			for (int j = i+1; j < arr.length; j++) {
				int sum = arr[i]+arr[j];
				if (sums.containsKey(sum)) {
					count++;
					System.out.println(arr[i] + "  " + arr[j] + "  " + sums.get(sum).first + "  " + sums.get(sum).second);
				} else
					sums.put(sum, new Pair(arr[i], arr[j]));
			}
		}
		
		System.out.println(count);
	}
	
	// https://geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
	public static void largestSubarraySum0(int[] arr) {
		/*
		largestSubarraySum0(new int[]{15, -2, 2, -8, 1, 7, 10, 23});
		largestSubarraySum0(new int[]{1, 2, 3});
		largestSubarraySum0(new int[]{1, 0, 3});
		 */
		HashMap<Integer, Integer> sums = new HashMap<Integer, Integer>();
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int startIndex = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sums.containsKey(sum)) {
				if (max < i - sums.get(sum)) {
					startIndex = sums.get(sum)+1;
					max = i - sums.get(sum);
				}				
			} else
				sums.put(sum, i);
		}
		
		if (max == Integer.MIN_VALUE) {
			System.out.println("No subarray with 0 sum.");
			return;
		}
		
		System.out.print("no of elements is: " + max + "   ||   ");
		for (int i = startIndex; i < startIndex + max; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	// https://geeksforgeeks.org/find-three-element-from-different-three-arrays-such-that-that-a-b-c-k/
	public static boolean sum3ArraysK(int[] arr1, int[] arr2, int[] arr3, int k) {
		/*
		System.out.println(sum3ArraysK(new int[] { 1 , 2 , 3 , 4 , 5 }, 
				new int[] { 2 , 3 , 6 , 1 , 2 }, 
				new int[] { 3 , 2 , 4 , 5 , 6 }, 9));
		System.out.println(sum3ArraysK(new int[] { 1 , 2 , 3 , 4 , 5 }, 
				new int[] { 2 , 3 , 6 , 1 , 2 }, 
				new int[] { 3 , 2 , 4 , 5 , 6 }, 20));
		 */
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : arr1)
			set.add(i);
		
		for (int i : arr2)
			for (int j : arr3)
				if (set.contains(k - i - j)) {
					System.out.println(k - i - j + "   " +  i + "   " + j);
					return true;
				}
		
		return false;
	}
	
	// https://geeksforgeeks.org/longest-increasing-consecutive-subsequence/
	public static void longestIncrConsecSubseq(int[] arr) {
		int[] memo = new int[arr.length];
		memo[0] = 1;
		
		for (int i = 1; i < arr.length; i++)
			if (arr[i-1] == arr[i] - 1)
				memo[i] = memo[i-1]+1;
			else
				memo[i] = 1;
		
		int max = 0;
		int index = 0;
		for (int i = 0; i < memo.length; i++)
			if (max < memo[i]) {
				max = memo[i];
				index = i;
			}

		for (int i = index - max + 1; i <= index; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}
	
	// https://geeksforgeeks.org/longest-subsequence-difference-adjacents-one-set-2/
	public static void longestSubseqAdjacent(int[] arr) {
		/*
		longestSubseqAdjacent(new int[] {10, 9, 4, 5, 4, 8, 6});
		longestSubseqAdjacent(new int[] {1, 2, 3, 2, 3, 7, 2, 1});
		 */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(arr[0], 1);
		
		for (int i = 1; i < arr.length; i++) {
			int index = i;
			for (int j = i-1; j >= 0; j--) 
				if (arr[j] == arr[i]+1 || arr[j] == arr[i]-1) {
					index = j;
					break;
				}
			if (index != i)
				map.put(arr[i], map.get(arr[index])+1);
			else
				map.put(arr[i], 1);
		}
		
		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			if (entry.getValue() > max)
				max = entry.getValue();
		
		System.out.println(max);
	}

	// https://www.geeksforgeeks.org/count-subsets-distinct-even-numbers/
	public static int subsetsDistinctEven(int[] arr) {
		/*
		System.out.println(subsetsDistinctEven(new int[] {4, 2, 1, 9, 2, 6, 5, 3}));
		System.out.println(subsetsDistinctEven(new int[] {10, 3, 4, 2, 4, 20, 10, 6, 8, 14, 2, 6, 9}));
		 */
		int noEven= 0;
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++)
			if (arr[i] % 2 == 0 && !set.contains(arr[i])) {
				set.add(arr[i]);
				noEven++;
			}
		return (int)Math.pow(2, noEven) - 1;
	}

	// https://geeksforgeeks.org/count-distinct-elements-in-every-window-of-size-k/
	public static void countDistinctWindowK(int[] arr, int k) {
		//TODO: use MAP instead of SET, because there may be more occurrences of an element
		// and when removing first element, the other occurrences are lost as well
		HashSet<Integer> set = new HashSet<Integer>();
		int start_window = 0;
		int end_window = 0;
		
		for (int i = 0; i < k; i++)
			set.add(arr[i]);
		
		end_window = k;

		System.out.println(set.size());
		System.out.println(set);
		while (end_window < arr.length) {
			set.remove(arr[start_window]);
			start_window++;
			set.add(arr[end_window]);
			end_window++;

			System.out.println(set.size());
			System.out.println(set);
		}
	}
	
	public static BigInteger pow(int x, int p) {
		if (p == 0)
			return BigInteger.ONE;
		if (p % 2 == 0) {
			BigInteger result = pow(x, p/2);
			return result.multiply(result);
		} else {
			BigInteger result = pow(x, (p-1)/2);
			return result.multiply(result.multiply(BigInteger.valueOf(x)));
		}
	}
	public static BigInteger pow2(int x, int p) {
		if (p == 0)
			return BigInteger.ONE;
		return pow2(x, p-1).multiply(BigInteger.valueOf(x));
	}
	
	public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr[j] > arr[j+1]) {
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
    }
	
	// TODO: Not working
	public static int selectMedian(int[] arr, int k) {
		int median;
		if (arr.length == 0)
			return 0;
		if (arr.length > 5) {
			int[] B = new int[(int)Math.ceil(1.0 * arr.length / 5)];
			
			for (int i = 0; i < arr.length; i += 5) {

				int[] temp = new int[5];
				for (int j = i; j < arr.length && j < i + 5; j++)
					temp[j - i] = arr[j];
				bubbleSort(temp);

				// get median
				B[i / 5] = temp[2];
			}

			median = selectMedian(B, B.length / 2);
		} else
			median = arr[arr.length / 2];
		
		int j = rearrange(arr, median);
		
		if (k < j)
			return selectMedian(Arrays.copyOfRange(arr, 0, j-1), k);
		else if (k == j)
			return median;
		else
			return selectMedian(Arrays.copyOfRange(arr, j+1, arr.length), k-j);
	}
	// move all elements smaller than the median to its left
	// and the elements bigger to the right
	// return median's index
	private static int rearrange(int[] arr, int median) {
		int[] copy = Arrays.copyOf(arr, arr.length);
		int k = 0;
		int noMedian = 0;
		for (int i = 0; i < copy.length; i++)
			if (copy[i] < median)
				arr[k++] = copy[i];
			else if (copy[i] == median)
				noMedian++;
		
		int index = k + noMedian / 2;
		
		for (int i = 0; i < noMedian; i++)
			arr[k++] = median;
		
		for (int i = 0; i < copy.length; i++) 
			if (copy[i] > median)
				arr[k++] = copy[i];

		return index;
	}
	
	// https://geeksforgeeks.org/largest-increasing-subsequence-of-consecutive-integers/
	public static int largestIncrSubseq(int[] arr) {
		/*
		System.out.println(largestIncrSubseq(new int[]  {1, 1, 1, 1, 1} ));
		System.out.println(largestIncrSubseq(new int[]  {5, 7, 6, 7, 8} ));
		System.out.println(largestIncrSubseq(new int[]  {5, 7, 8, 7, 5} ));
		System.out.println(largestIncrSubseq(new int[]   { 2, 5, 3, 7, 4, 8, 5, 13, 6 } ));
		*/
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int max = 0;
		int last = -1;
		
		for (int i : arr)
			if (map.containsKey(i-1)) {
				map.put(i, map.get(i-1) + 1);
				if (max < map.get(i)) {
					max = map.get(i);
					last = i;
				}
			} else
				map.put(i, 1);

		if (max != 0) {
			for (int i = last - max + 1; i <= last; i++)
				System.out.print(i + " ");
			System.out.println("");
		}
		
		return max;
	}
	
	// https://geeksforgeeks.org/maximum-possible-sum-window-array-elements-window-array-unique/
	public static int maxSumWindow(int[] arr1, int[] arr2) {
		/*
		System.out.println(maxSumWindow(new int[] {0,1,2,0,1,2}, new int[] {0,1,2,0,1,2}));
		System.out.println(maxSumWindow(new int[] {0, 1, 2, 3, 0, 1, 4}, new int[] {9, 8, 1, 2, 3, 4, 5}));
		System.out.println(maxSumWindow(new int[] {0, 1, 2, 0, 2}, new int[] {5, 6, 7, 8, 2}));
		*/
		int sum = 0;
		int startWindow = 0;
		int maxSum = 0;
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < arr1.length; i++) {
			if (set.contains(arr1[i])) {
				// eliminate elements in the window until the repeated element
				for (int j = startWindow; j <= i; j++) {
					// remove from window
					set.remove(arr1[j]);
					// substract from sum
					sum -= arr2[j];
					// when reaching the crt element, advance the start window to the next element
					if (arr1[j] == arr1[i]) {
						startWindow = j+1;
						break;
					}
				}
			}
			
			// add the current element
			sum += arr2[i];
			set.add(arr1[i]);
			
			// update max sum
			if (maxSum < sum)
				maxSum = sum;
		}
		
		return maxSum;
	}
	
	// https://www.geeksforgeeks.org/check-array-contains-contiguous-integers-duplicates-allowed/
	public static boolean checkContiguosDuplicates(int[] arr) {
		/*
		System.out.println(checkContiguosDuplicates(new int[] {5,3,1,4,2,1,3,4,5}));
		System.out.println(checkContiguosDuplicates(new int[] {5,3,6,4,6,3,4,5}));
		System.out.println(checkContiguosDuplicates(new int[] {10, 14, 10, 12, 12, 13, 15}));
		System.out.println(checkContiguosDuplicates(new int[] {5, 2, 3, 6, 4, 4, 6, 6}));
		 */
		HashSet<Integer> distinctElements = new HashSet<Integer>();
		int min = arr[0];
		int max = arr[0];
		int sum = 0;
		
		// find min and max element
		for (int i : arr) {
			if (!distinctElements.contains(i))
				sum += i;
			
			if (min > i)
				min = i;
			if (max < i)
				max = i;
			
			distinctElements.add(i);
		}
		
		// compute the correct sum with Gauss
		int correctSum = max * (max+1) / 2 - (min-1) * min / 2;

		// compare sums
		return sum == correctSum;
	}
	
	// https://geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-1/
	public static int largestSubarrayContigousNoDupl(int[] arr) {
		/*
		System.out.println(largestSubarrayContigousNoDupl(new int[] {10, 12, 11}));
		System.out.println(largestSubarrayContigousNoDupl(new int[] {14, 12, 11, 20}));
		System.out.println(largestSubarrayContigousNoDupl(new int[] {1, 56, 58, 57, 90, 92, 94, 93, 91, 45}));
		 */
		int maxLen = 1;
		
		// for each subarray
		for (int i = 0; i < arr.length-1; i++) {
			// store min and max
			int max = arr[i];
			int min = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				if (max < arr[j])
					max = arr[j];
				if (min > arr[j])
					min = arr[j];
				// if difference between max-min and indexes j-i is the same,
				// elements are contiguous
				if (max - min == j - i)
					if (maxLen < j - i + 1)
						maxLen = j - i + 1;
			}
		}
		
		return maxLen;
	}
	
	// https://www.geeksforgeeks.org/length-largest-subarray-contiguous-elements-set-2/
	public static int largestSubarrayContigousWithDupl(int[] arr) {
		/*
		System.out.println(largestSubarrayContigousWithDupl(new int[] {10, 12, 11}));
		System.out.println(largestSubarrayContigousWithDupl(new int[] {14, 12, 11, 20}));
		System.out.println(largestSubarrayContigousWithDupl(new int[] {1, 56, 58, 57, 90, 92, 94, 93, 91, 45}));
		
		System.out.println(largestSubarrayContigousWithDupl(new int[] {10, 12, 12, 10, 10, 11, 10}));
		System.out.println(largestSubarrayContigousWithDupl(new int[] {14, 20, 20, 11, 14, 12, 12, 12, 11, 12, 12, 11, 20}));
		 */
		int maxLen = 1;
		
		// for each subarray
		for (int i = 0; i < arr.length-1; i++) {
			HashSet<Integer> crtSubarray = new HashSet<Integer>();
			crtSubarray.add(arr[i]);
			// store min and max
			int max = arr[i];
			int min = arr[i];
			for (int j = i+1; j < arr.length; j++) {
				crtSubarray.add(arr[j]);
				
				if (max < arr[j])
					max = arr[j];
				if (min > arr[j])
					min = arr[j];
				// if difference between max-min and indexes j-i is the same,
				// elements are contiguous
				if (max - min + 1 == crtSubarray.size())
					if (maxLen < crtSubarray.size())
						maxLen = crtSubarray.size();
			}
		}
		
		return maxLen;
	}
	
	// https://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
	public static boolean checkSubarraySum0(int[] arr) {
		/*
		System.out.println(checkSubarraySum0(new int[] {4, 2, -3, 1, 6}));
		System.out.println(checkSubarraySum0(new int[] {4, 2, 0, 1, 6}));
		System.out.println(checkSubarraySum0(new int[] {-3, 2, 3, 1, 6}));
		 */
		HashSet<Integer> set = new HashSet<Integer>();
		int totalSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			// find sum for elements arr[0]..arr[i]
			totalSum += arr[i];
			
			// if an equal sum was introduced earlier into the set,
			// than some elements reduced themselves
			if (set.contains(totalSum))
				return true;
			
			set.add(totalSum);
		}
		
		return false;
	}
	
	// https://geeksforgeeks.org/print-all-subarrays-with-0-sum/
	public static void printAllSubarraysSum0(int[] arr) {
		/*
		printAllSubarraysSum0(new int[] {6, 3, -1, -3, 4, -2, 2, 4, 6, -12, -7});
		 */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int totalSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			// find sum for elements arr[0]..arr[i]
			totalSum += arr[i];
			
			if (totalSum == 0)
				System.out.println("0   " + i);
			
			// if an equal sum was introduced earlier into the set,
			// than some elements reduced themselves
			if (map.containsKey(totalSum))
				System.out.println((map.get(totalSum)+1) + "   " + i);
			else
				map.put(totalSum, i);
		}
	}

	// https://geeksforgeeks.org/find-subarray-with-given-sum-in-array-of-integers/
	public static void subarraySum(int[] arr, int k) {
		/*
		subarraySum(new int[] {10, 2, -2, -20, 10}, -10);
		System.out.println("----------");
		subarraySum(new int[] {5, 2, -2, -20, 10}, -10);
		 */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int crtSum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			crtSum += arr[i];
			
			if (crtSum == k)
				System.out.println("Found sum equal to K: 0 - " + i);
			
			if (map.containsKey(crtSum - k))
				System.out.println("Found sum equal to K: " + (map.get(crtSum - k)+1) + " - " + i);
			
			map.put(crtSum, i);
		}
	}

	// https://geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
	public static void printVerticalSum(TreeNode root) {
		/* Create following Binary Tree
		        1
		      /    \
		    2        3
		   / \      / \
		  4   5    6   7
		
        */
		/*
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.left().setLeft(new TreeNode(4));
		root.left().setRight(new TreeNode(5));
		root.right().setLeft(new TreeNode(6));
		root.right().setRight(new TreeNode(7));
		
		printVerticalSum(root);
		*/
		TreeMap<Integer, Integer> sums = new TreeMap<Integer, Integer>();
		
		getSums(root, sums, 0);
		
		for (Map.Entry<Integer, Integer> entry : sums.entrySet())
			System.out.println(entry.getKey() + " -> " + entry.getValue());
	}
	public static void getSums(TreeNode node, TreeMap<Integer, Integer> sums, int level) {
		if (node == null)
			return;
		
		if (sums.containsKey(level))
			sums.replace(level, sums.get(level) + node.key);
		else
			sums.put(level, node.key);
		
		getSums(node.left, sums, level - 1);
		getSums(node.right, sums, level + 1);
	}
	
	// https://geeksforgeeks.org/group-shifted-string/
	public static void groupShiftedString(String[] str) {
		/*
		groupShiftedString(new String[] {"acd", "dfg", "wyz", "yab", "mop", "bdfh", "a", "x", "moqs"});
		 */
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for (String s : str) {
			String compressed = convertString(s);
			if (!map.containsKey(compressed))
				map.put(compressed, new ArrayList<>());
			map.get(compressed).add(s);
		}
		for (Map.Entry<String, ArrayList<String>> entry : map.entrySet())
			System.out.println(entry.getValue());
	}
	private static String convertString(String s) {
		if (s.length() < 2)
			return "0";
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i < s.length(); i++)
			sb.append((26 + s.charAt(i) - s.charAt(i-1)) % 26);
		return sb.toString();
	}

	// https://www.geeksforgeeks.org/minimum-insertions-to-form-a-palindrome-with-permutations-allowed/
	public static int insertionsFormPalindrome(String s) {
		/*
		System.out.println(insertionsFormPalindrome("geeksforgeeks"));
		System.out.println(insertionsFormPalindrome("geeksroforskeeg"));
		System.out.println(insertionsFormPalindrome("aabbc"));
		 */
		int count = 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : s.toCharArray())
			if (map.containsKey(c))
				map.replace(c, map.get(c)+1);
			else
				map.put(c, 1);
		
		// count odd occurrences of characters
		for (Map.Entry<Character, Integer> entry : map.entrySet())
			if (entry.getValue() % 2 == 1)
				count++;
		
		// for palindrome, only one odd occurrence is allowed
		if (count <= 1)
			return 0;
		return count - 1;
	}

	// https://geeksforgeeks.org/maximum-length-subsequence-difference-adjacent-elements-either-0-1-set-2/
	public static int lengthSubseqAdjacent(int[] arr) {
		/*
		System.out.println(lengthSubseqAdjacent(new int[] {2, 5, 6, 3, 7, 6, 5, 8}));
		System.out.println(lengthSubseqAdjacent(new int[] {-2, -1, 5, -1, 4, 0, 3}));
		 */
		int maxLen = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		if (arr.length == 0)
			return 0;
		
		map.put(arr[0], 1);
		
		for (int i = 1; i < arr.length; i++) {
			int len = 0;
			
			// TODO: important to compare len for smaller, equal and bigger
			if (map.containsKey(arr[i] - 1) && len < map.get(arr[i] - 1))
				len = map.get(arr[i] - 1);
			
			if (map.containsKey(arr[i]) && len < map.get(arr[i]))
				len = map.get(arr[i]);
			
			if (map.containsKey(arr[i] + 1) && len < map.get(arr[i] + 1))
				len = map.get(arr[i] + 1);
			
			map.put(arr[i], len + 1);
			
			maxLen = Math.max(maxLen, map.get(arr[i]));
		}
		
		return maxLen;
	}
	
	// https://www.geeksforgeeks.org/maximum-difference-between-frequency-of-two-elements-such-that-element-having-greater-frequency-is-also-greater/
	public static int maxFrequency(int[] arr) {
		/*
		System.out.println(maxFrequency(new int[] { 3, 1, 3, 2, 3, 2 }));
		*/
		int maxFreq = Integer.MIN_VALUE;
		TreeMap<Integer, Integer> map = new TreeMap<>(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				if (o1 < o2)
					return 1;
				else if (o1 > o2)
					return -1;
				return 0;
			}
		});
		
		for (int i : arr)
			if (map.containsKey(i))
				map.replace(i, map.get(i) + 1);
			else
				map.put(i, 1);
		
		ArrayList<Integer> list = new ArrayList<Integer>(map.keySet());
		for (int i = 0; i < list.size() - 1; i++) 
			for (int j = i + 1; j < list.size(); j++) {
				if (maxFreq < map.get(list.get(i) - map.get(list.get(j))))
					maxFreq = map.get(list.get(i) - map.get(list.get(j)));
			}
		
		return maxFreq;
	}
	
	// https://geeksforgeeks.org/difference-between-highest-and-least-frequencies-in-an-array/
	public static int diffOccurrences(int[] arr) {
		/*
		System.out.println(diffOccurrences(new int[] {7, 8, 4, 5, 4, 1, 1, 7, 7, 2, 5}));
		System.out.println(diffOccurrences(new int[] {1, 1, 1, 3, 3, 3}));
		 */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int min = Integer.MAX_VALUE, max = 0;
		
		if (arr.length == 0)
			return 0;
		
		for (int i : arr)
			if (map.containsKey(i))
				map.replace(i, map.get(i) + 1);
			else
				map.put(i, 1);
		
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int crtOcc = entry.getValue();
			if (min > crtOcc)
				min = crtOcc;
			if (max < crtOcc)
				max = crtOcc;
		}

		return max - min;
	}

	// https://www.geeksforgeeks.org/maximum-difference-first-last-indexes-element-array/
	public static int maxDiffIndexes(int[] arr) {
		/*
		System.out.println(maxDiffIndexes(new int[] {2, 1, 3, 4, 2, 1, 5, 1, 7}));
		System.out.println(maxDiffIndexes(new int[] {2, 2, 1, 1, 8, 8, 3, 5, 3} ));
		 */
		HashMap<Integer, Integer> map;
		HashMap<Integer, Integer> occurrences;
		int maxDifference = 0;
		
		if (arr.length == 0)
			return 0;
		
		map = new HashMap<Integer, Integer>();
		occurrences = new HashMap<Integer, Integer>();
		
		// save starting index for each different element
		for(int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i]))
				map.put(arr[i], i);
			if (occurrences.containsKey(arr[i]))
				occurrences.replace(arr[i], occurrences.get(arr[i]) + 1);
			else
				occurrences.put(arr[i], 1);
		}
		
		// search last index for each element
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			// only if it has multiple occurrences
			if (occurrences.containsKey(entry.getKey()))
				for (int i = arr.length - 1; i >= 0; i--)
					if (arr[i] == entry.getKey()) {
						int crtDiff = i - entry.getValue();
						if (maxDifference < crtDiff) {
							maxDifference = crtDiff;
							System.out.println(maxDifference + "  " + i + "  " + entry.getValue());
						}
						break;
					}
		
		return maxDifference;
	}
	
	// https://geeksforgeeks.org/maximum-possible-difference-two-subsets-array/
	public static int subsetsMaxDifference(int[] arr) {
		/*
		System.out.println(subsetsMaxDifference(new int[] {5, 8, -1, 4}));
		System.out.println(subsetsMaxDifference(new int[] {5, 8, 5, 4}));
		System.out.println(subsetsMaxDifference(new int[] {4, 2, -3, 3, -2, -2, 8}));
		 */
		HashSet<Integer> set1;
		HashSet<Integer> set2;
		int sum1 = 0, sum2 = 0;
		
		if (arr.length == 0) {
			System.out.println("No subsets can be created from empty array.");
			return 0;
		}
		
		// sort
		Arrays.sort(arr);
		
		set1 = new HashSet<Integer>();
		set2 = new HashSet<Integer>();
		
		// construct the 2 subsets
		for (int i : arr)
			if (i < 0) {
				if (set2.contains(i)) {
					set1.add(i);
					sum1 += i;
				} else {
					set2.add(i);
					sum2 += i;
				}
			} else if (set1.contains(i)) {
				set2.add(i);
				sum2 += i;
			} else {
				set1.add(i);
				sum1 += i;
			}
		
		// if no duplicates or negative numbers, put the smallest element
		//  into second subset and remove it from first subset
		if (set2.isEmpty()) {
			set1.remove(arr[0]);
			set2.add(arr[0]);
			sum1 -= arr[0];
			sum2 += arr[0];
		}
		
		return sum1 - sum2;
	}
	
	// https://www.geeksforgeeks.org/smallest-subarray-k-distinct-numbers/
	public static int maxLenWindowDiffK(int[] arr, int k) {
		/*
		maxLenWindowDiffK(new int[] { 1, 1, 2, 2, 3, 3, 4, 5} , 3);
		 */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxLen = 1, startWindow = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				if (map.size() < 3)
					map.put(arr[i], i);
				else {
					int crtLen = i - startWindow;
					if (maxLen < crtLen) {
						System.out.println(maxLen + "     " + i + "   " + startWindow);
						maxLen = crtLen;
					}
					
					// remove first elements from window until size is 2, 
					// so new elements may be added
					while (map.size() >= 3) {
						int start = arr[startWindow];
						if (map.get(start) == 1)
							map.remove(start);
						else
							map.replace(start, map.get(start) - 1);
						startWindow++;
					}
				}
			}
		}
		
		return maxLen;
	}
	public static int minLenWindowDiffK(int[] arr, int k) {
		/*
		System.out.println(minLenWindowDiffK(new int[] { 1, 2, 3, 3, 4, 5, 5, 5} , 3));
		 */
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int minLen = Integer.MAX_VALUE, startWindow = 0;
		
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i])) {
				// no of different numbers is smaller than k
				if (map.size() < k)
					// then add it to the window
					map.put(arr[i], 1);
				else {
					// different element to be added to the window, 
					// but there is no space -> some elmenets must be removed
					// so update len
					int crtLen = i - startWindow;
					if (minLen > crtLen)
						minLen = crtLen;
					
					// remove first elements from window until size is 2, 
					// so new elements may be added
					while (map.size() >= k) {
						int start = arr[startWindow];
						if (map.get(start) == 1)
							map.remove(start);
						else
							map.replace(start, map.get(start) - 1);
						startWindow++;
					}
					
					// advance over starting duplicates
					while (startWindow < arr.length && 
							arr[startWindow] == arr[startWindow + 1]) {
						map.replace(arr[startWindow], map.get(arr[startWindow]) - 1);
						startWindow++;
					}
					
					map.put(arr[i], 1);
				}
			} else {
				// duplicate added to window -> len increased -> update crt len
				int crtLen = i - startWindow;
				if (minLen > crtLen)
					minLen = crtLen;
				map.replace(arr[i], map.get(arr[i]) + 1);
			}
		}
		
		// remove possible ending duplicates
		int endWindow = arr.length - 1;
		while (endWindow > startWindow && 
				arr[endWindow] == arr[endWindow - 1]) {
			map.replace(arr[startWindow], map.get(arr[startWindow]) - 1);
			endWindow--;
		}
		
		return Math.min(minLen, endWindow - startWindow + 1);
	}
	
	// https://geeksforgeeks.org/longest-subarray-not-k-distinct-elements/
	public static int longestSubarrayDiffK(int[] arr, int k) {
		/*
		System.out.println(longestSubarrayDiffK(new int[] {1, 2, 1, 4, 5}, 3));
		System.out.println(longestSubarrayDiffK(new int[] {1, 2, 1, 4, 5}, 6));
		System.out.println(longestSubarrayDiffK(new int[] {6, 5, 1, 2, 3, 2, 1, 4, 5}, 3));
		 */
		HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer> ();
		int startWindow = 0, maxLen = 1, startIndex = 0;

		for (int i = 0; i < arr.length; i++) {
			// if the current element does not exists in the window
			if (!occurrences.containsKey(arr[i])) {
				// there is no place in the window for the current element
				//  => remove starting elements until there is space
				if (occurrences.size() >= k) {
					// advance window until number of different elements is smaller than k
					while (startWindow < arr.length && occurrences.size() >= k) {
						if (occurrences.get(arr[startWindow]) > 1)
							occurrences.replace(arr[startWindow], occurrences.get(arr[startWindow]) - 1);
						else
							occurrences.remove(arr[startWindow]);
						startWindow++;
					}
				}
				// put the current element in the occurrences map
				occurrences.put(arr[i], occurrences.get(arr[i]) == null ? 1 : occurrences.get(arr[i]) + 1);
			} else 
				// the current element exists in the window => update its count
				occurrences.put(arr[i], occurrences.get(arr[i]) + 1);
			
			// update maxLen
			if (maxLen < i - startWindow + 1) {
				maxLen = i - startWindow + 1;
				startIndex = startWindow;
			}
		}
		
		// print max subarray
		for (int i = startIndex; i < arr.length && i < startIndex + maxLen; i++)
			System.out.print(arr[i] + " ");
		System.out.print("\t=>\t");
		
		return maxLen;
	}
	
	// https://geeksforgeeks.org/sum-fai-aj-pairs-array-n-integers/
	public static int sumPairs(int[] arr) {
		/*
		System.out.println(sumPairs(new int[] {6, 6, 4, 4}));
		System.out.println(sumPairs(new int[] {1, 2, 3, 1, 3}));
		 */
		int total = 0;
		
		for (int i = 0; i < arr.length; i++)
			for (int j = i + 1; j < arr.length; j++)
				if (Math.abs(arr[j] - arr[i]) > 1)
					total += arr[j] - arr[i];

		return total;
	}

	// https://geeksforgeeks.org/maximize-elements-using-another-array/
	public static int[] maximizeArrays(int[] arr1, int[] arr2) {
		/*
		printArr(maximizeArrays(new int[] {2, 4, 3}, new int[] {5, 6, 1}));
		printArr(maximizeArrays(new int[] {7, 4, 8, 0, 1}, new int[] {9, 7, 2, 3, 6}));
		 */
		TreeSet<Integer> set = new TreeSet<>((x,y)->y-x);
		int[] result = new int[arr1.length];
		
		for (int i = 0; i < arr1.length; i++)
			add(arr1[i], set, arr1.length);
		for (int i = 0; i < arr2.length; i++)
			add(arr2[i], set, arr1.length);
		
		int k = 0;
		for (int i = 0; i < arr2.length; i++)
			if (set.contains(arr2[i])) {
				set.remove(arr2[i]);
				result[k++] = arr2[i];
			}
		
		for (int i = 0; i < arr1.length; i++)
			if (set.contains(arr1[i]))
				result[k++] = arr1[i];
		
		return result;
	}
	public static void add(int x, TreeSet<Integer> set, int len) {
		set.add(new Integer(x));
		ArrayList<Integer> list = new ArrayList<>(set);
		// if size is greater than len, remove smallest element
		if (set.size() > len) {
			set.remove(list.get(list.size() - 1));
			list.remove(list.size() - 1);
		}
	}
	// solution2
	public static int[] maximizeArrays2(int[] arr1, int[] arr2) {
		/*
		printArr(maximizeArrays2(new int[] {2, 4, 3}, new int[] {5, 6, 1}));
		printArr(maximizeArrays2(new int[] {7, 4, 8, 0, 1}, new int[] {9, 7, 2, 3, 6}));
		*/
		HeapK aux = new HeapK(arr1.length);
		int[] result = new int[arr1.length];
		
		// get biggest k elements from both arrays
		for (int i : arr1)
			aux.add(i);
		for (int i : arr2)
			aux.add(i);

		// print biggest k elements, starting with arr2
		int k = 0;
		for (int i : arr2)
			if (aux.contains(i)) {
				result[k++] = i;
				aux.remove(i);
			}
		for (int i : arr1)
			if (aux.contains(i))
				result[k++] = i;
		
		return result;
	}
	private static class HeapK {
		int[] sortedK;
		HashSet<Integer> set;
		int k;
		
		public HeapK(int k) {
			sortedK = new int[k];
			this.k = k;
			set = new HashSet<Integer>();
		}
		
		public void add(int x) {
			if (contains(x))
				return;
			for (int i = 0; i < k; i++) {
				if (sortedK[i] < x) {
					// update set
					set.add(x);
					set.remove(sortedK[k-1]);
					// move one position to the right all elements 
					//  to make space for the current one
					System.arraycopy(sortedK, i, sortedK, i+1, k-i-1);
					sortedK[i] = x;
					break;
				}
			}
		}
		
		public void remove(int x) {
			if (!contains(x))
				return;
			
			set.remove(x);
			for (int i = 0; i < k; i++)
				if (sortedK[i] == x)
					System.arraycopy(sortedK, i+1, sortedK, i, k-i-1);
			sortedK[k-1] = -1;
		}
		
		public boolean contains(int x) {
			return set.contains(x);
		}
		
		public void print() {
			System.out.println(set);
			printArr(sortedK);
		}
	}
	
	// https://geeksforgeeks.org/clone-binary-tree-random-pointers/
	/*
		Node<Integer> n4 = new Node<Integer>(4);
		Node<Integer> n5 = new Node<Integer>(5);
		Node<Integer> n6 = new Node<Integer>(6);
		Node<Integer> n7 = new Node<Integer>(7);
		Node<Integer> n2 = new Node<Integer>(2, n4, n5);
		Node<Integer> n3 = new Node<Integer>(3, n6, n7);
		Node<Integer> n1= new Node<Integer>(1, n2, n3);
		n1.random = n5;
		n2.random = n6;
		n3.random = n1;
		n4.random = n1;
		n5.random = n4;
		n6.random = n5;
		n7.random = n4;
		BTreePrinter.printNode(n1);
		Node<Integer> cloned = clone2(n1);
		BTreePrinter.printNode(cloned);
		
		System.out.println(checkEqualTrees(null, null));
		System.out.println(checkEqualTrees(n1, null));
		System.out.println(checkEqualTrees(null, n1));
		System.out.println(checkEqualTrees(n1, n1));
		System.out.println(checkEqualTrees(n1, n2));
		
		System.out.println(checkEqualTrees(n1, cloned));
	 */
	public static Node<Integer> cloneNormalNodes(Node<Integer> root, HashMap<Node<Integer>, Node<Integer>> map) {
		// creates a clone of all node in the tree, without random pointers
		Node<Integer> copy;
		
		if (root == null)
			return null;
		
		copy = new Node<Integer>(root.data);
		copy.left = cloneNormalNodes(root.left, map);
		copy.right = cloneNormalNodes(root.right, map);

		map.put(root, copy);
		
		return copy;
	}
	public static void cloneRandom(Node<Integer> root, Node<Integer> cloned, HashMap<Node<Integer>, Node<Integer>> map) {
		// using the map, sets the random pointers
		if (root == null || cloned == null)
			return;

		cloned.random = map.get(root.random);
		
		if (root.left != null)
			cloneRandom(root.left, cloned.left, map);
		if (root.right != null)
			cloneRandom(root.right, cloned.right, map);
	}
	public static Node<Integer> clone(Node<Integer> root) {
		HashMap<Node<Integer>, Node<Integer>> map = new HashMap<Node<Integer>, Node<Integer>>();
		// clone without random
		Node<Integer> cloned = cloneNormalNodes(root, map);
		// using the map and stacks, sets the random pointers
		Stack<Node<Integer>> stack1 = new Stack<Node<Integer>>();
		Stack<Node<Integer>> stack2 = new Stack<Node<Integer>>();
		stack1.push(cloned);
		stack2.push(root);
		while (!stack1.isEmpty() && !stack2.isEmpty()) {
			Node<Integer> cloned_node = stack1.pop();
			Node<Integer> root_node = stack2.pop();
			
			cloned_node.random = map.get(root_node.random);
			
			if (root_node.left != null) {
				stack1.push(cloned_node.left);
				stack2.push(root_node.left);
			}
			if (root_node.right != null) {
				stack1.push(cloned_node.right);
				stack2.push(root_node.right);
			}
		}
		
		return cloned;
	}
	public static Node<Integer> clone2(Node<Integer> root) {
		HashMap<Node<Integer>, Node<Integer>> map = new HashMap<Node<Integer>, Node<Integer>>();
		// clone without random
		Node<Integer> cloned = cloneNormalNodes(root, map);
		// set the random nodes
		cloneRandom(root, cloned, map);
		return cloned;
	}
	public static boolean checkEqualTrees(Node<Integer> n1, Node<Integer> n2) {
		// check if two trees are equal
		if (n1 == null && n2 == null)
			return true;
		if (n1 == null || n2 == null)
			return false;
		if (n1.random.data != n2.random.data || n1.data != n2.data)
			return false;
		
		return checkEqualTrees(n1.left, n2.left) && checkEqualTrees(n1.right, n2.right);
	}
	
	// https://www.geeksforgeeks.org/largest-subarray-with-equal-number-of-0s-and-1s/
	public static int maxSizeSubarrayEqual1and0(int[] arr) {
		/*
		System.out.println(maxSizeSubarrayEqual1and0(new int[] {1,1,1,1,1,1,0,1,0,0,1,0,1,1,1,1}));
		System.out.println(maxSizeSubarrayEqual1and0(new int[] {1, 0, 1, 1, 1, 0, 0}));
		System.out.println(maxSizeSubarrayEqual1and0(new int[] {1, 1, 1, 1}));
		System.out.println(maxSizeSubarrayEqual1and0(new int[] {0, 0, 1, 1, 0}));
		 */
		HashMap<Integer, Integer> map = new HashMap<>();
		// convert 0 in -1
		if (arr[0] == 0)
			arr[0] = -1;
		// arr[i] will contain the sum of all values from 0..i 
		for (int i = 1; i < arr.length; i++)
			if (arr[i] == 0)
				arr[i] = arr[i-1] - 1;
			else
				arr[i] += arr[i-1];
		
		printArr(arr);
		
		// we are looking for the longest subsequence with sum 0:
		// 1. save sums (keys) in hashmap with indexes where they are found (values)
		// 2. when crt sum is found in the hashmap -> elements from map.get(crtSum)..i sum up to 0
		// 3. update max sum
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++)
			if (map.containsKey(arr[i])) {
				if (max < i - map.get(arr[i]))
					max = i - map.get(arr[i]);
			} else
				map.put(arr[i], i);
				
		// check for subarrays with sum 0, starting from index 0
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == 0 && i+1 > max)
				max = i+1;
				
		if (max == Integer.MIN_VALUE)
			return arr.length;
		
		return max;
	}	
	
	// https://www.geeksforgeeks.org/count-subarrays-equal-number-1s-0s/
	public static int countNoSubarraysEqual1and0(int[] arr) {
		/*
		System.out.println(countNoSubarraysEqual1and0(new int[] {1, 0, 0, 1, 0, 1, 1}));
		 */
		// convert first 0 in -1
		if (arr[0] == 0)
			arr[0] = -1;
		// arr[i] will contain sum(arr[0]..arr[i])
		for (int i = 1; i < arr.length; i++)
			if (arr[i] == 0)
				arr[i] = arr[i-1] - 1;
			else
				arr[i] = arr[i-1] + 1;

		// map for occurrences of sums
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i : arr)
			if(map.containsKey(i))
				map.replace(i, map.get(i) + 1);
			else
				map.put(i, 1);
		
		int count = 0;
		// count all combinations of frequencies bigger than 1
		for (Map.Entry<Integer, Integer> entry : map.entrySet())
			if (entry.getValue() > 1)
				// comb of n taken by 2: n * (n-1) / 2
				count += entry.getValue() * (entry.getValue()-1) / 2;
		
		// add subarray starting at index 0, with sum 0
		for (int i : arr)
			if (i == 0)
				count++;
		
		return count;
	}
	
	// https://www.geeksforgeeks.org/substring-equal-number-0-1-2/
	public static int countNoSubarraysEqual012(int[] arr) {
		/*
		System.out.println(countNoSubarraysEqual012(new int[] { 0, 1, 0, 2, 0, 1, 0}));
		System.out.println(countNoSubarraysEqual012(new int[] { 1, 0, 2, 1, 0, 0, 2, 1, 1}));
		 */
		// to form subarrays with equal number of occurrences for 012
		// for subarray j->i, c0[i] - c0[j-1] == c1[i] - c1[j-1] == c2[i] - c2[j-1]
		// <==> c0[i] - c1[i] == c0[j-1] - c1[j-1] && c0[i] - c2[i] == c0[j-1] - c2[j-1]
		// Use a Map to store differences c0[i] - c1[i] && c0[i] - c2[i] as PAIRS:
		// (c0[i] - c1[i], c0[i] - c2[i])
		// Whenever a pair is found in the map, add the previous no of occurrence to the result.
		int c0 = 0, c1 = 0, c2 = 0, max = 0;

		HashMap<Pair, Integer> map = new HashMap<Pair, Integer>();
		map.put(new Pair(0,0), 1);
		
		for (int i = 0; i < arr.length; i++) {
			// keep track of count of 0,1,2
			if (arr[i] == 0)
				c0++;
			else if (arr[i] == 1)
				c1++;
			else
				c2++;

			// count no occurrences of pair in the map
			Pair p = new Pair(c0 - c1, c0 - c2);
			if (map.containsKey(p))
				map.replace(p, map.get(p) + 1);
			else
				map.put(p, 1);
			
			max += map.get(p) - 1;
		}
		
		return max;
	}
	
	// https://www.geeksforgeeks.org/print-triplets-sorted-array-form-ap/
	public static void printArithmeticProgression(int[] arr) {
		/*
		printArithmeticProgression(new int[] { 2, 6, 9, 12, 17, 22, 31, 32, 35, 42 });
		printArithmeticProgression(new int[] { 3, 5, 6, 7, 8, 10, 12});
		 */
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < arr.length; i++) {
			set.add(arr[i]);
			for (int j = i + 1; j < arr.length; j++) {
				int diff = arr[j] - arr[i];
				if (set.contains(arr[i] - diff))
					System.out.println(arr[i] - diff + ", " + arr[i] + ", " + arr[j]);
			}
		}
		System.out.println();
	}
	public static void printArithmeticProgression2(int[] arr) {
		HashSet<Integer> set = new HashSet<Integer>();
		int max = arr[arr.length - 1];
		int min = arr[0];
		
		for (int i = 0; i < arr.length; i++)
			set.add(arr[i]);
		
		for (int i = 0; i < arr.length; i++) {
			int range = Math.min(max - arr[i], arr[i] - min);
			for (int j = 1; j <= range; j++) 
				if (set.contains(arr[i] - j) && set.contains(arr[i] + j))
					System.out.println((arr[i] - j) + ", " + arr[i] + ", " + (arr[i] + j));
		}
		System.out.println();
	}
	
	// https://www.geeksforgeeks.org/unique-triplets-sum-given-value/
	public static void printTripletsSum(int[] arr, int sum) {
		for (int i = 0; i < arr.length - 2; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = i+1; j < arr.length; j++) {
				if (set.contains(sum - arr[i] - arr[j]))
					System.out.print("[" + arr[i] + ", " + arr[j] + ", " + (sum - arr[i] - arr[j]) + "]  ");
				set.add(arr[j]);
			}
		}
	}
	
	// https://www.geeksforgeeks.org/find-triplets-array-whose-sum-equal-zero/
	public static void printTripletsSum0(int[] arr) {
		/*
		printTripletsSum0(new int[] {0, -1, 2, -3, 1});
		 */
		for (int i = 0; i < arr.length - 1; i++) {
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = i + 1; j < arr.length; j++) {
				if (set.contains(-(arr[i] + arr[j])))
					System.out.println(arr[i] + ", " + arr[j] + ", " + (-arr[i] - arr[j]));
				set.add(arr[j]);
			}
		}
	}	
	public static void printTripletsSum0_2(int[] arr) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length - 1; i++) {
			int lo = i+1;
			int hi = arr.length - 1;
			while (lo <= hi) {
				if (arr[i] + arr[lo] + arr[hi] == 0) {
					System.out.println(arr[i] + ", " + arr[lo] + ", " + arr[hi]);
					lo++;
					hi--;
				} else if (arr[i] + arr[lo] + arr[hi] < 0)
					lo++;
				else if (arr[i] + arr[lo] + arr[hi] > 0)
					hi--;
			}
		}
	}
	
	// https://geeksforgeeks.org/count-number-triplets-product-equal-given-number/
	public static int countTripletsProduct(int[] arr, int product) {
		/*
		System.out.println(countTripletsProduct(new int[] { 1, 4, 6, 2, 3, 8}, 24));
		 */
		int count = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == 0)
				continue;
			HashSet<Integer> set = new HashSet<Integer>();
			for (int j = i+1; j < arr.length; j++) {
				if (arr[j] == 0)
					continue;
				int crtProd = arr[i] * arr[j];
				if (product % crtProd == 0)
					if (set.contains(product/crtProd)) {
						System.out.println(arr[i] + ", " + arr[j] + ", " + (product / crtProd));
						count++;
					}
				set.add(arr[j]);
			}
			
		}
		
		return count;
	}
	
	// https://www.geeksforgeeks.org/count-index-pairs-equal-elements-array/
	public static int countPairs(int[] arr) {
		/*
		System.out.println(countPairs(new int[] {1,1,2}));
		System.out.println(countPairs(new int[] {1,1,1}));
		System.out.println(countPairs(new int[] {1,2,3}));
		 */
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i : arr)
			if (map.containsKey(i))
				map.replace(i, map.get(i) + 1);
			else
				map.put(i, 1);
		
		// combinations of N taken by 2: (N-1) * N / 2
		for (Map.Entry<Integer,Integer> entry : map.entrySet())
			count += entry.getValue() * (entry.getValue() - 1) / 2;
		
		return count;
	}
	
	/**
	 * @param pal pal.first == start index; pal.second == max length of palindrome
	 * @return
	 */
	public static int findMaxLenPalindrome(int[] arr, int lo, int hi, Pair pal) {
		/*
		Pair p = new Pair(-1,-1);
		System.out.println(findMaxLenPalindrome(new int[] {1, 2, 3,4,5,6,8}, 0, 6, p) + " " + p);
		p = new Pair(-1,-1);
		System.out.println(findMaxLenPalindrome(new int[] {1, 2, 3,4,3,2,1}, 0, 6, p) + " " + p);
		p = new Pair(-1,-1);
		System.out.println(findMaxLenPalindrome(new int[] {7, 9, 3,4,3,2}, 0, 5, p) + " " + p);
		 */
		if (lo >= hi)
			return 1;
		
		int crt = 0;
		if (arr[lo] == arr[hi]) {
			crt = 2 + findMaxLenPalindrome(arr, lo+1, hi-1, pal);
			if (crt > pal.second) {
				pal.second = crt;
				pal.first = lo;
			}
		} else {
			int aux1 = findMaxLenPalindrome(arr, lo+1, hi, pal);
			int aux2 = findMaxLenPalindrome(arr, lo, hi-1, pal);
			crt = Math.max(aux1, aux2);
		}
		
		return crt;
	}
	////////NOT WORKING PROPERLY
	public static void findSubstringPalindrome(int[] arr, Pair[] queries) {
		Pair pali = new Pair(-1,-1);
		findMaxLenPalindrome(arr, 0, arr.length-1, pali);
		
		int startPali = pali.first;
		int endPali = startPali + pali.second - 1;
		System.out.println(startPali + "   " + endPali);
		for (Pair p : queries) {
			if (p.first - startPali >= 0 && p.first - startPali == p.second - endPali)
				printArr(Arrays.copyOfRange(arr, p.first, p.second+1), "  is palindrome ");
			else
				printArr(Arrays.copyOfRange(arr, p.first, p.second+1), "  is NOT a palindrome ");
		}
	}
	
	// https://www.geeksforgeeks.org/range-queries-for-frequencies-of-array-elements/ 
	public static void rangeFrequencies(int[] arr, Pair3[] queries) {
		/*
		rangeFrequencies(
				new int[] {2, 8, 6, 9, 8, 6, 8, 2, 11}, 
				new Pair3[] {
						new Pair3(2,8,8), new Pair3(2,5,6), 
						new Pair3(1,8,2), new Pair3(2,9,11)});
		 */
		// keep in an arraylist, indexes where each element appears in the list
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			if (!map.containsKey(arr[i]))
				map.put(arr[i], new ArrayList<Integer>());
			map.get(arr[i]).add(i);
		}

		for (Pair3 p : queries) {
			int start = p.first-1;
			int end = p.second-1;
			int wanted = p.third;
			
			// binary search for the closest index to the range: start-end
			ArrayList<Integer> occurrencesList = map.get(wanted);
			int firstOccIndex = Collections.binarySearch(occurrencesList, start);
			int lastOccIndex =  Collections.binarySearch(occurrencesList, end);
			
			// consider cases where at index start/end is not the wanted element 
			if (firstOccIndex < 0)
				firstOccIndex = firstOccIndex * (-1) - 1;
			if (lastOccIndex < 0)
				lastOccIndex = lastOccIndex * (-1) - 2;
			
			// number of occurrences in the given interval
			printArr(Arrays.copyOfRange(arr, start, end+1), "   " + wanted + " appears " + (lastOccIndex - firstOccIndex + 1) + " times");
		}
	}
	
	// https://www.geeksforgeeks.org/elements-to-be-added-so-that-all-elements-of-a-range-are-present-in-array/
	public static int addToCreteConsecutiveAB(int[] arr) {
		/*
		System.out.println(addToCreteConsecutiveAB(new int[] {4, 5, 3, 8, 6}));
		System.out.println(addToCreteConsecutiveAB(new int[] {2, 1, 3}));
		 */
		if (arr.length <= 0)
			return 0;
		
		int min = arr[0];
		int max = arr[0];
		HashSet<Integer> set = new HashSet<Integer>();
		
		for (int i : arr) {
			if (i > max) max = i;
			if (i < min) min = i;
			set.add(i);
		}
		
		return max - min + 1 - set.size();
	}
	
	// https://www.geeksforgeeks.org/subarrays-distinct-elements/
	public static int maxSumSubarraysContigDistinct(int[] arr) {
		/*
		System.out.println(maxSumSubarraysContigDistinct(new int[] {6,1,1,2,3,8,7,8,9,3}));
		System.out.println("--------------");
		System.out.println(maxSumSubarraysContigDistinct(new int[] {1, 2, 3}));
		System.out.println("--------------");
		System.out.println(maxSumSubarraysContigDistinct(new int[] {1, 2, 1}));
		System.out.println("--------------");
		System.out.println(maxSumSubarraysContigDistinct(new int[] {1, 2, 3, 4}));
		 */
		int count = arr.length;
		
		if (arr.length <= 0)
			return 0;
		
		// look for subarrays with contiguous increasing elements
		count += maxSumContigAux(arr, 1);
		// look for subarrays with contiguous increasing elements
		count += maxSumContigAux(arr, -1);
		
		return count;
	}
	public static int maxSumContigAux(int[] arr, int sign) {
		int startIndex = 0, count = 0;

		// find all subarrays: startIndex->i
		for (int i = 1; i < arr.length; i++)
			// end a subarray when the current element is not related to the previous one
			if (arr[i] != arr[i-1] + sign) {
				if (i - startIndex > 1) {
					printArr(Arrays.copyOfRange(arr, startIndex, i));
					count += formSubarrays(i - startIndex);
				}
				startIndex = i;
			} 

		// check for the end of the array
		if (arr.length - startIndex > 1) {
			printArr(Arrays.copyOfRange(arr, startIndex, arr.length));
			count += formSubarrays(arr.length - startIndex);
		}
		
		return count;
	}
	public static int formSubarrays(int noDigits) {
		int count = 0;
		// number of types of subarrays: with 5,4,3,2 elements == 5 - 2 + 1
		int noLayers = noDigits - 2 + 1; 
		for (int j = 1; j <= noLayers; j++, noDigits--)
			// j is the number of subarrays with noDigits elements
			// noDigits is the length of the subArray;
			count += j * noDigits;  
		return count;
	}
	
	// https://www.geeksforgeeks.org/count-subarrays-total-distinct-elements-original-array/
	public static int countSubarraysEqualOriginal(int[] arr) {
		int count = 0;
		HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
		
		for (int i : arr)
			if (occurrences.containsKey(i))
				occurrences.replace(i, 1+occurrences.get(i));
			else
				occurrences.put(i, 1);
		
		int totalDistinct = occurrences.size();
		
		for (int i = 0; i < arr.length; i++) {
			HashMap<Integer, Integer> occurrences1 = (HashMap<Integer, Integer>) occurrences.clone();
			for (int j = arr.length - 1; j >= 0; j--) {
				if (occurrences1.size() == 0 || !occurrences1.containsKey(arr[j]))
					break;
				
				if (occurrences1.size() < totalDistinct)
					break;
				
				if (occurrences1.get(arr[j]) > 1)
					occurrences1.replace(arr[j], occurrences1.get(arr[j]) - 1);
				else
					occurrences1.remove(arr[j]);
				
				printArr(Arrays.copyOfRange(arr, i, j+1));
				count += 1;
			}
			
			if (occurrences.get(arr[i]) > 1)
				occurrences.replace(arr[i], occurrences.get(arr[i]) - 1);
			else
				occurrences.remove(arr[i]);
		}
		
		return count;
	}
	public static int countSubarraysEqualOriginal2(int[] arr) {
		/*
		System.out.println(countSubarraysEqualOriginal2(new int[] {2,1,3,2,3}));
		System.out.println(countSubarraysEqualOriginal2(new int[] {2, 4, 5, 2, 1}));
		System.out.println(countSubarraysEqualOriginal2(new int[] {2, 4, 4, 2, 4}));
		 */
		int count = 0;
		HashSet<Integer> diffElems = new HashSet<Integer>();
		
		for (int i : arr)
			diffElems.add(i);
		
		int left = 0, right = 1;
		HashMap<Integer, Integer> window = new HashMap<Integer, Integer>();
		window.put(arr[left], 1);

		while (left <= right && right < arr.length) {
			while (right < arr.length && window.size() != diffElems.size()) {
				if (window.containsKey(arr[right]))
					window.replace(arr[right], 1+window.get(arr[right]));
				else
					window.put(arr[right], 1);
				
				right++;
			}

			if (window.size() == diffElems.size())
				count += 1 + arr.length - right;

			do  {
				// remove first element from the window;
				if (window.get(arr[left]) > 1)
					window.replace(arr[left], window.get(arr[left]) - 1);
				else
					window.remove(arr[left]);

				left++;

				// if the window contains the same amount of elements, count++
				if (window.size() == diffElems.size())
					count += 1 + arr.length - right;
			} while (left <= right && left < arr.length && window.size() == diffElems.size());
		}

		return count;
	}

	// https://www.geeksforgeeks.org/count-subarrays-with-same-even-and-odd-elements/
	public static int countSubarraysSameEvenOdd(int[] arr) {
		int count = 0;
		int[] par = new int[arr.length+1];
		int[] impar = new int[arr.length+1];
		
		for (int i = 0; i < arr.length; i++) {
			par[i+1] = par[i];
			impar[i+1] = impar[i];
			if (arr[i] % 2 == 0)
				par[i+1] ++; 
			else
				impar[i+1]++;
		}
		
		for (int i = 2; i < par.length; i++)
			for (int j = i-2; j >= 0; j -= 2)
				if (par[i] - par[j] == impar[i] - impar[j])
					count++;
		
		return count;
	}
	public static int countSubarraysSameEvenOdd2(int[] arr) {
		/*
The basic idea is to use the difference between the frequency of odd and even numbers to obtain an optimal solution. We will maintain two integer hash arrays for the positive and negative value of the difference.
-> Example to understand in better way :
-> Consider difference = freq(odd) – freq(even)
-> To calculate this difference, increment the value of ‘difference’ when there is
an odd integer and decrement it when there is an even integer. (initially, difference = 0)
arr[] =       3, 4,  6,  8,  1, 10
difference 0, 1, 0, -1, -2, -1, -2
-> Value ‘0’ is repeated in ‘difference’ array at index 2 and hence subarray exists for
(0, 2] indexes. Similarly, for repetition of values ‘-1’ (at indexes 3 and 5) and ‘-2’ (at
indexes 4 and 6), subarray exists for (3, 5] and (4, 6] indexes.


		System.out.println(countSubarraysSameEvenOdd2(new int[] {1,2,3,4,5,6}));
		System.out.println(countSubarraysSameEvenOdd2(new int[] {1,2,3,5,7,6}));
		System.out.println(countSubarraysSameEvenOdd2(new int[] {2, 5, 7, 8} ));
		System.out.println(countSubarraysSameEvenOdd2(new int[] {3, 4, 6, 8, 1, 10} ));
		 */
		HashMap<Integer, Integer> diff_occurr = new HashMap<Integer, Integer>();
		int count = 0, diff = 0;
		
		diff_occurr.put(diff, 1);
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 2 == 0)
				diff++;
			else
				diff--;
			
			if (diff_occurr.containsKey(diff))
				diff_occurr.replace(diff, diff_occurr.get(diff) + 1);
			else
				diff_occurr.put(diff, + 1);
		}
		
		for (Map.Entry<Integer,Integer> entry : diff_occurr.entrySet())
			count += (entry.getValue() - 1) * entry.getValue() / 2;
		
		
		return count;
	}

	// https://www.geeksforgeeks.org/minimum-number-of-distinct-elements-after-removing-m-items/
	public static int minRemove(int[] arr, int m) {
		/*
		System.out.println(minRemove(new int[] { 2, 2, 1, 3, 3, 3}, 3));
		System.out.println(minRemove(new int[] { 2, 4, 1, 5, 3, 5, 1, 3}, 2));
		System.out.println(minRemove(new int[] {2, 3, 1, 2, 3, 3}, 3));
		 */
		Pair[] elem_occurr;
		int count = 0, i = 0;
		HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();

		// count occurrences for each element
		for (int el : arr)
			if (occurrences.containsKey(el))
				occurrences.replace(el, occurrences.get(el) + 1);
			else
				occurrences.put(el, 1);
		
		// store elements into array for sorting
		elem_occurr = new Pair[occurrences.size()];
		for (Map.Entry<Integer, Integer> entry : occurrences.entrySet())
			elem_occurr[i++] = new Pair(entry.getKey(), entry.getValue());

		// sort occurrences increasingly 
		Arrays.sort(elem_occurr, new Comparator<Pair>() {
			@Override
			public int compare(Pair p1, Pair p2) {
				if (p1.second > p2.second)
					return 1;
				else if (p1.second < p2.second)
					return -1;
				return 0;
			}
		});
	
		// eliminate the elements with fewest occurrences
		for (Pair p : elem_occurr) {
			m -= p.second;
			if (m < 0)
				break;
			count++;
		}
			
		return occurrences.size() - count;
	}
	
	// https://www.geeksforgeeks.org/distributing-items-person-cannot-take-two-items-type/
	public static String distributeCandy(int[] arr, int k) {
		/*
		System.out.println(distributeCandy(new int[] {1, 1, 2, 3, 1}, 2));
		System.out.println(distributeCandy(new int[] {2, 3, 3, 5, 3, 3}, 2));
		 */
		HashMap<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
		for (int i : arr)
			if (occurrences.containsKey(i))
				occurrences.replace(i, occurrences.get(i) + 1);
			else
				occurrences.put(i, 1);
		System.out.println(occurrences);
		for (Map.Entry<Integer, Integer> entry : occurrences.entrySet())
			if (entry.getValue() > k * 2)
				return "NO";
		
		return "YES";
	}
	
	// https://geeksforgeeks.org/maximum-consecutive-numbers-present-array/
	public static int maxConsec(int[] arr) {
		/*
		System.out.println(maxConsec(new int[]  {1, 94, 93, 1000, 5, 92, 78}));
		System.out.println(maxConsec(new int[]  {1, 5, 92, 4, 78, 6, 7}));
		 */
		HashSet<Integer> set = new HashSet<Integer>();
		int max = 0;
		
		for (int i : arr)
			set.add(i);
		
		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			while (set.contains(j+1))
				j++;
			
			if (max < j - arr[i] + 1)
				max = j - arr[i] + 1;
		}
		
		
		return max;
	}
	
	// https://www.geeksforgeeks.org/maximum-array-from-two-given-arrays-keeping-order-same/
	public static int[] maximumFrom2Arrays(int[] arr1, int[] arr2) {
		/*
		printArr(maximumFrom2Arrays(new int[] {9, 7, 2, 3, 6}, new int[] { 7, 4, 8, 0, 1}));
		 */
		int[] result = new int[arr1.length];
		
		// O(log n) - needs sorting
		TreeSet<Integer> set = new TreeSet<Integer>(new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				if (i1 > i2)
					return -1;
				else if (i1 < i2)
					return 1;
				return 0;
			}
		});
		
		// add elements from first array
		constructSortedTreeSet(arr1, set);
		
		// add elements from second array
		constructSortedTreeSet(arr2, set);

		// traverse first array again to find final elements
		int index = constructArrayResponse(arr1, result, set, 0);
		// traverse second array again to find final elements
		constructArrayResponse(arr2, result, set, index);
		
		return result;
	}
	// add arr.length elements into a sorted Set (TreeSet)
	public static void constructSortedTreeSet(int[] arr, TreeSet<Integer> set) {
		for (int i : arr) {
			set.add(i);
			if (set.size() > arr.length)
				set.remove(set.last());
		}
	}
	// populate result with elements from given array that are also in the set
	public static int constructArrayResponse(int[] arr, int[] result, TreeSet<Integer> set, int start) {
		for (int i : arr) {
			if (start >= arr.length)
				return start;
			if (set.contains(i)) {
				set.remove(i);
				result[start++] = i;
			}
		}
		return start;
	}
	
	// https://www.geeksforgeeks.org/maximum-number-chocolates-distributed-equally-among-k-students/
	public static int distributeChocolates(int[] arr, int noChildren) {
		/*
		System.out.println(distributeChocolates(new int[] {2, 7, 6, 1, 4, 5}, 3));
		 */
		int total = 0;
		int sum = 0;
		
		for (int i : arr)
			sum += i;
		
		// subarray with max sum divisible by noChildren
		for (int i = 0; i < arr.length; i++) {
			int crtSum = sum;
			for (int j = arr.length - 1; j >= i; j--) {
				if (crtSum % noChildren == 0)
					if (total < crtSum / noChildren)
						total = crtSum / noChildren;
				crtSum -= arr[j];
			}
			sum -= arr[i];
		}
		
		return total;
	}
	public static int distributeChocolates2(int[] arr, int noChildren) {
		/*
		System.out.println(distributeChocolates2(new int[] {2, 7, 6, 1, 4, 5}, 3));
		 */
		HashMap<Integer, Integer> sumsMod = new HashMap<Integer, Integer>();
		int[] sums = new int[arr.length];
		sums[0] = arr[0];
		
		// sums[i] = arr[0] + ... arr[i-1] + arr[i]
		for (int i = 1; i < arr.length; i++)
			sums[i] = sums[i-1] + arr[i];
		
		int max = 0;
		for (int i = 0; i < sums.length; i++) {
			// remainder from sums[i] % noChildren
			int crtSum = sums[i] % noChildren;
			
			// if remainder is 0 -> sum is divisible with noChildren
			if (crtSum == 0) {
				if (max < sums[i])
					max = sums[i];
			// if no previous remainder was found, add it to the map
			} else if (!sumsMod.containsKey(crtSum))
				sumsMod.put(crtSum, i);
			// if this remainder was found before, compute the sum between them
			else if (max < sums[i] - sums[sumsMod.get(crtSum)])
					max = sums[i] - sums[sumsMod.get(crtSum)];
		}
		
		// return how many chocolates each child received
		return max / noChildren;
	}
	
	// https://www.geeksforgeeks.org/find-largest-d-in-array-such-that-a-b-c-d/
	public static int findMax3ElemSum(int[] arr) {
		/*
		System.out.println(findMax3ElemSum(new int[] {2, 3, 5, 7, 12}));
		*/
		HashMap<Integer, Pair> map = new HashMap<>();
		int max = 0;
		
		// problem: a+b+c = d   ===   a+b = d-c
		
		// store in a map: a+b  ===   arr[i] + arr[j]
		for (int i = 0; i < arr.length - 1; i++)
			for (int j = i+1; j < arr.length; j++)
				map.put(arr[i] + arr[j], new Pair(arr[i], arr[j]));
		
		// search in the map for: d-c   ===    arr[i] - arr[j]
		for (int i = arr.length - 1; i >= 1; i--)
			for (int j = 0; j < i; j++)
				if (map.containsKey(arr[i] - arr[j])) {
					Pair p = map.get(arr[i] - arr[j]);
					// check for different elements: a!=b!=c!=d
					if (p.first != arr[i] && p.first != arr[j] &&  
						p.second != arr[i] && p.second != arr[j])
						// update max
						if (max < arr[i])
							max = arr[i];
				}

		return max;
	}
	public static int findMax3ElemSumConseq(int[] arr) {
		int max = 0;
		
		Arrays.sort(arr);
		
		for (int i = arr.length - 1; i >= 3; i--) {
			int startWindow = 0;
			int countWindow = arr[0] + arr[1] + arr[2];
			int d = arr[i];
			
			if (d % countWindow == 0)
				return d;
			
			while (countWindow + 2 < i) {
				countWindow -= arr[startWindow];
				startWindow++;
				countWindow += arr[startWindow + 2];
				
				if (d % countWindow == 0)
					return d;
			}
		}
		
		return max;
	}
	
	
	public static void main(String[] args) {

	}
	
	// https://www.geeksforgeeks.org/find-sum-unique-sub-array-sum-given-array/
	public static int sumUniqueSubarraySum(int[] arr) {
		/*
		System.out.println(sumUniqueSubarraySum(new int[] {1, 2, 3, 4, 5, -5}));
		System.out.println(sumUniqueSubarraySum(new int[] {3, 4, 5}));
		System.out.println(sumUniqueSubarraySum(new int[] {2, 4, 2}));
		System.out.println(sumUniqueSubarraySum(new int[] { 3, 2, 3, 1, 4 }));
		 */
		int total = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for (int i = 1; i < arr.length; i++)
			arr[i] += arr[i-1];
	
		for (int i = 0; i < arr.length; i++) {
			list.add(arr[i]);
			for (int j = i+1; j < arr.length; j++)
				list.add(arr[j] - arr[i]);
		}
		
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++)
			if (i+1 < list.size() && list.get(i) == list.get(i+1))
				while (list.get(i) == list.get(i+1))
					i++;
			else
				total += list.get(i);
		
		return total;
	}

	// print all permutations of an array of digits
	public static void printPermutations(ArrayList<Integer> digits, StringBuilder sb) {
		/*
		printPermutations(new ArrayList<Integer>(Arrays.asList(new Integer[] {1,2,3,4})), new StringBuilder());

		Ex: for 1,2,3,4, all permutations are:
		// 1234  1243  1324  1342  1423  1432
		// 2134  2143  2314  2341  2413  2431  
		// 3124  3142  3214  3241  3412  3421
		// 4123  4132  4213  4231  4312  4321  
		 */
		if (digits.size() == 0) {
			System.out.println(sb.toString());
			return;
		}
		
		for (int i = 0; i < digits.size(); i++) {
			int crt = digits.get(i);
			sb.append(crt);
			digits.remove(i);
			printPermutations(digits, sb);
			digits.add(i, crt);
			sb.delete(sb.length() - 1, sb.length());
		}
	}

	// https://introcs.cs.princeton.edu/java/42sort/
	// ex. 29 find 3 elements that sum up to 0
	public static void find3sum0(int[] arr) {
		/*
		find3sum0(new int[] {1,2,3,4,5,-3});
		 */

		HashMap<Integer, Pair> map = new HashMap<Integer, Pair>();
		
		for (int i = 0; i < arr.length-1; i++)
			for (int j = i+1; j < arr.length; j++)
				map.put(arr[i]+arr[j], new Pair(i,j));
		
		for (int i = 0; i < arr.length; i++)
			if (map.containsKey(-arr[i]))
				System.out.println(arr[i] + "  " + arr[map.get(-arr[i]).first] + "  " + arr[map.get(-arr[i]).second]);
	}

	// ex 31
	public static void printDomainsSorted(String[] domains) {
		/*
		printDomainsSorted(new String[] {"com.apple", "com.cnn", "com.google", "edu.princeton", "edu.princeton.cs", 
			"edu.princeton.cs.bolle", "edu.princeton.cs.www", "com.apple", "edu.princeton.ee"});
		 */
		TreeMap<String, Integer> map = new TreeMap<>();
		for (String domain : domains) {
			String[] split = domain.split("\\.");
			StringBuffer sb = new StringBuffer();
			
			for (int i = split.length - 1; i > 0; i--)
				sb.append(split[i] + ".");
			sb.append(split[0]);
			
			String newDomain = sb.toString();
			if (map.containsKey(newDomain))
				map.replace(newDomain, map.get(newDomain) + 1);
			else
				map.put(newDomain, 1);
		}
		
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			int count = entry.getValue();
			String domain = entry.getKey();
			for (int i = 0; i < count; i++)
				System.out.println(domain);
		}
	}
	
	// binary search; 
	// if elements is missing, return index where it should have appeared
	public static int binarySearch2(int[] arr, int searched) {
		/*
		System.out.println(binarySearch2(new int[] {1,3,4,6,8,9},2));
		System.out.println(binarySearch2(new int[] {1, 2,3,4,6,8,9},2));
		System.out.println(binarySearch2(new int[] {1, 2,3,4,6,8,9},5));
		System.out.println(binarySearch2(new int[] {1, 2,3,4,6,8,9},7));
		 */
		int lo = 0, hi = arr.length, mid = lo+(hi-lo) / 2;
		
		while (lo < hi) {
			mid = lo+(hi-lo) / 2;
			if (arr[mid] == searched)
				return mid;
			else if (searched < arr[mid]) 
				hi = mid;
			else
				lo = mid + 1;
		}
		return -lo;
	}

}
  










 