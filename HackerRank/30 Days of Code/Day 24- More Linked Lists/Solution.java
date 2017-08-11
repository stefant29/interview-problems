import java.io.*;
import java.util.*;

// https://www.hackerrank.com/challenges/30-linked-list-deletion
class Node{
	int data;
	Node next;
	Node(int d){
        data=d;
        next=null;
    }
	
}

class Solution {
    public static Node removeDuplicates(Node head) {
        Node copyHead = head;
        Node prev = head;
        HashSet<Integer> values = new HashSet<Integer>();
        while (head != null) {
            if (values.add(head.data) == false)
                prev.next = head.next;
            else
                prev = head;
            head = head.next;
        }
        return copyHead;
    }

    public static  Node insert(Node head,int data) {
        Node p=new Node(data);			
        if(head==null)
            head=p;
        else if(head.next==null)
            head.next=p;
        else {
            Node start=head;
            while(start.next!=null)
                start=start.next;
            start.next=p;

        }
        return head;
    }

    public static void display(Node head) {
		Node start=head;
		while(start!=null) {
		  System.out.print(start.data+" ");
		  start=start.next;
		}
	}

    public static void main(String args[]) {
		Scanner sc=new Scanner(System.in);
		Node head=null;
		int T=sc.nextInt();
		while(T-->0){
		  int ele=sc.nextInt();
		  head=insert(head,ele);
		}
		head=removeDuplicates(head);
		display(head);

  	}
}


