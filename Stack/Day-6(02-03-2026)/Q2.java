// 2.Implement a stack using a Linked List.

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
class Stack1
{
    Node top;
    Stack1()
    {
        top=null;
    }

    void push(int val)
    {
        Node newNode=new Node(val);
        newNode.addr=top;
        top=newNode;
    }

    void pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            return;
        }

        int val=top.data;
        top=top.addr;
        System.out.println("Popped element: "+val);
    }

    int peek()
    {
        if(isEmpty())
        {
            return -1;
        }
        return top.data;
    }

    boolean isEmpty()
    {
        return top==null;
    }

    void display()
    {
        if(isEmpty())
        {
            System.out.println("Stack is empty");
            return;
        }
        Node temp=top;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.addr;
        }
        System.out.println();
    }
}
public class Q2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Stack1 s=new Stack1();
        int ch;
        do
        {
            System.out.println("\n1 Push");
            System.out.println("2 Pop");
            System.out.println("3 Peek");
            System.out.println("4 Display");
            System.out.println("5 Check Empty");
            System.out.println("6 Exit");

            System.out.print("Enter choice: ");
            ch = sc.nextInt();

            switch(ch)
            {
                case 1:
                    System.out.print("Enter value: ");
                    int val=sc.nextInt();
                    s.push(val);
                    break;
                case 2:
                    s.pop();
                    break;
                case 3:
                    int x=s.peek();
                    if(x==-1)
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Top element: " + x);
                    break;
                case 4:
                    s.display();
                    break;
                case 5:
                    if(s.isEmpty())
                        System.out.println("Stack is empty");
                    else
                        System.out.println("Stack is not empty");
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        } while(ch != 6);
    }
}