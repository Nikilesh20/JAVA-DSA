// 2.Convert a infix expression to postfix expression.

import java.util.Scanner;
class Node
{
    char data;
    Node addr;
    Node(char value)
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

    void push(char val)
    {
        Node newNode=new Node(val);
        newNode.addr=top;
        top=newNode;
    }

    char pop()
    {
        if(top==null)
        {
            System.out.println("Stack is empty...");
            return '0';
        }
        char popped=top.data;
        top=top.addr;
        return popped;
    }

    char peek()
    {
        if(top==null)
            return '0';

        return top.data;
    }

    int precedence(char op)
    {
        if(op=='+' || op=='-')
            return 1;

        if(op=='*' || op=='/')
            return 2;

        if(op=='^')
            return 3;

        return 0;
    }

    String infixToPostfix(String exp)
    {
        String postfix="";
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(Character.isLetterOrDigit(ch))
            {
                postfix+=ch;
            }
            else if(ch=='(')
            {
                push(ch);
            }
            else if(ch==')')
            {
                while(top!=null && peek()!='(')
                {
                    postfix+=pop();
                }
                pop();
            }
            else
            {
                while(top!=null && precedence(peek())>=precedence(ch))
                {
                    postfix+=pop();
                }
                push(ch);
            }
        }
        while(top!=null)
        {
            postfix+=pop();
        }
        return postfix;
    }
}
public class Q2
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Stack1 s=new Stack1();
        String str=sc.nextLine();
        String result=s.infixToPostfix(str);
        System.out.println(result);
    }
}