// 3.Rotate a queue to the left by k positions.

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

    boolean isEmpty() 
    {
        return front == null;
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

    void rotateLeft(int k) 
    {
        for (int i = 0; i < k; i++) 
        {
            int val = dequeue();
            if (val != -1)
                enqueue(val);
        }
    }
}
public class Q3 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        QueueLL q = new QueueLL();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) 
        {
            q.enqueue(sc.nextInt());
        }
        System.out.print("Enter k value: ");
        int k = sc.nextInt();
        q.rotateLeft(k);
        System.out.println("Queue after left rotation:");
        q.display();
    }
}