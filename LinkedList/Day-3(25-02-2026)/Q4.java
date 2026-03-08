// 4.Detect a loop in a linked list and remove it.

import java.util.*;
class Node
{
    int data;
    Node next;
    Node(int value)
    {
        data = value;
        next = null;
    }
}
class Linkedlist
{
    Node head;
    Linkedlist()
    {
        head = null;
    }
    void InsertAtEnd(int val)
    {
        Node newNode = new Node(val);
        if(head == null)
        {
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void createLoop(int pos)
    {
        if(pos == 0)
        {
            return;
        } 
        Node temp = head;
        Node loopNode = null;
        int count = 1;

        while(temp.next != null)
        {
            if(count == pos)
            {
                loopNode = temp;
            }
            temp = temp.next;
            count++;
        }
        temp.next = loopNode;
    }

    void detectAndRemoveLoop()
    {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            {
                slow = head;
                while(slow.next != fast.next)
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                fast.next = null;

                System.out.println("Loop detected and removed");
                return;
            }
        }
        System.out.println("No loop found");
    }

    void display()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Q4
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Linkedlist l = new Linkedlist();
        int val = sc.nextInt();
        while(val != -1)
        {
            l.InsertAtEnd(val);
            val = sc.nextInt();
        }
        int pos = sc.nextInt(); // position to create loop
        l.createLoop(pos);
        l.detectAndRemoveLoop();
        l.display();
    }
}