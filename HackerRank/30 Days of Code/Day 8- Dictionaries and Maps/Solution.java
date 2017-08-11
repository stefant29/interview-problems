import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/30-dictionaries-and-maps
class Solution{
    public static void main(String []argc){
        /* read input from stdin */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        /* use a HashMap to store the phones and the names */
        HashMap<String, Integer> phoneBook = new HashMap<String, Integer>();
        /* read names and phones */
        for(int i = 0; i < n; i++) {
            String name = in.next();
            int phone = in.nextInt();
            /* add them to HashMap */
            phoneBook.put(name, phone);
        }
        /* read queries and search names in the phonebook */
        while(in.hasNext()){
            String name = in.next();
            Integer phone = phoneBook.get(name);
            /* if the name isn't in the phonebook, print "Not found" */
            if (phone == null)
                System.out.println("Not found");
            else
                System.out.println(name + "=" + phone);
        }
        in.close();
    }
}

