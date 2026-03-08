// 3.Implement a function to add two numbers represented by linked list.

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

    Node addNumbers(Node h1, Node h2)
    {
        Node result=null;
        Node tail=null;
        int carry=0;

        while(h1!=null || h2!=null || carry!=0)
        {
            int sum=carry;
            if(h1!=null)
            {
                sum+=h1.data;
                h1=h1.next;
            }

            if(h2!=null)
            {
                sum+=h2.data;
                h2=h2.next;
            }

            Node newNode=new Node(sum%10);
            carry=sum/10;

            if(result==null)
            {
                result=newNode;
                tail=newNode;
            }
            else
            {
                tail.next=newNode;
                tail=newNode;
            }
        }

        return result;
    }

    void display(Node head)
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
public class Q3
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Linkedlist l1=new Linkedlist();
        Linkedlist l2=new Linkedlist();
        int val=sc.nextInt();
        while(val!=-1)
        {
            l1.InsertAtEnd(val);
            val=sc.nextInt();
        }
        val=sc.nextInt();
        while(val!=-1)
        {
            l2.InsertAtEnd(val);
            val=sc.nextInt();
        }
        Linkedlist result=new Linkedlist();
        result.head=result.addNumbers(l1.head,l2.head);
        result.display(result.head);
    }
}