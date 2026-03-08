// 2.Evaluate a postfix expression using a stack.

import java.util.*;
class Node 
{
    int data;
    Node next;
    Node(int val)
    {
        data=val;
        next=null;
    }
}
class Stack1
{
    Node top;
    Stack1()
    {
        top=null;
    }
    boolean isEmpty()
    {
        return top==null;
    }
    void push(int val)
    {
        // if(isEmpty())
        // {
        //     System.out.println("Stack is Empty...");
        //     return;
        // }
        Node newNode=new Node(val);
        newNode.next=top;
        top=newNode;
    }
    int pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty...");
            return 0;
        }
        int val=top.data;
        top=top.next;
        return val;
    }
    void peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty...");
            return;
        }
        System.out.println(top.data);
    }
    int postfixcal(String str)
    {
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(Character.isDigit(ch))
            {
                push(ch-'0');
            }
            else 
            {
                int val2=pop();
                int val1=pop();
                switch(ch)
                {
                    case '+':
                        push(val1+val2);
                        break;
                    case '-':
                         push(val1-val2);
                        break;
                    case '*':
                        push(val1*val2);
                        break;
                    case '/':
                        push(val1/val2);
                        break;
                }
            }
        } 
        return pop();
    }
}
public class Q2 
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        Stack1 s=new Stack1();
        String str=sc.nextLine();
        int a=s.postfixcal(str);
        System.out.print(a);
    }
}