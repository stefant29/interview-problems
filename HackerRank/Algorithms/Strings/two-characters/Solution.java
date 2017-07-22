import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/two-characters
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        String s = in.next();
        
        HashSet<Character> letters = new HashSet<Character>();
        for (int i = 0; i < s.length(); i++)
            if (!letters.contains(s.charAt(i)))
                letters.add(s.charAt(i));
        
        
        ArrayList<Character> let = new ArrayList<Character>(letters);
        int max = -1;
        for (int i = 0; i < let.size()-1; i++) {
        	for (int j = 0; j < let.size(); j++) {
        		if (i == j)
        			continue;
        		int index = get_next('0', s, 0, let.get(i), let.get(j)) + 1;
        		int count = 0;
                Boolean not_good = false;
        		while (index < s.length()) {
        			index = get_next(s.charAt(index-1), s, index, let.get(i), let.get(j));
        			if (index == -1)
        				break;
                    else if (index == -2) {
                        not_good = true;
                        break;
                    }
        			index++;
        			count++;
        		}
        		if (count > max && not_good == false)
        			max = count;
        	}
        }
        System.out.println(max+1);
    }
    
    public static int get_next(char current, String s, int index, char c1, char c2) {
        for (; index < s.length(); index++) {
            if (s.charAt(index) == c1) {
            	if (c1 == current)
            		return -2;
            	else 
            		return index;
            }
            if (s.charAt(index) == c2) {
            	if (c2 == current)
            		return -2;
            	else 
            		return index;
            }
                
        }
        return -1;
    }
}
