/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

// https://www.hackerrank.com/challenges/tree-inorder-traversal
void inOrder(Node root) {
    // base case, child of a leaf (null)
    if (root == null)
        return;

    // recursive call preOrder for left child
    inOrder(root.left);
    
    // print the node's data between printing the children's data
    System.out.print(root.data + " ");
    
    // recursive call preOrder for right child
    inOrder(root.right);
}
