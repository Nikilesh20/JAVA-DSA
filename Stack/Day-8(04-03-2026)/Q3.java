// 3.Design an LRU Cache using a stack and hash map.

//Design an LRU cache using a stck and a hash map

import java.util.*;
import java.util.HashMap;
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
    void push(int val)
    {
        Node newNode=new Node(val);
        newNode.next=top;
        top=newNode;
    }
    
    void remove(int val)
    {
        if(top==null)
        {
            return;
        }
        if(top.data==val)
        {
            top=top.next;
            return;
        }
        
        Node prev=top;
        Node curr=top.next;
        
        while(curr!=null && curr.data!=val)
        {
            prev=curr;
            curr=curr.next;
        }
        
        if(curr!=null)
        {
            prev.next=curr.next;
        }
    }
    
    
    int removeBottom()
    {
        if(top==null)
        {
            return -1;
        }
        
        if(top.next==null)
        {
            int val=top.data;
            top=null;
            return val;
        }
        
        Node prev=null;
        Node curr=top;
        
        while(curr.next!=null)
        {
            prev=curr;
            curr=curr.next;
        }
        prev.next=null;
        return curr.data;
    }
}

class LRUCache
{
    int capacity;
    HashMap<Integer,Integer>map;
    Stack1 s;
    
    
    LRUCache(int cap)
    {
        capacity=cap;
        map=new HashMap<>();
        s=new Stack1();
    }
    
    int get(int key)
    {
        if(!map.containsKey(key))
        {
            return -1;
        }
        
        s.remove(key);
        s.push(key);
        
        
        return map.get(key);
    }
    
    
    void put(int key,int val)
    {
        if(map.containsKey(key))
        {
            map.put(key,val);
            s.remove(key);
            s.push(key);
        }
        else 
        {
            if(map.size()==capacity)
            {
                int lru=s.removeBottom();
                map.remove(lru);
            }
            map.put(key,val);
            s.push(key);
        }
    }
    
    void display()
    {
        Node temp=s.top;
        while(temp!=null)
        {
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}
public class Q3
{
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        
        int capacity=sc.nextInt();
        LRUCache cache=new LRUCache(capacity);
        
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String op=sc.next();
            if(op.equals("put"))
            {
                int key=sc.nextInt();
                int val=sc.nextInt();
                cache.put(key,val);
            }
            else if(op.equals("get"))
            {
               int key=sc.nextInt();
               
               System.out.println(cache.get(key));
            }
        }
        cache.display();
    }
}