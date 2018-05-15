import java.util.*;

// https://www.hackerrank.com/challenges/java-list
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < N; i++)
            list.add(in.nextInt());

        int Q = in.nextInt();
        for (int i = 0; i < Q; i++) {
            String s = in.next();
            if (s.equals("Insert")) {
                int x = in.nextInt();
                int y = in.nextInt();
                list.add(x, y);
            } else if (s.equals("Delete")){
                int x = in.nextInt();
                list.remove(x);
            }
        }

        for (int i = 0; i < list.size()-1; i++)
            System.out.print(list.get(i) + " ");
        System.out.print(list.get(list.size() - 1));
        in.close();
    }
}
