// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
// The implementation is based on linear chaining.
// The linear chaining here consists of array of pointers(one pointer to each hash key) and
// each pointer points to a single linked list . This linked list stores keys for a specific hash key 
class MyHashMap {
    int buckets;
    Node[] storage;
    class Node{
        int key;
        int value;
        Node next;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        this.buckets = 10000;
        this.storage = new Node[buckets]; 
    }

    // Time Complexity : O(1)
    // Space Complexity : O(1)
    private int getHash(int key)
    {
        return key % buckets;
    }
    
    // Time Complexity : Average - 0(1)
    // Space Complexity : O(1)
    private Node getPrev(Node head, int key)
    {
        Node prev = null;
        Node curr = head;
        while(curr != null && curr.key != key)
        {
            prev = curr;
            curr = curr.next;
        }
        return prev;
    }

    // Time Complexity : Average- O(1)
// Space Complexity : O(1)
    public void put(int key, int value) {
        int index = getHash(key);
        if(storage[index]==null){
            storage[index] = new Node(-1,-1);
            storage[index].next = new Node(key,value);
            return;
        }
        Node prev = getPrev(storage[index],key);
        if(prev.next == null){
            prev.next = new Node(key,value);
        }
        else
        {
            prev.next.value = value;
        }
    }
 
    // Time Complexity : Average- O(1)
// Space Complexity : O(1)
    public int get(int key) {
        int index = getHash(key);
        if(storage[index]==null){
            return -1;
        }
        Node prev = getPrev(storage[index],key);
        if(prev.next == null)
        {
            return -1;
        }
        else
        {
            return prev.next.value;
        }
    }
 // Time Complexity : Average- O(1)
// Space Complexity : O(1)   
    public void remove(int key) {
        int index = getHash(key);
        if(storage[index]==null) return;
        Node prev = getPrev(storage[index],key);
        if(prev.next == null){
            return;
        }else
        {
            Node curr = prev.next;
            prev.next = curr.next;
            curr.next = null;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */



 

// As per the requirement, the queue is implemented using two stacks.
// Instead of juggling between stacks after each push/pop, we fix one stack to main peek and pop operations
// and other stack to main push() operations. Once the main peek and pop stack() becomes empty,
// we move the elements from main push() stack into this stack.
class MyQueue {
Stack<Integer> inStack ;
Stack<Integer> outStack;
    public MyQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }
    
        // Time Complexity : O(1)
    // Space Complexity : O(1)
    public void push(int x) {
        inStack.push(x);
    }
        // Time Complexity :Average- O(1)
    // Space Complexity : O(1)
    public int pop() {
        peek();
        return outStack.pop();
    }
    
        // Time Complexity : Average-O(1)
    // Space Complexity : O(1)
    public int peek() {
        if(outStack.size()==0)
        {
            while(inStack.size()>0)
            {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }
    
        // Time Complexity : O(1)
    // Space Complexity : O(1)
    public boolean empty() {
        return inStack.size()==0 && outStack.size()==0;
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