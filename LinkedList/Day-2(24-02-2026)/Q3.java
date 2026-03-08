// 3.Rotate a linked list to the left or right by k position.

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

    Node rotateleft(int k)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node temp=head;
        int count=1;
        while(temp.next!=null)
        {
            count++;
            temp=temp.next;
        }
        
        k=k%count; 
        if(k==0)
        {
            return head;
        }
        
        temp=head;
        for(int i=1;i<k;i++)
        {
            temp=temp.next;
        }
        Node newhead=temp.next;
        temp.next=null;
        
        temp=newhead;
        while(temp.next!=null)
        {
            temp=temp.next;
        }
        temp.next=head;
        head=newhead;
        return head;
    }

    Node rotateright(int k)
    {
        if(head==null || head.next==null)
        {
            return head;
        }
        Node temp=head;
        int count=1;
        while(temp.next!=null)
        {
            count++;
            temp=temp.next;
        }
        
        
        k=k%count;
        if(k==0)
        {
            return head;
        }
        
        temp.next=head;
        
        int right=count-k;
        temp=head;
        for(int i=1;i<right;i++)
        {
            temp=temp.next;
        }
        head=temp.next;
        temp.next=null;
    
        return head;
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
        while(true)
        {
            int choice=sc.nextInt();
            switch (choice) {
                case 1:
                    int k=sc.nextInt();
                    l.rotateleft(k);
                    l.display();
                    break;
                case 2:
                    int k1=sc.nextInt();
                    l.rotateright(k1);
                    l.display();
                    break;
                case 3:
                    return;
            }
        }
    }
}