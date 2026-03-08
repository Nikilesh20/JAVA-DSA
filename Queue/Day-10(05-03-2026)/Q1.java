// 1.Reverse a queue using a stack.

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
class StackLL 
{
    Node top;

    void push(int val) 
    {
        Node newNode = new Node(val);
        newNode.next = top;
        top = newNode;
    }

    int pop() 
    {
        if (top == null)
            return -1;

        int val = top.data;
        top = top.next;
        return val;
    }

    boolean isEmpty() 
    {
        return top == null;
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
}
public class Q1 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        QueueLL q = new QueueLL();
        StackLL s = new StackLL();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter queue elements:");
        for (int i = 0; i < n; i++) 
        {
            q.enqueue(sc.nextInt());
        }

        // Reverse queue using stack
        while (!q.isEmpty())
        {
            s.push(q.dequeue());
        }

        while (!s.isEmpty()) 
        {
            q.enqueue(s.pop());
        }
        System.out.println("Reversed Queue:");
        q.display();
    }
}