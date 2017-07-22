import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/manasa-and-stones/problem
public class Solution {

    public static HashSet<Integer> found_values = new HashSet<Integer>();
    /*
    public static void find_end_number(int stones_number, int a, int b, int current_sum) {
        if (stones_number == 0) {
            found_values.add(current_sum);
            return;
        }
        find_end_number(stones_number - 1, a, b, current_sum + a);
        find_end_number(stones_number - 1, a, b, current_sum + b);
    }
    */
    
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int test_cases = in.nextInt();
        int stones_number, a, b;
        for (int i_test = 0; i_test < test_cases; i_test++) {
            stones_number = in.nextInt();
            a = in.nextInt();
            b = in.nextInt();

            /*
            find_end_number(stones_number - 1, a, b, 0);
            
            List sortedList = new ArrayList(found_values);
            Collections.sort(sortedList);
            
            for (int i = 0; i < sortedList.size(); i++)
                System.out.print(sortedList.get(i) + " ");
            System.out.println();
            found_values.clear();
            */
        }
        
    }
}