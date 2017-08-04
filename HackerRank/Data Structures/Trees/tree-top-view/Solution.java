   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */

// https://www.hackerrank.com/challenges/tree-top-view
    void topView(Node root) {
        // if current node is null, there is nothing to print, return
        if (root == null)
            return;
        // print the left side of the tree
        printLeft(root.left);
        // print the current data
        System.out.print(root.data + " ");
        // print the right side of the tree
        printRight(root.right);
    }

    void printRight(Node root) {
        // if current node is null, there is nothing to print, return
        if (root == null)
            return;
        // print data first
        System.out.print(root.data + " ");
        // then go to right child
        printRight(root.right);
    }

    void printLeft(Node root) {
        // if current node is null, there is nothing to print, return
        if (root == null)
            return;
        // first traverse the left children
        printLeft(root.left);
        // then print data
        System.out.print(root.data + " ");
     }
