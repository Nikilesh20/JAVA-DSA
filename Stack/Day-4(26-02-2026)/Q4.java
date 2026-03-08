// 4.Sort a stack using a recursion

import java.util.Scanner;
class Node
{
    int data;
    Node addr;
    Node(int value)
    {
        this.data=value;
        this.addr=null;
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

    int pop()
    {
        if(top==null)
        {
            System.out.println("Stack is empty...");
            return 0;
        }
        int popped=top.data;
        top=top.addr;
        return popped;
    }

    boolean isEmpty()
    {
        return top==null;
    }

    void sortedInsert(int x)
    {
        if(isEmpty() || x>top.data)
        {
            push(x);
            return;
        }
        int temp=pop();
        sortedInsert(x);
        push(temp);
    }

    void sortStack()
    {
        if(!isEmpty())
        {
            int x=pop();
            sortStack();
            sortedInsert(x);
        }
    }

    void display()
    {
        Node temp=top;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
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
        Stack1 s=new Stack1();
        int val=sc.nextInt();
        while(val!=-1)
        {
            s.push(val);
            val=sc.nextInt();
        }
        s.sortStack();
        s.display();
    }
}