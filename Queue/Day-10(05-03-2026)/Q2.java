// 2.Count the number of elements in a Queue.

import java.util.Scanner;
class Node 
{
    int data;
    Node next;
    Node(int val) 
    {
        data = val;
        next = null;
    }
}
class QueueLL 
{
    Node front, rear;
    void enqueue(int val) 
    {
        Node newNode = new Node(val);
        if (rear == null) 
        {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() 
    {
        if (front == null)
            return -1;

        int val = front.data;
        front = front.next;
        if (front == null)
            rear = null;
        return val;
    }

    void display() 
    {
        Node temp = front;
        while (temp != null) 
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    int countElements()
    {
        int count = 0;
        Node temp = front;
        while (temp != null) 
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
}

public class Q2 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        QueueLL q = new QueueLL();
        int n = sc.nextInt();
        while(n!=-1)
        {
            q.enqueue(n);
            n=sc.nextInt();
        }
        System.out.println("Queue elements:");
        q.display();

        System.out.println("Number of elements in queue: "+q.countElements());
    }
}