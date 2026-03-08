// 5.Implement a program to split a linked list into k parts.

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

    void splitK(int k)
    {
        int length=0;
        Node temp=head;
        while(temp!=null)
        {
            length++;
            temp=temp.next;
        }

        int partSize=length/k;
        int extra=length%k;

        temp=head;
        for(int i=0;i<k;i++)
        {
            int currentSize=partSize;

            if(extra>0)
            {
                currentSize++;
                extra--;
            }

            Node partHead=temp;
            Node prev=null;
            for(int j=0;j<currentSize;j++)
            {
                prev=temp;
                if(temp!=null)
                temp=temp.next;
            }

            if(prev!=null)
            prev.next=null;

            displayPart(partHead);
        }
    }

    void displayPart(Node node)
    {
        while(node!=null)
        {
            System.out.print(node.data+" ");
            node=node.next;
        }
        System.out.println();
    }
}
public class Q5
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
        int k=sc.nextInt();
        l.splitK(k);
    }
}