import java.util.*;
import java.security.*;

// https://www.hackerrank.com/challenges/java-int-to-string
public class Solution {
  public static void main(String[] args) {
   DoNotTerminate.forbidExit();

   try {
    Scanner in = new Scanner(System.in);
    int n = in .nextInt();
    in.close();
    int copyN = n;

    StringBuilder sb = new StringBuilder();
    if (n < 0) {
        sb.append("-");
        n *= -1;
    }
    
    Stack<Integer> stack = new Stack<Integer>();
    while (n > 0) {
        stack.push(n%10);
        n /= 10;
    }
    while (!stack.isEmpty())
        sb.append(stack.pop());


    if (copyN == 0)
        sb.append('0');
    String s = sb.toString();

    n = copyN;

   if (n == Integer.parseInt(s)) {
    System.out.println("Good job");
   } else {
    System.out.println("Wrong answer.");
   }
  } catch (DoNotTerminate.ExitTrappedException e) {
   System.out.println("Unsuccessful Termination!!");
  }
 }
}

//The following class will prevent you from terminating the code using exit(0)!
class DoNotTerminate {

 public static class ExitTrappedException extends SecurityException {

  private static final long serialVersionUID = 1;
 }

 public static void forbidExit() {
  final SecurityManager securityManager = new SecurityManager() {
   @Override
   public void checkPermission(Permission permission) {
    if (permission.getName().contains("exitVM")) {
     throw new ExitTrappedException();
    }
   }
  };
  System.setSecurityManager(securityManager);
 }
}
