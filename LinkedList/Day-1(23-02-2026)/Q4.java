// 4.Merge two sorted linked lists into a single sorted list.

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

    Node merge(Node head1,Node head2)
    {
        if(head1==null)
        {
            return head2;
        }
        if(head2==null)
        {
            return head1;
        }
        Node head;
        if(head1.data<=head2.data)
        {
            head=head1;
            head1=head1.next;
        }
        else
        {
            head=head2;
            head2=head2.next;
        }
        Node temp=head;
        while(head1!=null && head2!=null)
        {
            if(head1.data<=head2.data)
            {
                temp.next=head1;
                head1=head1.next;
            }
            else
            {
                temp.next=head2;
                head2=head2.next;
            }
            temp=temp.next;
        }
        if(head1!=null)
        {
            temp.next=head1;
        }
        else
        {
            temp.next=head2;
        }
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
public class Q4 {
    public static void main(String[] args) {
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
        l1.display();
        l2.display();
        Linkedlist result=new Linkedlist();
        result.head=result.merge(l1.head,l2.head);
        result.display();
    }
}


