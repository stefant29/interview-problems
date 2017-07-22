import java.util.*;

// https://www.hackerrank.com/challenges/gem-stones
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] arr = new String[n];
        
        // find the shortest string to add its letters into a hashSet
        int smallest_index = Integer.MAX_VALUE;
        int smallest_size  = Integer.MAX_VALUE;
        for(int arr_i = 0; arr_i < n; arr_i++){
            // read the next string
            arr[arr_i] = in.next();
            // store the shortest string size and index
            if (arr[arr_i].length() < smallest_size) {
                smallest_size = arr[arr_i].length();
                smallest_index = arr_i;
            }
        }
       
        // insert shortest string's letters into a hashSet to compare them 
        //    with other strings' letters
        HashSet<Character> letters = new HashSet<Character>();
        for (int i = 0; i < smallest_size; i++)
            letters.add(arr[smallest_index].charAt(i));
        // System.out.println(letters);
        
        // for each string
        for (int i = 0; i < n; i++) {
            // except the shortest one
            if (i == smallest_index)
                continue;
            // iterate through the hashSet's letters
            for (Iterator<Character> iterator = letters.iterator(); iterator.hasNext(); ) {
                Character c = iterator.next();
                Boolean found_letter = false;
                // check if the current letter from hashSet 
                //   is part of the current string
                for (int j = 0; j < arr[i].length(); j++) {
                    if (c == arr[i].charAt(j)) {
                        found_letter = true;
                        break;
                    }
                }
                // if the letter does not appear in the current string
                //    remove it from the hashSet
                if (!found_letter) {
                    iterator.remove();
                    // System.out.println(letters + "     removed: " + c);
                }
            }
        }
        // the hashSet contains now only common letters to all strings (rocks);
        //    the hashSet's size represents how many letters there are in common
        System.out.println(letters.size());
        in.close();
    }
}
