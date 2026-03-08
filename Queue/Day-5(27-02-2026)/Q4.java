// 4.Display the elements of a queue without using a loop(recursion-based).

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
        }
        rear.addr=newNode;
        rear=newNode;
    }

    void dequeue()
    {
        if(front==null)
        {
            System.out.println("Queue is empty");
            return;
        }
        front=front.addr;
        if(front==null)
            rear=null;
    }

    void display()
    {
        if(front==null)
        {
            System.out.println("Queue is empty");
            return;
        }
        displayRec(front);
        System.out.println();
    }

    void displayRec(Node temp)
    {
        if(temp==null)
            return;

        System.out.print(temp.data + " ");
        displayRec(temp.addr);
    }
}
public class Q4
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
        q.display();
    }
}