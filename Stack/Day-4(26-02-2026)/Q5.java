// 5.Design a stack that supports middle element retrieval and deletion in O(1).

import java.util.Scanner;
class Node
{
    int data;
    Node prev;
    Node next;
    Node(int value)
    {
        data = value;
        prev = null;
        next = null;
    }
}

class Stack1
{
    Node top;
    Node mid;
    int count;
    Stack1()
    {
        top = null;
        mid = null;
        count = 0;
    }

    void push(int val)
    {
        Node newNode = new Node(val);
        newNode.next = top;

        if(top != null)
            top.prev = newNode;

        top = newNode;
        count++;

        if(count == 1)
            mid = newNode;
        else if(count % 2 != 0) // move mid back when count is odd
            mid = mid.prev;
    }

    int pop()
    {
        if(top == null)
        {
            System.out.println("Stack is empty...");
            return -1;
        }
        int val = top.data;
        top = top.next;

        if(top != null)
            top.prev = null;

        count--;

        if(count % 2 == 0 && mid != null)
            mid = mid.next;
        return val;
    }

    int findMiddle()
    {
        if(mid == null)
        {
            System.out.println("Stack is empty...");
            return -1;
        }
        return mid.data;
    }

    int deleteMiddle()
    {
        if(mid == null)
        {
            System.out.println("Stack is empty...");
            return -1;
        }
        int val = mid.data;
        if(mid.prev != null)
            mid.prev.next = mid.next;

        if(mid.next != null)
            mid.next.prev = mid.prev;

        if(count % 2 == 0)
            mid = mid.next;
        else
            mid = mid.prev;

        count--;
        return val;
    }

    void display()
    {
        Node temp = top;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class Q5
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Stack1 s = new Stack1();
        int val = sc.nextInt();
        while(val != -1)
        {
            s.push(val);
            val = sc.nextInt();
        }
        System.out.println("Middle element: " + s.findMiddle());
        System.out.println("Deleted middle: " + s.deleteMiddle());
        System.out.println("Middle after deletion: " + s.findMiddle());
        System.out.print("Stack elements: ");
        s.display();
    }
}