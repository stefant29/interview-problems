/* you only have to complete the function given below.  
Node is defined as  

class Node {
    int data;
    Node left;
    Node right;
}

*/

// https://www.hackerrank.com/challenges/tree-postorder-traversal
void postOrder(Node root) {
    // base case, child of a leaf (null)
    if (root == null)
        return;

    // recursive call preOrder for both children
    postOrder(root.left);
    postOrder(root.right);
    
    // print the node's data after printing the children's data
    System.out.print(root.data + " ");
}
