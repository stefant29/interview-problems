

 /* Node is defined as :
 class Node 
    int data;
    Node left;
    Node right;
    
    */

// https://www.hackerrank.com/challenges/binary-search-tree-lowest-common-ancestor
    static Node lca(Node root,int v1,int v2) {
        // if node is null, return null
        if (root == null)
            return root;
        // order the two given values in new variables min and max
        int min = Math.min(v1, v2);
        int max = Math.max(v1, v2);
        // call worker method to find the lowest common ancestor
        return findLCA(root, min, max);
    }

    static Node findLCA(Node root, int min, int max) {
        // if node is null, return null
        if (root == null)
            return root;
        
        // if current data is to the minimum node's right
        if (root.data >= min) {
            // and is to the maximum node's left
            if (root.data <= max)
                // then this is the lowest common ancestor
                return root;
            else
                // else repeat the algorithm for left child
                return lca(root.left, min, max);
        } else
            // else repeat the algorithm for right child
            return lca(root.right, min, max);
    }


