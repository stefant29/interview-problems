import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/reduced-string
public class Solution {

    // Solve problem: remove only multiple of two number of similar adjacent letters
    static String super_reduced_string(String s){
    	int[] aux = new int[s.length()];
    	int count = 0;
    	boolean ok = false;
    	
    	for (int i = 0; i < s.length(); i++)
    		aux[i] = s.charAt(i);
    	
    	while (!ok) {
    		ok = true;
	    	for (int i = 0; i < aux.length - 1; i++) {
	    		if (aux[i] == -1)
	    			continue;
	    		int k = i+1;
	    		while (k < aux.length - 1 && aux[k] == -1)
	    			k++;
	    		if (aux[i] == aux[k]) {
	    			aux[i] = -1;
	    			aux[k] = -1;
	    			ok = false;
	    			count+=2;
	    			i++;
	    		}
	    	}
    	}
    	if (count == aux.length)
    		return "Empty String";
    	else if (count == 0)
    		return s;
    	else {
    		StringBuilder sb = new StringBuilder(aux.length - count);
    		for(int i = 0; i < aux.length; i++)
    			if (aux[i] != -1)
    				sb.append(Character.toString((char) aux[i]));
    		return sb.toString();
    	}
    }


    // remove more than a multiple of two number of similar adjacent letters
    static String super_reduced_string2(String s){
        int[] aux = new int[s.length()];
        int count = 0;
        boolean ok = false;
        
        for (int i = 0; i < s.length(); i++)
            aux[i] = s.charAt(i);
        
        while (!ok) {
            ok = true;
            for (int i = 0; i < aux.length - 1; i++) {
                int k = i + 1;
                boolean found_neighbour = false;
                while (k < aux.length && aux[k] == -1)
                    k++;
                while(k < aux.length && aux[i] == aux[k]) {
                    aux[k] = -1;
                    ok = false;
                    found_neighbour = true;
                    count++;
                    k++;
                }
                if (found_neighbour) {
                    aux[i] = -1;
                    count++;
                }
            }
        }
        if (count == aux.length)
            return "Empty String";
        else if (count == 0)
            return s;
        else {
            StringBuilder sb = new StringBuilder(aux.length - count);
            for(int i = 0; i < aux.length; i++)
                if (aux[i] != -1)
                    sb.append(Character.toString((char) aux[i]));
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = super_reduced_string(s);
        System.out.println(result);
    }
}