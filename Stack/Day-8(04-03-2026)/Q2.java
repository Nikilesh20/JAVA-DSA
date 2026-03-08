// 2.Generate all possible  valid parentheses for a given number of pairs using a stack.

import java.util.Scanner;
class Node 
{
    String data;
    Node next;
    Node(String val) 
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

    void push(String val) 
    {
        Node newNode=new Node(val);
        newNode.next=top;
        top=newNode;
    }

    String pop() 
    {
        if(top==null)
            return null;

        String val=top.data;
        top=top.next;
        return val;
    }

    boolean isEmpty() 
    {
        return top==null;
    }

    void generateParentheses(int n) 
    {
        Stack1 s=new Stack1();
        s.push("");

        while(!s.isEmpty()) 
        {
            String current=s.pop();
            int open=0,close=0;
            for (int i=0;i<current.length();i++) 
            {
                if(current.charAt(i)=='(')
                    open++;
                else
                    close++;
            }

            if(current.length()==2*n) 
                {
                System.out.println(current);
                continue;
            }

            if(open<n)
                s.push(current+"(");

            if(close<open)
                s.push(current+")");
        }
    }
}
public class Q2 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        Stack1 s=new Stack1();
        System.out.print("Enter number of pairs: ");
        int n=sc.nextInt();
        s.generateParentheses(n);
    }
}