// 5.Reverse a queue using recursion.

import java.util.*;
class Node
{
    int data;
    Node addr;
    Node(int val)
    {
        data=val;
        addr=null;
    }
}
class Queue1
{
    Node front,rear;
    Queue1()
    {
        front=rear=null;
    }

    void enqueue(int val)
    {
        Node newNode=new Node(val);
        if(rear==null)
        {
            front=rear=newNode;
            return;
        }
        else
        {
            rear.addr=newNode;
            rear=newNode;
        }
    }

    int dequeue()
    {
        if(front==null)
        {
            return -1;
        }

        int val=front.data;
        front=front.addr;

        if(front==null)
        {
            rear=null;
        }
        return val;
    }

    void reverse()
    {
        if(front==null)
            return;

        int val=dequeue();
        reverse();
        enqueue(val);
    }

    void display()
    {
        if(front==null)
        {
            System.out.println("Queue is empty");
            return;
        }
        Node temp=front;
        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp=temp.addr;
        }
        System.out.println();
    }
}
public class Q5
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Queue1 q=new Queue1();
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int val=sc.nextInt();
            q.enqueue(val);
        }
        q.reverse();
        q.display();
    }
}