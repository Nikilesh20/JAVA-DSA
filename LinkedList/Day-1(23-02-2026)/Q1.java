// 1.Count the number of nodes in a linked list.

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

    void findlength()
    {
        if(head==null)
        {
            System.out.println("0");
            return;
        }
        int count=0;  //count =1
        Node temp=head;
        while(temp!=null)  //while(temp.next!=null)
        {
            temp=temp.next;
            count++;
        }
        System.out.println(count);
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
public class Q1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Linkedlist l=new Linkedlist();
        int val=sc.nextInt();
        while(val!=-1)
        {
            l.InsertAtEnd(val);
            val=sc.nextInt();
        }
        l.display();
        l.findlength();
    }
}