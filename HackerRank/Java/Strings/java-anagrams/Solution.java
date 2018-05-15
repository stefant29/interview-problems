import java.util.*;

// https://www.hackerrank.com/challenges/java-anagrams
public class Solution {
    static boolean isAnagram(String a, String b) {
        HashMap<Character, Integer> chars = new HashMap<Character, Integer>();
        int len = a.length();
        
        if (a == null || b == null || a.length() != b.length())
            return false;
        
        for(int i = 0; i < len; i++) {
            char c = Character.toLowerCase(a.charAt(i));
            chars.put(c, chars.containsKey(c) ? chars.get(c) + 1 : 1);
        }
        
        for(int i = 0; i < len; i++) {
            char c = Character.toLowerCase(b.charAt(i));
            chars.put(c, chars.containsKey(c) ? chars.get(c) - 1 : 1);
        }
        
        Iterator it = chars.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            if ((int)pair.getValue() != 0)
                return false;
        }
        
        
        return true;
    }
    
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}