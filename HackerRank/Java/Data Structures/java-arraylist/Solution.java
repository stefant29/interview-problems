import java.util.*;

// https://www.hackerrank.com/challenges/java-arraylist
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < n; i++) {
        	list.add(new ArrayList<Integer>());
            int d = in.nextInt();
            for (int j = 0; j < d; j++)
                list.get(i).add(in.nextInt());
        }
        
        int q = in.nextInt();
        for (int i = 0; i < q; i++) {
        	int x = in.nextInt()-1;
        	int y = in.nextInt()-1;
        	if (x >= list.size()) {
        		System.out.println("ERROR!");
        		continue;
        	} else if (y >= list.get(x).size()) {
        		System.out.println("ERROR!");
        		continue;
        	} else
        		System.out.println(list.get(x).get(y));
        }
        in.close();
    }
}
