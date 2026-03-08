// 4.Implementation of a Double-ended Queue(Enqueue and Dequeue).

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
    Node front, rear;
    Queue1()
    {
        front=rear=null;
    }

    void insertRear(int val)
    {
        Node newNode=new Node(val);
        if(rear==null)
        {
            front=rear=newNode;
            return;
        }
        rear.addr=newNode;
        rear=newNode;
    }

    void insertFront(int val)
    {
        Node newNode=new Node(val);
        if(front==null)
        {
            front=rear=newNode;
        }
        else
        {
            newNode.addr=front;
            front=newNode;
        }
    }

    void deleteFront()
    {
        if(front==null)
        {
            System.out.println("Deque is empty");
            return;
        }
        front=front.addr;
        if(front==null)
            rear=null;
    }

    void deleteRear()
    {
        if(rear==null)
        {
            System.out.println("Deque is empty");
            return;
        }

        if(front==rear) // only one node
        {
            front=rear=null;
            return;
        }

        Node temp=front;
        while(temp.addr!=rear)
        {
            temp=temp.addr;
        }
        temp.addr=null;
        rear=temp;
    }

    void display()
    {
        if(front==null)
        {
            System.out.println("Deque is empty");
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

public class Q4
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Queue1 q=new Queue1();

        while(true)
        {
            System.out.println("\n1 Insert Front");
            System.out.println("2 Insert Rear");
            System.out.println("3 Delete Front");
            System.out.println("4 Delete Rear");
            System.out.println("5 Display");
            System.out.println("6 Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter value: ");
                    int val1=sc.nextInt();
                    q.insertFront(val1);
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    int val2=sc.nextInt();
                    q.insertRear(val2);
                    break;
                case 3:
                    q.deleteFront();
                    break;
                case 4:
                    q.deleteRear();
                    break;
                case 5:
                    q.display();
                    break;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}





/*



import java.util.Scanner;
class Node 
{
    Node prev;
	int data;
	Node next;
	Node(int val) 
	{
	    prev=null;
		data=val;
		next=null;
	}
}
class Doublylinkedlist
{
	Node front;
	Node rear;
	boolean isEmpty() 
	{
		return front==null;
	}
	void Insertfront(int val) 
	{
		Node newNode=new Node(val);
		if(front==null) 
		{
			front=rear=newNode;
			return;
		}
		newNode.next=front;
		front.prev=newNode;
		front=newNode;
	}
	void Insertrear(int val) 
	{
		Node newNode=new Node(val);
		if(rear==null) 
		{
			front=rear=newNode;
			return;
		}
		rear.next=newNode;
		newNode.prev=rear;
		rear=newNode;
	}
	void dequefront()  
	{
		if(isEmpty()) 
		{
			System.out.print("Queue is empty");
			return;
		}
		if(front==rear) 
		{
			front=rear=null;
		} 
		else 
		{
			front=front.next;
			front.prev=null;
		}
	}
	void dequerear() 
	{
		if(isEmpty()) 
		{
			System.out.print("Queue is empty");
			return;
		}
		if(front==rear) 
		{
			front=rear=null;
		}
		else 
		{
			rear=rear.prev;
			rear.next=null;
		}
	}
	void display() 
	{
		if(isEmpty()) 
		{
			System.out.print("Queue is empty");
			return;
		}
		Node temp=front;
		while(temp!=null) 
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
}
public class Main 
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Doublylinkedlist l=new Doublylinkedlist();
		int n=sc.nextInt();
		for(int i=0; i<n; i++) 
		{
			int val=sc.nextInt();
// 			l.Insertrear(val);
            l.Insertfront(val);
		}
// 		l.dequerear();
        l.dequefront();
		l.display();
	}
}





*/