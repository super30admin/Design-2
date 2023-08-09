//Problem 1

// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// This implimentation of hashmap has an array of 10000 slots in the primary
// array where each slot gets up to 100 buckets of storage to deal with collisions
// which is stored in a linked list.
// When a collision is detected, it adds a node to the linked list. A find method
// is used to search for a node, since each has method needs to search in the linked
// list. 
class MyHashMap {
    class Node{
        int key;
        int val;
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    private Node[] primaryArray;
    public MyHashMap() {
        primaryArray = new Node[10000];
    }
    private int hash(int key){
        return key%10000;
    }
    private Node find(Node head, int key){
        Node prev = null;
        Node temp = head;
        while(temp != null && temp.key != key){
            prev = temp;
            temp = temp.next;
        }
        return prev;
    }
    public void put(int key, int value) {
        int bucket = this.hash(key);
        if(primaryArray[bucket] == null){
            primaryArray[bucket] = new Node(-1, -1);
        }
        Node prev = find(primaryArray[bucket],key);
        //case 1: Node does not exist. Create new node
        if(prev.next == null){
            prev.next = new Node(key, value);
        }
        //case 2: Node already exists. Update value
        else{
            prev.next.val = value;
        }
    }
    
    public int get(int key) {
        int bucket = this.hash(key);
        if(primaryArray[bucket] == null){
            return -1;
        }
        Node prev = find(primaryArray[bucket],key);
        if(prev.next == null)return -1;
        return prev.next.val;
    }
    
    public void remove(int key) {
        int bucket = this.hash(key);
        if(primaryArray[bucket] == null){
            return;
        }
        Node prev = find(primaryArray[bucket],key);
        if(prev.next == null)return;
        else{
            prev.next = prev.next.next;
        }
    }
}



//Problem 2

// Time Complexity : O(1) average, O(n) worst case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// The general idea is that I am using a secondary stack where
// elements can be pushed to from popped elements in the first stack.
// Before pushing elements onto the second stack, I check to make sure 
// that it's not empty first.

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    public void push(int x) {
        stack1.push(x);
    }
    
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }
    
    public boolean empty() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.isEmpty();
    }
}