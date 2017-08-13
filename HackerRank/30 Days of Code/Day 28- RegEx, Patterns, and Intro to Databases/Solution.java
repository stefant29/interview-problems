import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

// https://www.hackerrank.com/challenges/30-regex-patterns
public class Solution {

    public static void main(String[] args) {
        /* use scanner to read from STDIN */
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        /* use an arrayList to store the names */
        ArrayList<String> database = new ArrayList<String>();
        for(int a0 = 0; a0 < N; a0++){
            String firstName = in.next();
            String emailID = in.next();
            /* add the name into an array only if the email is from Google */
            String[] splitEmail = emailID.split("@");
            if (splitEmail[1].equals("gmail.com"))
                database.add(firstName);
        }
        /* sort the database using Collections.sort */
        Collections.sort(database);
        /* print the database */
        for (int i = 0; i < database.size(); i++)
            System.out.println(database.get(i));
    }
}