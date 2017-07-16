import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/string-construction
public class Solution {

    static int stringConstruction(String s){
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
        	//System.out.println("----------- " + i + " -----------");
            int len = 0;
            int index_i = i;
            int max_i = 0;
            for (int j = 0; j < sb.length(); j++) {
            	//System.out.println("sb: " + j + "  starting with " + sb.charAt(j));
                int len_j = 0;
                index_i = i;
                while (index_i < s.length() && j < sb.length() &&
                		s.charAt(index_i) == sb.charAt(j)) {
                    len_j++;
                    index_i++;
                    j++;
                }
                if (index_i != i)
                	j--;
                if (len_j > len)
                    len = len_j;
            	//System.out.println("sb: " + j + "  end with " + sb.charAt(j));
            }
            if (len == 0) {
            	//System.out.println("**" + s.charAt(i));
            	sb.append(s.charAt(i));
            	count++;
            }
            for (int j = 0; j < len; j++) {
                sb.append(s.charAt(i + j));
               // System.out.print(s.charAt(i + j));
            }
            //System.out.println();
            //System.out.println(sb);
            i += len;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            String s = in.next();
            int result = stringConstruction(s);
            System.out.println(result);
        }
    }
}
