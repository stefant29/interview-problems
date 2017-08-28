import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/java-datatypes
class Solution{
    public static void main(String []argh) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        /* for each test case */
        for(int i=0;i<t;i++) {
            try {
                /* read the number */
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");
                /* check limits for each primitive type */
                if(x>=-128 && x<=127) {
                    System.out.println("* byte");
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                } else if(x>=-32768 && x<=32767) {
                    System.out.println("* short");
                    System.out.println("* int");
                    System.out.println("* long");
                } else if(x>=-Math.pow(2,31) && x<=Math.pow(2,31)-1) {
                    System.out.println("* int");
                    System.out.println("* long");
                } else if(x>=-Math.pow(2,63) && x<=Math.pow(2,63)-1) {
                    System.out.println("* long");
                } else
                    throw new Exception();
            }
            catch(Exception e) {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }
        }
        
        /* close scanner */
        sc.close();
    }
}
