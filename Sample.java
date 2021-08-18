// Time Complexity: O(1)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, It took me a long time to implement,
// although I understood the push and pop concept.


// Your code here along with comments explaining your approach
class MyQueue {
    private Stack<Integer> stack1; //insertion
    private Stack<Integer> stack2; //deletion

    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) { //Pushes element x to the back of the queue.
        stack1.push(x);
        
    }
    
    public void pushToPop(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() { //Removes the element from the front of the queue and returns it.
        if(stack2.isEmpty()){
            pushToPop();
        }
        return  stack2.pop();
    }
    
    /** Get the front element. */
    public int peek() { //returns the element at the front of the queue.
        if(stack2.isEmpty()){
            pushToPop();
        }
        return stack2.peek();
        
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() { //Returns true if the queue is empty, false otherwise.
        return stack1.isEmpty() && stack2.isEmpty();
        
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


 // Time Complexity: O(1)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : No
// Any problem you faced while coding this : Yes, I couldn't figure out why I kept getting index out of bound error.

class MyHashSet {
    boolean [][] storage;
        int buckets;
        int bucketElements;

    /** Initialize your data structure here. */
    public MyHashSet() {
        buckets = 1000;
        bucketElements = 1000;
        storage = new boolean[buckets][];
        
    }
    
    private int bucket(int key){
        return key % buckets;
    }
    
    private int bucketElements(int key){
        return key / bucketElements;
    }
    
    public void add(int key) {
        int bucket = bucket(key);
        int bucketElements = bucketElements(key);
        if(storage[bucket] == null){
            if(bucket == 0){
                storage[bucket] = new boolean[bucketElements + 1];
            }
            else
            {
                storage[bucket] = new boolean[bucketElements];
            }
        }
        storage[bucket][bucketElements] = true;
    }
    
    public void remove(int key) {
        int bucket = bucket(key);
        int bucketElements = bucketElements(key);
        if(storage[bucket] == null) return;
        storage[bucket][bucketElements] = false;
        
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int bucket = bucket(key);
        int bucketElements = bucketElements(key);
        if(storage[bucket] == null) return false;
        return storage[bucket][bucketElements];    
        
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */