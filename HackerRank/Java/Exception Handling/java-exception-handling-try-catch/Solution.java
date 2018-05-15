import java.util.*;

// https://www.hackerrank.com/challenges/java-exception-handling-try-catch
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String x = in.nextLine();
        String y = in.nextLine();
        try {
            int xx = Integer.parseInt(x);
            int yy = Integer.parseInt(y);
            System.out.println(xx/yy);
        } catch (java.lang.NumberFormatException e) {
            System.out.println("java.util.InputMismatchException");
        } catch (java.lang.ArithmeticException e) {
        	System.out.println("java.lang.ArithmeticException: / by zero");
        }
        in.close();
    }
}