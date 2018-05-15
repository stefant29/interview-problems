import java.util.*;

// https://www.hackerrank.com/challenges/java-string-tokens
public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (scan.hasNext())
        	sb.append(scan.nextLine());
        String s = sb.toString();
        s = s.trim();

        if(s.length() == 0){
            System.out.println("0");
            return;
        }

        String[] split = s.split("[ !,?._'@\\n]+");
        System.out.println(split.length);
        for (String s1 : split) {
            System.out.println(s1);
        }
        scan.close();
    }
}
