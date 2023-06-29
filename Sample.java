/***
 Problem 1: implement-queue-using-stacks
 Time Complexity : O(n)
 Space Complexity : O(n)
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 Here, we are following the two stack approach.
 ***/

class MyQueue {
    public Stack<Integer> stk1 = new Stack<>();
    public Stack<Integer> stk2 = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        while(!stk1.isEmpty())
        {
            stk2.push(stk1.pop());
        }
        stk1.push(x);
        while(!stk2.isEmpty())
        {
            stk1.push(stk2.pop());
        }
    }

    public int pop() {
        if(!stk1.isEmpty())
        {
            return stk1.pop();
        }
        return -1;
    }

    public int peek() {
        if(!stk1.isEmpty())
        {
            return stk1.peek();
        }
        return -1;
    }

    public boolean empty() {
        return stk1.isEmpty();
    }
}

/***
 Problem 2:
 Time Complexity : O(1) - for all get(), put() and remove() methods.
 Space Complexity : O(n) - where n is the maximum possible value for the key.
 Did this code successfully run on Leetcode : Yes
 Any problem you faced while coding this : No
 Here, we are following the oversized array way to implement the hashmmap.
 ***/

class MyHashMap
{
    int[] map;

    public MyHashMap()
    {
        map = new int[1000001];
        Arrays.fill(map,-1);
    }

    public int get(int key)
    {
        return map[key];
    }

    public void put(int key, int value)
    {
        map[key] = value;
    }

    public void remove(int key)
    {
        map[key] = -1;
    }
}