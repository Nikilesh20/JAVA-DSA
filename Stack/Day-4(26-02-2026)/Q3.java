// 3.Evaluate a postfix expression using a stack.

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

    int evaluatePostfix(String exp)
    {
        for(int i=0;i<exp.length();i++)
        {
            char ch=exp.charAt(i);
            if(Character.isDigit(ch))
            {
                push(ch-'0');
            }
            else
            {
                int val2=pop();
                int val1=pop();

                int result=0;

                if(ch=='+')
                    result=val1+val2;
                else if(ch=='-')
                    result=val1-val2;
                else if(ch=='*')
                    result=val1*val2;
                else if(ch=='/')
                    result=val1/val2;

                push(result);
            }
        }
        return pop();
    }
}
public class Q3
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Stack1 s=new Stack1();
        String str=sc.nextLine();
        int result=s.evaluatePostfix(str);
        System.out.println(result);
    }
}