// 5.Find the starting node of a loop in a linked list.

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

    void createLoop(int pos)
    {
        if(pos==0)
        {
            return;
        }
        
        Node temp=head;
        Node loopNode=null;
        int count=1;

        while(temp.next!=null)
        {
            if(count==pos)
            {
                loopNode=temp;
            }
            temp=temp.next;
            count++;
        }
        temp.next=loopNode;
    }

    void findStartOfLoop()
    {
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast)
            {
                slow=head;
                while(slow!=fast)
                {
                    slow=slow.next;
                    fast=fast.next;
                }
                System.out.println("Starting node of loop: "+slow.data);
                return;
            }
        }
        System.out.println("No loop found");
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
        int pos=sc.nextInt(); // position where loop starts
        l.createLoop(pos);
        l.findStartOfLoop();
    }
}