import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/30-binary-trees
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

class Solution{
    	static void levelOrder(Node root){
        Queue<Node> nodes = new LinkedList<Node>();
        nodes.add(root);
        /* add all nodes from a level in the queue while printing their data
         * extract nodes from the queue until the queue is empty
         * and repeat the process
         */
        while (!nodes.isEmpty()) {
            /* extract node */
            Node n = nodes.poll();
            /* add its children to the queue */
            if (n.left != null)
                nodes.add(n.left);
            if (n.right != null)
                nodes.add(n.right);
            /* print the extracted node's data */
            System.out.print(n.data + " ");
        }
      
    }

public static Node insert(Node root,int data){
        if(root==null){
            return new Node(data);
        }
        else{
            Node cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    public static void main(String args[]){
            Scanner sc=new Scanner(System.in);
            int T=sc.nextInt();
            Node root=null;
            while(T-->0){
                int data=sc.nextInt();
                root=insert(root,data);
            }
            levelOrder(root);
        }	
}