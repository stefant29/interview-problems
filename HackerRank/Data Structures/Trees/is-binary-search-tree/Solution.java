/* The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

// https://www.hackerrank.com/challenges/is-binary-search-tree
    // Auxilliar method to print a tree
    void printNode(Node root) {
        if (root == null)
            return;

        // print current's node data
        System.out.println(root.data);
        
        // check if children exists and store their values
        int leftVal = -1;
        int rightVal = -1;
        if (root.left != null)
            leftVal = root.left.data;
        if (root.right != null)
            rightVal = root.right.data;
        
        // print children's data
        System.out.println(leftVal + "   " + rightVal);
        System.out.println();

        // print the children's nodes as well
        printNode(root.left);
        printNode(root.right);
    }

    // recursive method which checks if the current node's data is between the min and max values given
    boolean helper(Node root, int min, int max) {
        // if null, nothing to be done
        if (root == null)
            return true;

        // if the node's data is not in range, return false; the tree is not BST
        if (root.data <= min || root.data >= max)
            return false;

        // find if children are also BST
        return helper(root.left, min, root.data) && helper(root.right, root.data, max);
    }

    // wrapper method for finding if a tree is BST
    boolean checkBST(Node root) {
        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
