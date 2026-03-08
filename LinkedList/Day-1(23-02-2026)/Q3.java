// 3.Reverse a singly Linkedlist.

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

    Node reverse()
    {
        Node temp=head;
        Node prev=null;
        Node next=null;
        while(temp!=null)
        {
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        head=prev;
        return head;
    }

    void display()
    {
        if(head==null)
        {
            System.out.println("List is empty...");
            return;
        }
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class Q3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Linkedlist l=new Linkedlist();
        int val=sc.nextInt();
        while(val!=-1)
        {
            l.InsertAtEnd(val);
            val=sc.nextInt();
        }
        l.reverse();
        l.display();
    }
}