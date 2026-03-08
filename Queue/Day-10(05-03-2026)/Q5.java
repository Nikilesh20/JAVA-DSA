// 5.Sort elements in a queue(recursion-based).

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

    int size()
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

    void sortedInsert(int x) 
    {
        int n = size();
        boolean inserted = false;
        for (int i = 0; i < n; i++) 
        {
            int val = dequeue();
            if (!inserted && x < val) 
            {
                enqueue(x);
                inserted = true;
            }
            enqueue(val);
        }
        if (!inserted)
            enqueue(x);
    }

    void sortQueue() 
    {
        if (!isEmpty()) 
        {
            int x = dequeue();
            sortQueue();
            sortedInsert(x);
        }
    }
}
public class Q5 
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
        q.sortQueue();
        System.out.println("Sorted Queue:");
        q.display();
    }
}