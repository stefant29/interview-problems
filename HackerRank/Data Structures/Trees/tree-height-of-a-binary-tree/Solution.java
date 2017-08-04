import java.util.*;
import java.io.*;

// https://www.hackerrank.com/challenges/tree-height-of-a-binary-tree
class Node {
    Node left;
    Node right;
    int data;
    
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class Solution {
	static int height(Node root) {
        // base case: a child of a leaf
      	if (root == null)
            return -1;
        
        // compute iteratively the height of left child and right child
        // and add 1 for the current node
        return Math.max(height(root.left), height(root.right)) + 1;
    }
	public static Node insert(Node root, int data) {
        if(root == null){
            return new Node(data);
        }
        else {
            Node cur;
            if(data <= root.data){
                cur = insert(root.left, data);
                root.left = cur;
            }
            else{
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0){
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        int height = height(root);
        System.out.println(height);
    }	
}