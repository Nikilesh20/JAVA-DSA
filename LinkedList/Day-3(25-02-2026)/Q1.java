// 1.Swap two node in a linked list without swapping data.

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

    void swapNodes(int x,int y)
    {
        if(x==y)
        return;
        Node prevFirst=null, first=head;
        Node prevSecond=null, second=head;

        while(first!=null && first.data!=x)
        {
            prevFirst=first;
            first=first.next;
        }

        while(second!=null && second.data!=y)
        {
            prevSecond=second;
            second=second.next;
        }

        if(first==null || second==null)
        {
            System.out.println("Element not found");
            return;
        }

        if(prevFirst!=null)
        {
            prevFirst.next=second;
        }
        else
        {
            head=second;
        }
            
        if(prevSecond!=null)
        {
            prevSecond.next=first;
        }
        else
        {
            head=first;
        }
            
        Node a=first.next;
        Node b=second.next;

        first.next=b;
        second.next=a;
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
public class Q1
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
        int x=sc.nextInt();
        int y=sc.nextInt();
        l.swapNodes(x,y);
        l.display();
    }
}