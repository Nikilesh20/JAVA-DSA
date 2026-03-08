// 2.Search for a given value in a linked list.

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

    void findvalue(int key)
    {
        if(head==null)
        {
            System.out.println("No data found");
            return;
        }
        // if(head.data==key)
        // {
        //     System.out.println(head.data+"is found");
        //     return;
        // }
        Node temp=head;
        while(temp.next!=null)  
        {
            if(temp.data==key)
            {
                System.out.println(temp.data+" is found");
                return;
            }
            temp=temp.next;
        }
        System.out.println("No data found");
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
public class Q2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Linkedlist l=new Linkedlist();
        int val=sc.nextInt();
        while(val!=-1)
        {
            l.InsertAtEnd(val);
            val=sc.nextInt();
        }
        int key=sc.nextInt();
        l.display();
        l.findvalue(key);
    }
}