// 1.Implement a stack using an array.

import java.util.*;
class Stack1
{
    int arr[];
    int top;
    int size;
    Stack1(int n)
    {
        size=n;
        arr=new int[size];
        top=-1;
    }

    void push(int val)
    {
        if(top==size-1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top]=val;
    }

    void pop()
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
            return;
        }
        System.out.println("Deleted: "+arr[top--]);
    }

    void display()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return;
        }
        for(int i=top;i>=0;i--)
        {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}
public class Q1
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter stack size: ");
        int n=sc.nextInt();
        Stack1 s=new Stack1(n);
        while(true)
        {
            System.out.println("\n1 Push");
            System.out.println("2 Pop");
            System.out.println("3 Display");
            System.out.println("4 Exit");

            System.out.print("Enter choice: ");
            int ch=sc.nextInt();

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
                    s.display();
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}