import java.util.*;

// https://www.hackerrank.com/challenges/java-string-compare
public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        /*
         * get the smallest substring and the biggest substring 
         *   using two additional methods
         */
        return auxSmall(s, k, s.substring(0, k)) + "\n" + auxBig(s, k, s.substring(0, k));
    }
    
    public static String auxSmall(String s, int k, String crtMin) {
        /* find the smallest substring of length k */
    	for (int i = 0; i < s.length()-k+1; i++)
    		if (s.substring(i, i+k).compareTo(crtMin) < 0)
                /* if there is a substring smaller than the current one, update it */
    			crtMin = s.substring(i, i+k);
    	return crtMin;
    }
    
    public static String auxBig(String s, int k, String crtMax) {
        /* find the biggest substring of length k */
    	for (int i = 0; i < s.length()-k+1; i++)
    		if (s.substring(i, i+k).compareTo(crtMax) > 0)
                /* if there is a substring bigger than the current one, update it */
    			crtMax = s.substring(i, i+k);
    	return crtMax;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        scan.close();
      
        System.out.println(getSmallestAndLargest(s, k));
    }
}