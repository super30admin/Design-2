# Design-2

## Problem 1: (https://leetcode.com/problems/implement-queue-using-stacks/)
// Time Complexity : O(1) for push and pop, peek() averages to O(1)
// Space Complexity : O(1) - not using any extra space except that required for the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A -Followed algorithm taught in class.


// Your code here along with comments explaining your approach
class MyQueue {

    //implementing queue using two stacks
    private Stack<Integer> s;
    private Stack<Integer> sRev;
   
    
    public MyQueue() {
         s= new Stack<>();
        sRev= new Stack<>();    
    }
    
    public void push(int x) {
        s.push(x);
        
    }
    
    public int pop() {
        peek();
        return sRev.pop();
        
    }
    
    public int peek() {
        if(sRev.isEmpty())
        {
            while(!s.isEmpty())
            {
                sRev.push(s.pop());
            }
        }
        
        return sRev.peek();
        
    }
    
    public boolean empty() {
        
        return ( s.isEmpty() && sRev.isEmpty());
        
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */


## Problem 2:(https://leetcode.com/problems/design-hashset/)
// Time Complexity : All functions are O(1)
// Space Complexity : O(1) - not using any extra space except that required for the input
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A -Followed algorithm taught in class.


// Your code here along with comments explaining your approach
class MyHashSet {
    
    private boolean arrayForBuckets[][];
    private int primaryArraySize;
    private int bucketSize;
    
    public MyHashSet() {
        primaryArraySize = 1000;
        bucketSize = 1000;
        //Initialize the array that holds all the values
        arrayForBuckets = new boolean[primaryArraySize][];
    }
    
    private int primaryHSIndex(int key)
    {
        return key% primaryArraySize;
    }
    
    private int secondaryHSIndex(int key)
    {
        return key/bucketSize;
    }
    
    public void add(int key) {
        
        int indexHS1 = primaryHSIndex(key);
        int indexHS2 = secondaryHSIndex(key);
        if(arrayForBuckets[indexHS1] == null)
        {
            if(indexHS1 ==0)
            {
                //handle the edge case of 10^6
                arrayForBuckets[indexHS1] = new boolean[bucketSize+1];

            }
            else
            {
                arrayForBuckets[indexHS1] = new boolean[bucketSize];
            }
           
           
        }
         //this element exists 
         arrayForBuckets[indexHS1][indexHS2] = true;
    }
    
    public void remove(int key) {
        
        int indexHS1 = primaryHSIndex(key);
        int indexHS2 = secondaryHSIndex(key);
        if(arrayForBuckets[indexHS1]!= null)
        {
             arrayForBuckets[indexHS1][indexHS2] = false;
        }    
        
        
    }
    
    public boolean contains(int key) {
        int indexHS1 = primaryHSIndex(key);
        int indexHS2 = secondaryHSIndex(key);
        if(arrayForBuckets[indexHS1]!= null)
        {
             return arrayForBuckets[indexHS1][indexHS2];
        }  
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */










