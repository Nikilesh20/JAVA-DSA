// 2.Check if a linked list is a palindrome.

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

    Node findmid()
    {
        Node slow=head;
        Node fast=head;
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    Node reverse(Node mid)
    {
        Node temp=mid;
        Node prev=null;
        Node next=null;
        while(temp!=null)
        {
            next=temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }

    void checkpalindrome(Node half)
    {
        Node first=head;
        Node second=half;
        while(second!=null)
        {
            if(first.data!=second.data)
            {
                System.out.println("Not Palindrome");
                return;
            }
            first=first.next;
            second=second.next;
        }
        System.out.println("Palindrome");
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
        Node mid=l.findmid();
        Node half=l.reverse(mid);
        l.checkpalindrome(half);
    }
}