import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/30-binary-search-trees
class Node{
    Node left,right;
    int data;
    Node(int data){
        this.data=data;
        left=right=null;
    }
}

class Solution{
	/* wrapper for computing the height of a tree */
    public static int getHeight(Node root){
        return (root == null) ? 0 : 
            Math.max(getHeightRec(root.right), getHeightRec(root.left));
    }

    /* recursive method to compute the height of a tree */
    public static int getHeightRec(Node root) {
        return (root == null) ? 0 : 
            1 + Math.max(getHeightRec(root.right), getHeightRec(root.left));
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
            int height=getHeight(root);
            System.out.println(height);
        }	
}