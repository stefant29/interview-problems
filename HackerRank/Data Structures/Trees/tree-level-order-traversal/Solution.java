   /* 
    
    class Node 
       int data;
       Node left;
       Node right;
   */

// https://www.hackerrank.com/challenges/tree-level-order-traversal
    void levelOrder(Node root) {
        // use a queue for BFS traversal
        Queue<Node> queue = new LinkedList<Node>();
        // add the root to the queue
		queue.add(root);
        // while there are nodes in the queue
		while (!queue.isEmpty()) {
            // extract the first node
			Node aux = queue.poll();
            // print current node's data
            System.out.print(aux.data + " ");
            // if a left child exists, add it to the queue
            if (aux.left != null)
                queue.add(aux.left);
            // if a right child exists, add it to the queue
            if (aux.right != null)
                queue.add(aux.right);
		}
    }
