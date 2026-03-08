// 2.Implement a Queue using a linked list.

import java.util.Scanner;
class Node 
{
    int data;
    Node next;
    Node(int val) 
    {
        data=val;
        next=null;
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
        if (rear==null) 
        {
            front=rear=newNode;
            return;
        }
        rear.next=newNode;
        rear=newNode;
    }

    void dequeue() 
    {
        if(front==null) 
        {
            System.out.println("Queue Underflow");
            return;
        }
        System.out.println(front.data+" removed from queue");
        front=front.next;
        if(front==null)
            rear=null;
    }

    void peek() 
    {
        if (front==null)
            System.out.println("Queue is empty");
        else
            System.out.println("Front element: "+front.data);
    }

    void display() 
    {
        if (front==null) 
        {
            System.out.println("Queue is empty");
            return;
        }
        Node temp=front;
        while (temp!=null) {
            System.out.print(temp.data + " ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class Q2 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Queue1 q=new Queue1();

        while (true) {
            System.out.println("\n1.Enqueue 2.Dequeue 3.Peek 4.Display 5.Exit");
            int choice=sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter value: ");
                    int val=sc.nextInt();
                    q.enqueue(val);
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.peek();
                    break;
                case 4:
                    q.display();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}