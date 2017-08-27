import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-stdin-stdout
public class Solution {

    public static void main(String[] args) {
        /* read input */
        Scanner scan = new Scanner(System.in);
        int i = Integer.parseInt(scan.nextLine());
        double d = Double.parseDouble(scan.nextLine());
        String s = scan.nextLine();
       
        /* write output to stdout */
        System.out.println("String: " + s);
        System.out.println("Double: " + d);
        System.out.println("Int: " + i);
        
        /* close scanner */
        scan.close();
    }
}
