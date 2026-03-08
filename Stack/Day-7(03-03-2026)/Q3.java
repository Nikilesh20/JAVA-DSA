// 3.Implement a min stack that supports push,pop,and retrievinng the minimum element in a constant time.

import java.util.Scanner;
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
	Node min;
	boolean isEmpty() 
	{
		return top==null;
	}
	void push(int val) 
	{
		Node newNode=new Node(val);
		newNode.next=top;
		top=newNode;
		if(min==null ||val<=min.data) 
		{
			Node newHead=new Node(val);
			newHead.next=min;
			min=newHead;
		}
	}
	int pop() 
	{
		if(isEmpty()) 
		{
			System.out.print("Stack is empty");
			return -1;
		}
		int val=top.data;
		top=top.next;
		if(val==min.data) 
		{
			min=min.next;
		}
		return val;
	}
	int getmin() 
	{
		if(min==null) 
		{
			System.out.print("Stack is empty");
			return -1;
		}
		return min.data;
	}
	void display() 
	{
		Node temp=top;
		while(temp!=null) 
		{
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}
}
public class Q3
{
	public static void main(String[] args) 
	{
		Scanner sc=new Scanner(System.in);
		Stack1 l=new Stack1();
		int n=sc.nextInt();
		for(int i=0; i<n; i++) 
		{
			int val=sc.nextInt();
			l.push(val);
		}//l.pop();

		l.display();
		System.out.println();
		System.out.print(l.getmin());
	}
}
