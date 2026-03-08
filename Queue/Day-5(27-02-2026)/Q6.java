// 7.Find the  first non-repeating character in a stream of characters using a queue.

import java.util.*;
class Node
{
    char data;
    Node addr;
    Node(char val)
    {
        data=val;
        addr=null;
    }
}
class Queue1
{
    Node front,rear;
    Queue1()
    {
        front=rear=null;
    }

    void enqueue(char val)
    {
        Node newNode=new Node(val);

        if(rear==null)
        {
            front=rear=newNode;
            return;
        }
        rear.addr=newNode;
        rear=newNode;
    }

    void dequeue()
    {
        if(front==null)
            return;

        front=front.addr;

        if(front==null)
            rear=null;
    }

    char peek()
    {
        if(front==null)
            return '0';

        return front.data;
    }

    boolean isEmpty()
    {
        return front==null;
    }

    void firstNonRepeating(String str)
    {
        int freq[]=new int[256];

        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            freq[ch]++;
            enqueue(ch);
            while(!isEmpty() && freq[peek()]>1)
            {
                dequeue();
            }
            if(isEmpty())
                System.out.print("-1 ");
            else
                System.out.print(peek() + " ");
        }
    }
}
public class Q6
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        Queue1 q=new Queue1();
        String str=sc.nextLine();
        q.firstNonRepeating(str);
    }
}