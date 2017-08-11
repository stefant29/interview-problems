import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/30-linked-list
class Node {
	int data;
	Node next;
	Node(int d) {
        data = d;
        next = null;
    }
}

class Solution {
    public static  Node insert(Node head,int data) {
        if (head == null)
            return new Node(data);
        
        Node newNode = new Node(data);
        Node headCopy = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = newNode;
        return headCopy;
    }

	public static void display(Node head) {
        Node start = head;
        while(start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Node head = null;
        int N = sc.nextInt();

        while(N-- > 0) {
            int ele = sc.nextInt();
            head = insert(head,ele);
        }
        display(head);
        sc.close();
    }
}