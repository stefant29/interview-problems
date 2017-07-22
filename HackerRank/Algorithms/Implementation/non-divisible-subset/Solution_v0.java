import java.util.*;

public class Solution {
	
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] S = new int[n];
        for (int i_n = 0; i_n < n; i_n++)
            S[i_n] = in.nextInt();
        ArrayList<HashSet<Integer>> list_set = new ArrayList<HashSet<Integer>>();
        
        for (int i = 0; i < n; i++) {
        	//System.out.println("--------------"+S[i]+"-----------");
        	int index = -1;
        	if(list_set.size() == 0) {
        		list_set.add(new HashSet<Integer>());
        		list_set.get(list_set.size() - 1).add(S[i]);
        		index = list_set.size() - 1;
        		//System.out.println("initial: " + index);
        	} else {
        		for (int j = 0; j < list_set.size(); j++) {
        			if (list_set.get(j).contains(S[i])) {
        				index = -2;
        			}
        		}
        	}
        	if (index == -2)
    			continue;
        	if (index == -1) {
        		//System.out.println("Number " + S[i] + " not found, creating new Set");
        		list_set.add(new HashSet<Integer>());
        		list_set.get(list_set.size() - 1).add(S[i]);
        		index = list_set.size() - 1;
        	}

            for (int other : S) {
            	if (other == S[i])
            		continue;
            	Boolean isGood = true;
            	for (Iterator<Integer> iterator = list_set.get(index).iterator(); iterator.hasNext();) {
            		int next = iterator.next();
            		//System.out.println("    check with: " + next);
                	if ((next + other) % k == 0) {
                		isGood = false;
                		break;
                	}
            	}
            	if (isGood) {
            		list_set.get(index).add(other);
            		//System.out.println("added: " + other + "    set: " + list_set.get(index));
            	}
            }
            //System.out.println(list_set);
            //System.out.println();
        }
        int max = Integer.MIN_VALUE;
        for (HashSet<Integer> set : list_set) {
        	if (max < set.size())
        		max = set.size();
        }
        System.out.println(max);
        in.close();
    }
}
    