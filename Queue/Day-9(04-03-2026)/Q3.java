// 3.Implement a circular queue using an array.

import java.util.Scanner;
class CircularQueue 
{
    int front = -1, rear = -1;
    int size;
    int arr[];

    CircularQueue(int n) 
    {
        size = n;
        arr = new int[size];
    }

    void enqueue(int val) 
    {
        if ((rear + 1) % size == front) 
        {
            System.out.println("Queue Overflow");
            return;
        }

        if (front == -1) 
        {
            front = rear = 0;
        } 
        else 
        {
            rear = (rear + 1) % size;
        }

        arr[rear] = val;
        System.out.println(val + " inserted");
    }

    void dequeue() 
    {
        if (front == -1) 
        {
            System.out.println("Queue Underflow");
            return;
        }

        System.out.println(arr[front] + " removed");

        if (front == rear) 
        {
            front = rear = -1;
        } 
        else 
        {
            front = (front + 1) % size;
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

        int i = front;
        while (true) 
        {
            System.out.print(arr[i] + " ");
            if (i == rear)
                break;
            i = (i + 1) % size;
        }
        System.out.println();
    }
}

public class Q3 
{
    public static void main(String[] args) 
    {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter queue size: ");
        int n = sc.nextInt();
        CircularQueue q = new CircularQueue(n);
        while (true) 
        {
            System.out.println("\n1.Enqueue 2.Dequeue 3.Peek 4.Display 5.Exit");
            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.print("Enter value: ");
                    int val = sc.nextInt();
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