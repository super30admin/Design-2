// Problem 1
// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Implementing Queue using 2 Stacks
class MyQueue {
    Stack<Integer> queue1;
    Stack<Integer> queue2;
    /** Initialize your data structure here. */
    public MyQueue() {
        queue1 = new Stack<>();
        queue2 = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        queue1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!queue1.isEmpty()) {
            queue2.push(queue1.pop());
        }
        
        int front = queue2.pop();
        
        while (!queue2.isEmpty()) {
            queue1.push(queue2.pop());
        }
        
        return front;
    }
    
    /** Get the front element. */
    public int peek() {
        while (!queue1.isEmpty()) {
            queue2.push(queue1.pop());
        }
        
        int front = queue2.peek();
        
        while (!queue2.isEmpty()) {
            queue1.push(queue2.pop());
        }
        
        return front;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return queue1.isEmpty();
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


// Problem 2
// Time Complexity : O(1)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Implementing HashSet using HashMap
 class MyHashSet {
    Map<Integer, Integer> hashSet;
    /** Initialize your data structure here. */
    public MyHashSet() {
        hashSet = new HashMap<>();
    }
    
    public void add(int key) {
        if (!hashSet.containsKey(key)) {
            hashSet.put(key, 1);
        }
    }
    
    public void remove(int key) {
        if (hashSet.containsKey(key)) {
            hashSet.remove(key);
        }
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        return hashSet.containsKey(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */