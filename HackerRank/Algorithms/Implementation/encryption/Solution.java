import java.util.*;

//https://www.hackerrank.com/challenges/encryption
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        // find the max and min values for the number of columns and rows
        int min = (int) Math.floor(Math.sqrt(s.length()));
        int max = (int) Math.ceil(Math.sqrt(s.length()));
        int rows = min;
        int cols = min;
        // find the minimum number for rows and cols that satisfies 
        //    the condition rows*cols<Length
        while (rows * cols < s.length()) {
        	if (cols + 1 <= max)
        		cols++;
        	if (rows * cols < s.length() && rows + 1 <= cols)
        		rows++;
        }
        
        // print the message encoded: no aditional structure needed
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (j * cols + i >= s.length()) {
                	continue;
                }
                System.out.print(s.charAt(j * cols + i));
            }
            System.out.print(" ");
        }

        // close scanner
        in.close();
    }
}
