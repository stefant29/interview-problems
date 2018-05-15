import java.util.*;
import java.math.*;

// https://www.hackerrank.com/challenges/java-primality-test
public class Solution {

   public static void main(String[] args) {
      Scanner in = new Scanner(System.in);
      BigInteger n = in.nextBigInteger();
      BigInteger two = new BigInteger("2");
      in.close();
      if (n.subtract(two)==BigInteger.ZERO)
          System.out.println("prime");
      else if (n.mod(two)==BigInteger.ZERO || n==BigInteger.ONE)
    	  System.out.println("not prime");
      else
    	  System.out.println(n.isProbablePrime(1) ? "prime" : "not prime");
   }
}
