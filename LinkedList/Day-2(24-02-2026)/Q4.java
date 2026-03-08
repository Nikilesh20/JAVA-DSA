// 4.Sort a linked list using merge sort.

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

    Node findmid(Node head)
    {
        Node slow=head;
        Node fast=head.next;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    Node merge(Node left, Node right)
    {
        if(left==null)
        {
            return right;
        }
        if(right==null)
        {
            return left;
        }
        Node result;

        if(left.data <= right.data)
        {
            result=left;
            result.next=merge(left.next,right);
        }
        else
        {
            result=right;
            result.next=merge(left,right.next);
        }
        return result;
    }

    Node mergesort(Node head)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node mid=findmid(head);
        Node half=mid.next;

        mid.next=null;

        Node left=mergesort(head);
        Node right=mergesort(half);

        return merge(left,right);
    }

    void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class Q4
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Linkedlist l=new Linkedlist();
        int val=sc.nextInt();
        while(val!=-1)
        {
            l.InsertAtEnd(val);
            val=sc.nextInt();
        }
        l.head=l.mergesort(l.head);
        l.display();
    }
}