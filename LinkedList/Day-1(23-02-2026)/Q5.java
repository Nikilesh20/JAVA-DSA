// 5.Find the nth node from the end of a Linked List.

import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int value)
    {
        data=value;
        next=null;
    }
}
class Linkedlist
{
    Node head;
    Linkedlist()
    {
        head=null;
    }

    void InsertAtEnd(int val)
    {
        Node newNode=new Node(val);
        if(head==null)
        {
            head=newNode;
            return;
        }
        Node temp=head;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=newNode;
    }

    void nth(int n)
    {
        Node slow=head;
        Node fast=head;
        for(int i=0;i<n;i++)
        {
            fast=fast.next;
        }

        while(fast!=null)
        {
            slow=slow.next;
            fast=fast.next;
        }
        System.out.println("Nth node from the end is "+slow.data);
    }
}
public class Q5 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Linkedlist l=new Linkedlist();
        int val=sc.nextInt();
        while(val!=-1)
        {
            l.InsertAtEnd(val);
            val=sc.nextInt();
        }
        int n=sc.nextInt();
        l.nth(n);
    }
}