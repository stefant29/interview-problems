import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

//https://www.hackerrank.com/challenges/migratory-birds
public class Solution {
	
	public static Solution sol = new Solution();

    class Bird {
        int ID;
        int count;
        public Bird(int ID) {
            this.ID = ID;
            this.count = 0;
        }
		@Override
		public String toString() {
			return "Bird [ID=" + ID + ", count=" + count + "]";
		}
        
    }
    
    static int migratoryBirds(int n, int[] ar) {
        Bird[] birds = new Bird[5];
        for (int i = 0; i < birds.length; i++)
            birds[i] = sol.new Bird(i);
        for (int i = 0; i < ar.length; i++) {
            birds[ar[i]-1].count++;
        }        
        Arrays.sort(birds, new Comparator<Bird>() {
			@Override
			public int compare(Bird o1, Bird o2) {
				if (o1.count > o2.count)
					return -1;
				else if (o1.count < o2.count)
					return 1;
				else if (o1.ID < o2.ID)
					return -1;
				else if (o1.ID > o2.ID)
					return 1;
				else 
					return 0;
			}
        });
		return birds[0].ID+1;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] ar = new int[n];
        for(int ar_i = 0; ar_i < n; ar_i++){
            ar[ar_i] = in.nextInt();
        }
        int result = migratoryBirds(n, ar);
        System.out.println(result);
        in.close();
    }
}
