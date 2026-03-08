// 3.Implementation of a priority Queue.

import java.util.*;
class Node
{
    int data;
    int priority;
    Node addr;
    Node(int val, int p)
    {
        data=val;
        priority=p;
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

    void enqueue(int val,int p)
    {
        Node newNode=new Node(val, p);
        if(front==null || p>front.priority)
        {
            newNode.addr=front;
            front=newNode;
            if(rear==null)
                rear=newNode;
            return;
        }

        Node temp=front;
        while(temp.addr!=null && temp.addr.priority>=p)
        {
            temp=temp.addr;
        }

        newNode.addr=temp.addr;
        temp.addr=newNode;

        if(newNode.addr==null)
            rear=newNode;
    }

    int dequeue()
    {
        if(front==null)
        {
            System.out.println("Priority Queue is empty");
            return -1;
        }
        int val=front.data;
        front=front.addr;
        if(front==null)
            rear=null;
        return val;
    }

    void display()
    {
        if(front==null)
        {
            System.out.println("Priority Queue is empty");
            return;
        }
        Node temp=front;
        while(temp!=null)
        {
            System.out.print(temp.data + "(" + temp.priority + ") ");
            temp=temp.addr;
        }
        System.out.println();
    }
}
public class Q3
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Queue1 pq=new Queue1();
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int val=sc.nextInt();
            int p=sc.nextInt();
            pq.enqueue(val, p);
        }
        pq.display();
        System.out.println("Dequeue element: " + pq.dequeue());
        System.out.println("Queue after dequeue:");
        pq.display();
    }
}