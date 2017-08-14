import java.util.*;
import java.math.*;

// https://www.hackerrank.com/challenges/leonardo-and-prime
public class Solution {

    public static void main(String[] args) {
    	/* read input from STDIN using scanner */
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.next());
        for (int i = 0; i < testCases; i++) {
        	/* read n */
            BigInteger n = new BigInteger(in.next());
            /* create two auxiliary variables for the multiply result and the prime number */
            BigInteger resultMultiply = new BigInteger("1");
            BigInteger prime = new BigInteger("0");
            /* count the number of prime numbers that multiply below n */
            int countPrimes = 0;
            while (resultMultiply.compareTo(n) < 0) {
                /* take the first prime number */
                prime = getNextPrime(prime, n);
                if (prime == null)
                	break;
                /* compute the result */
                BigInteger result = resultMultiply.multiply(prime);
                /* if the result is bigger than n, break */
                if (result.compareTo(n) > 0) 
                	break;
                /* otherwise, update the multiply variable and the counter */
                resultMultiply = result;
                countPrimes++;
            }
            System.out.println(countPrimes);
        }
        /* close scanner */
        in.close();
    }
	
    /* find the next prime number starting from a given number */
	private static BigInteger getNextPrime(BigInteger prime, BigInteger max) {
		prime = prime.add(BigInteger.ONE);
        /* increment the number until it is prime */
		while (prime.compareTo(max) <= 0) {
            /* then return the prime number */
			if (isPrime(prime)) 
				return prime;
			/* increment */
			prime = prime.add(BigInteger.ONE);
		}
        /* if there is no prime number smaller than a maximum value, return null */
		return null;
	}

    /* check if a given number is prime */
	public static boolean isPrime(BigInteger big) {
        /* base cases: 0, 1, 2, and multiples of 2 */
		if (big.equals(BigInteger.ZERO) || big.equals(BigInteger.ONE))
			return false;
		if (big.equals(BigInteger.valueOf(2)))
			return true;
		else if (big.mod(BigInteger.valueOf(2)).equals(BigInteger.ZERO))
			return false;
		
        /* check each number in range 1-n/2 if it is a factor of n*/
		BigInteger half = big.divide(BigInteger.valueOf(2)).add(BigInteger.ONE);
        /* for efficiency, start from 3 and check only odd numbers; even numbers are not prime! */
		for (BigInteger i = BigInteger.valueOf(3); i.compareTo(half) == -1; i = i.add(BigInteger.valueOf(2)))
            /* if i is a factor of n, then return false */
			if (big.mod(i).equals(BigInteger.ZERO))
				return false;
        /* no factors found, then number is prime, return true */
		return true;
	}
    
    /* methods that work with integers*/
    private static BigInteger getNextPrime2(BigInteger prime, BigInteger n) {
		int aux = prime.intValue() + 1;
		int max = n.intValue();
		while (aux <= max) {
			System.out.println("aux: " + aux);
			if (isPrime2(aux)) {
				System.out.println("is prime: " + aux);
				return BigInteger.valueOf(aux);
			}
			aux++;
		}
		return null;
	}

	private static boolean isPrime2(int aux) {
		if (aux == 0 || aux == 1)
			return false;
		if (aux == 2)
			return true;
		else if (aux % 2 == 0)
			return false;
		int max = aux / 2 + 1;
		for (int i = 3; i < max; i+=2)
			if (aux % i == 0)
				return false;
		return true;
	}
}