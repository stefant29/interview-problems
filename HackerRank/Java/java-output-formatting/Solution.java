import java.util.Scanner;

// https://www.hackerrank.com/challenges/java-output-formatting
public class Solution {

    public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);
            System.out.println("================================");
            for(int i=0;i<3;i++)
            {
                String s1=sc.next();
                int x=sc.nextInt();
                
                /* write the string */
                System.out.print(s1);
                /* use space padding between the string and the number */
                for (int k = 0; k < 15 - s1.length(); k++)
                    System.out.print(" ");
                
                /* write the number */
                /* if number has one digit, pad the it with two zeros */
                if (x < 9)
                    System.out.print("00" + x);
                /* if number has two digits, pad the it with one zero */
                else if (x < 99)
                    System.out.print("0" + x);
                /* else, number has three digits, print just the number */
                else
                    System.out.print(x);
                
                System.out.println();
            }
            System.out.println("================================");

    }
}
