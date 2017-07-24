import java.util.*;

// https://www.hackerrank.com/challenges/sparse-arrays
public class Solution {
    public static Boolean containsString(String s, String substring) {
        for (int j = 0, k = 0; j < s.length() && k < substring.length(); j++) {
            int len = 0;
        	while (k < substring.length() && j < s.length() && s.charAt(j) == substring.charAt(k)) {
                len++;
                k++;
                j++;
            }
            if (len == substring.length())
            	return true;
        }
        return false;
    }
    
    public static int countOcurences(String[] strings, String query) {
        int count = 0;
        for(String s : strings)
            //if (containsString(s, query))	   // implementation for substrings
        	if (s.equals(query))
                count++;
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++)
            strings[i] = in.next();
        
        int Q = in.nextInt();
        String[] queries = new String[Q];
        for (int i = 0; i < Q; i++)
            queries[i] = in.next();
            
        for (String q : queries) {
            // count the number of occurences of each query in the list of strings
            int result = countOcurences(strings, q);
            System.out.println(result);
        }
        
        in.close();
    }
}
