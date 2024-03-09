using System;
using System.Collections.Generic;

namespace S30_Solutions
{
    class Program
    {
        static void Main(string[] args)
        {
            MyQueue obj2 = new MyQueue();
            obj2.Push(10);
            obj2.Push(20);
            int param_4 = obj2.Pop();
            int param_5 = obj2.Peek();
            bool param_6 = obj2.Empty();
            // =================================================================================================

            MyHashMap obj3 = new MyHashMap();
            obj3.Put(20, 30);
            int param_7 = obj3.Get(20);
            obj3.Remove(20);
        }
    }

    public class MyHashMap
    {

        public class Node
        {
            public Node Next;
            public int Key;
            public int Val;
            public Node(int key, int val)
            {
                this.Key = key;
                this.Val = val;
            }
        }

        Node[] Mymap;

        public int MyHashFunc(int key)
        {
            return key % 1000;
        }

        public MyHashMap()
        {
            Mymap = new Node[1000];
        }

        public Node Search(Node head, int key)
        {
            Node curr = head;
            Node prev = null;
            while (curr != null && curr.Key != key)
            {
                prev = curr;
                curr = curr.Next;
            }
            return prev;
        }

        public void Put(int key, int value)
        {
            int hashKey = MyHashFunc(key);
            Node AddNode;
            if (Mymap[hashKey] == null)
            {
                Mymap[hashKey] = new Node(-1, -1);
                AddNode = Mymap[hashKey];
            }
            else
            {
                AddNode = Search(Mymap[hashKey], key);
            }
            if (AddNode.Next == null) AddNode.Next = new Node(key, value);
            else AddNode.Next.Val = value;
        }

        public int Get(int key)
        {
            int hashKey = MyHashFunc(key);
            if (Mymap[hashKey] == null) return -1;
            Node SearchNode = Search(Mymap[hashKey], key);
            if (SearchNode.Next == null) return -1;
            return SearchNode.Next.Val;
        }

        public void Remove(int key)
        {
            int hashKey = MyHashFunc(key);
            if (Mymap[hashKey] == null) return;
            Node SearchNode = Search(Mymap[hashKey], key);
            if (SearchNode.Next == null) return;

            Node temp = SearchNode.Next;
            SearchNode.Next = SearchNode.Next.Next;
            temp.Next = null;
        }
    }

    public class MyQueue
    {
        Stack<int> inStack;
        Stack<int> outStack;
        public MyQueue()
        {
            inStack = new Stack<int>();
            outStack = new Stack<int>();
        }

        public void Push(int x)
        {
            inStack.Push(x);
        }

        public int Pop()
        {
            Peek();
            return outStack.Pop();
        }

        public int Peek()
        {
            if (outStack.Count == 0)
            {
                while (inStack.Count != 0)
                {
                    outStack.Push(inStack.Pop());
                }
            }
            return outStack.Peek();
        }

        public bool Empty()
        {
            return inStack.Count == 0 && outStack.Count == 0;
        }
    }
}
