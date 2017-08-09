import java.util.*;

// https://www.hackerrank.com/challenges/balanced-forest
public class Solution {
    static class Node {
        int cost;
        int name;
        ArrayList<Node> neighbours;

        public Node(int name, int cost) {
        		this.name = name;
            this.cost = cost;
            neighbours = new ArrayList<Node>();
        }
        
        public void addNeighbour(Node n) {
            neighbours.add(n);
        }
        
        public String toString() {
        		StringBuilder sb = new StringBuilder();
        		sb.append("[" + name + ": cost= " + cost + "] + neighbours: ");
        		for (Node n : neighbours) {
        			sb.append(n.name + " ");
        		}
        		return sb.toString();
        }
    }

    public static int getNextMultipleOf3(int n) {
    		if (n % 3 == 0)
    			return n ;
    		return (n / 3 + 1) * 3;
    }
    
    public static void find(Node head, int noOfCoins) {
    		int remainder = noOfCoins - head.cost;
    		if (remainder < 0) {
    			System.out.println("smaller than 0: " + head.name);
    			return;
    		}
    		for (Node n : head.neighbours) {
    			if (n.cost == remainder) {
    				/* TODO */
    			}
    				
    		}
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. 
        
        
        find SUM of coins in tree
        find the next multiple of 3 bigger then SUM
        divide SUM with 3, to find the no of coins in a subtree: NO_of_coins
        start from root, search a child that has the no of
            coins smaller or equal to no_of_coins - crt_coins
          - continue this branch until no_of_coins is found
          - else, return to previous node and try another child
        */
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for (int test = 0; test < q; test++) {
            int n = in.nextInt();
            int costsSum = 0;
            Node[] nodes = new Node[n];

            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i+1, in.nextInt());
                costsSum += nodes[i].cost;
            }
            for (int i = 0; i < n-1; i++) {
                int node1 = in.nextInt()-1;
                int node2 = in.nextInt()-1;
                nodes[node1].addNeighbour(nodes[node2]);
                nodes[node2].addNeighbour(nodes[node1]);
            }
            int noOfCoins = getNextMultipleOf3(costsSum) / 3;
            System.out.println("noOfCoins: " + noOfCoins);
            System.out.println("costsSum: " + costsSum);

            for (int i = 0; i < nodes.length; i++)
            		System.out.println(nodes[i]);
        }
        
        System.out.println(getNextMultipleOf3(8));
        System.out.println(getNextMultipleOf3(9));
        in.close();
    }
}
