/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

// https://www.hackerrank.com/challenges/tree-preorder-traversal
void preOrder(Node root) {
    // base case, child of a leaf (null)
    if (root == null)
        return;
    
    // print the node's data prior to the children's data
    System.out.print(root.data + " ");

    // recursive call preOrder for both children
    preOrder(root.left);
    preOrder(root.right);
}
