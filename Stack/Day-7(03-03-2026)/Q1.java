// 1.Convert an infix expression to postfix expression.

import java.util.*;
class Node 
{
    char data;
    Node next;
    Node(char val)
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
    void push(char val)
    {
        Node newNode=new Node(val);
        newNode.next=top;
        top=newNode;
    }
    char pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty...");
            return '0';
        }
        char val=top.data;
        top=top.next;
        return val;
    }
    char peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty...");
            return '0';
        }
        return top.data;
    }
    int precedende(char ch)
    {
        if(ch=='+' || ch=='-')
          return 1;
        if(ch=='*' || ch=='/')
          return 2;
        if(ch=='^')
          return 3;
        return -1;
    }
    String infixtopostfix(String str)
    {
        String result="";
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                result+=ch;
            }
            else if(ch=='(')
            {
                push(ch);
            }
            else if(ch==')')
            {
                while(!isEmpty() && peek()!='(')
                {
                    result+=pop();
                }
                pop();
            }
            else 
            {
                while(!isEmpty() && precedende(peek())>=precedende(ch))
                {
                    result+=pop();
                }
                push(ch);
            }
        }
        while(!isEmpty())
        {
            result+=pop();
        }
        return result;
    }
}
public class Q1
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        Stack1 s=new Stack1();
        String str=sc.nextLine();
        String result=s.infixtopostfix(str);
        System.out.print(result);
    }
}