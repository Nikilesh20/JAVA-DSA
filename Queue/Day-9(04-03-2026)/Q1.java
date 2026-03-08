// 1.Implement a Queue using an array.

import java.util.Scanner;
class QueueArray 
{
    int front = -1;
    int rear = -1;
    int size;
    int arr[];

    QueueArray(int n) 
    {
        size = n;
        arr = new int[size];
    }

    void enqueue(int val) 
    {
        if (rear == size - 1) 
        {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1)
            front = 0;

        arr[++rear] = val;
        System.out.println(val + " inserted");
    }


    void dequeue() 
    {
        if (front == -1 || front > rear) 
        {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(arr[front] + " removed");
        front++;

        if (front > rear) 
        {
            front = rear = -1;
        }
    }


    void peek() 
    {
        if (front == -1)
            System.out.println("Queue is empty");
        else
            System.out.println("Front element: " + arr[front]);
    }


    void display() 
    {
        if (front == -1) 
        {
            System.out.println("Queue is empty");
            return;
        }

        for (int i = front; i <= rear; i++) 
        {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class Q1 
{
    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter queue size: ");
        int n = sc.nextInt();

        QueueArray q = new QueueArray(n);

        while (true) 
            {
            System.out.println("\n1.Enqueue 2.Dequeue 3.Peek 4.Display 5.Exit");
            int choice = sc.nextInt();

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