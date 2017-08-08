/*  
   class Node
      public  int frequency; // the frequency of this tree
       public  char data;
       public  Node left, right;
    
*/

// https://www.hackerrank.com/challenges/tree-huffman-decoding
/* 
 * time complexity: O(n)
 * space complexity: constant
*/
void decode(String s, Node root) {
    int i = 0;
    /* if list is empty, do not print anything on at STDOUT */
    if (root == null)
        return;
    
    /* iterate through the string */
    while (i < s.length()) {
        /* use a copy of the root */
        Node aux = root;
        /* traverse the tree until the curent node's data is different than '\0' */
        while (aux.data == '\0') {
            char c = s.charAt(i);
            /* if current char is 0, advance to the left child */
            if (c == '0')
                aux = aux.left;
            /* else, if current char is 1, advance to the right child */
            else if (c == '1')
                aux = aux.right;
            i++;
        }
        /* since the current node it is a leaf, print its data */
        System.out.print(aux.data);
    }
}

