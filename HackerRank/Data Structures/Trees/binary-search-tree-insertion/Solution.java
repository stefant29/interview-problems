 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

// https://www.hackerrank.com/challenges/binary-search-tree-insertion
    static Node Insert(Node root,int value) {
        // keep a copy of the start of the tree
        Node start = root;

        // create a new node and set its data to value
        Node insertedNode = new Node();
        insertedNode.data = value;

        // if the tree is empty, return the new node
        if (root == null)
            return insertedNode;

        // traverse the tree
        while (root != null) {
            // if the value searched is already present, break
            if (root.data == value)
                break;
            // if the curent data is smaller then value, advance right
            else if (root.data < value) {
                // if there is no right child, set the right child to the new node
                if (root.right == null) {
                    root.right = insertedNode;
                    break;
                } else
                    // else advance right
                    root = root.right;
            }
            // else, the curent data is bigger then value, advance left
            else {
                // if there is no left child, set the left child to the new node
                if (root.left == null) {
                    root.left = insertedNode;
                    break;
                } else
                    // else advance left
                    root = root.left;
            }
        }
        
        // return the copy to the head of the tree
        return start;     
    }
