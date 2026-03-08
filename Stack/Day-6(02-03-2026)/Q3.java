// 3.Reverse a string useing a stack.

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
    void push(char ch)
    {
        Node newNode=new Node(ch);
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
    void peek()
    {
        if(isEmpty())
        {
            System.out.println("Stack is Empty...");
            return;
        }
        System.out.println("Peek elements are: "+top.data);
    }
    String reverse(String str)
    {
        String result="";
        for(int i=0;i<str.length();i++)
        {
            push(str.charAt(i));
        }
        while(!isEmpty())
        {
            result+=pop();
        }
        return result;
    }
}
public class Q3
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Stack1 s=new Stack1();
		String str=sc.nextLine();
		String result=s.reverse(str);
		System.out.println(result);
	}
}
